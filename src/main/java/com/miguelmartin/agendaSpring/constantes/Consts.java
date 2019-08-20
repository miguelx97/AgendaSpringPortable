package com.miguelmartin.agendaSpring.constantes;

public class Consts {
	
		/////VISTAS/////
	
	public static String show = "mis-contactos";
	public static String form = "formulario-contacto";
	public static String redirectShow = "redirect:/mis-contactos";
	
	
		/////SERVIDOR/////
	public static int puerto = 8040;
	public static String dominio = "http://localhost:"+puerto;
	public static String direccion = dominio+"/"+show;
	
}
