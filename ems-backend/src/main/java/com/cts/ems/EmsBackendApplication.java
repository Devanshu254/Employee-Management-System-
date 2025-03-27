package com.cts.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // It enables - component scanning, auto configuration and configuration.
public class EmsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsBackendApplication.class, args);
	}

}
