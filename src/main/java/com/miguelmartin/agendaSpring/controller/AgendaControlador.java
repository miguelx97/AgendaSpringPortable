package com.miguelmartin.agendaSpring.controller;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.miguelmartin.agendaSpring.ProyectoApplication;
import com.miguelmartin.agendaSpring.constantes.Consts;
import com.miguelmartin.agendaSpring.modelo.Contacto;
import com.miguelmartin.agendaSpring.persistencia.Servicios;

@Controller
public class AgendaControlador {

	private static final Log LOG = LogFactory.getLog(new Object(){}.getClass().getEnclosingClass());
	
	@Autowired
    private Servicios servicios;
	
	@GetMapping("/mis-contactos")
	public ModelAndView show() {
		log(new Object(){});
		ModelAndView mav = new ModelAndView(Consts.show);
		
		mav.addObject("contactos", servicios.findAll());
		return mav;
	}
	
	@GetMapping("/formulario-contacto")
	public ModelAndView irGestion(@RequestParam(name="id", required=false) int id) {
		log(new Object(){}, id);
		ModelAndView nav = new ModelAndView(Consts.form);
		Optional<Contacto> contacto = null;
		if(id != 0) {
			contacto = servicios.findById(id);
			nav.addObject("contacto", contacto);
		} else {
			nav.addObject("contacto", new Contacto());
		}
		
		return nav;
	}

	@PostMapping("/addEdit")
	private String addOrEdit(@ModelAttribute(name="contacto") Contacto contacto, Model model) {
		log(new Object(){}, contacto);
		
		if(null != servicios.save(contacto)) {
			model.addAttribute("result", 1);
		} else {
			model.addAttribute("result", 0);
		}
		
		return Consts.redirectShow;
	}
	
	@GetMapping("/remove")
	private String remove(@RequestParam(name="id", required=true) int id) {
		log(new Object(){}, id);
		servicios.deleteById(id);
		return Consts.redirectShow;
	}
	
	@GetMapping("/salir")
	public void salir() {
		log(new Object(){});
		ProyectoApplication.salir();
	}
	
	private static void log(Object object) {
		log(object, null);
	}
	
	private static void log(Object object, Object param) {
		String log = object.getClass().getEnclosingMethod().getName();
		if (param != null) {
			log += " - Param: " + param.toString();
		}
		LOG.info(log);
		
	}
	
}
