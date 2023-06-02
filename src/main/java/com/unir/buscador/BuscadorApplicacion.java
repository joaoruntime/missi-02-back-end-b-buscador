package com.unir.buscador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuscadorApplicacion {

	public static void main(String[] args) {
		SpringApplication.run(BuscadorApplicacion.class, args);
		System.out.println(System.getenv("PORT"));
	}

}
