package com.miguelmartin.proyectoBase;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoBaseApplication {

	public static void main(String[] args) {
		
				
		SpringApplication.run(ProyectoBaseApplication.class, args);
		

		//Abrir en navegador http://localhost:8080/base/show
		 openHomePage();
    }

	private static void openHomePage(){
		Runtime rt = Runtime.getRuntime();
		try {
			rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8080/agenda/show");
		} catch (IOException e) {e.printStackTrace();}
	}
}
