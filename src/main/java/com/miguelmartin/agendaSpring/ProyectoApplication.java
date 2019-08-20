package com.miguelmartin.agendaSpring;

import java.io.IOException;
import java.net.Socket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.miguelmartin.agendaSpring.constantes.Consts;

@SpringBootApplication
public class ProyectoApplication {
	
	static ConfigurableApplicationContext ctx;
	public static void main(String[] args) {
		
		if(availablePort(Consts.puerto)) {
			ctx = SpringApplication.run(ProyectoApplication.class, args);	
		}
		
		//Abrir en navegador http://localhost:8040/mis-contactos
		 openHomePage(Consts.direccion);
    }

	private static void openHomePage(String web){
		Runtime rt = Runtime.getRuntime();
		try {
			rt.exec("rundll32 url.dll,FileProtocolHandler " + web);
		} catch (IOException e) {e.printStackTrace();}
	}
	
	private static boolean availablePort(int port) {
	    try (Socket ignored = new Socket("localhost", port)) {
	        return false;
	    } catch (IOException ignored) {
	        return true;
	    }
	}
	
	public static void salir() {
		ctx.close();
	}
	
}
