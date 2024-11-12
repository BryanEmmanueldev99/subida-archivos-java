package com.file.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		int numeros[] = {1,2,3,4,5,6,7,8,9,10};

		for(int numero: numeros) {
			 System.out.println(numero);
		}

		System.out.println(numeros[2]);
	}

}
