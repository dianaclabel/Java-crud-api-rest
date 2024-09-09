package com.dianaclabel.apirest.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//Decorador o anotacion -> que hace la config inicila por defecto de springboot y asi trbajar bajo las reglas de Spring boot
@SpringBootApplication
public class ApirestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApirestApplication.class, args);
		System.out.println("hola");
	}

}
