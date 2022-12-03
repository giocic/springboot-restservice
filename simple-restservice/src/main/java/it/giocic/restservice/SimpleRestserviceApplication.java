package it.giocic.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // This annotation contains @Configuration, @EnableAutoConfiguration and @ComponentScan
public class SimpleRestserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleRestserviceApplication.class, args);
	}

}
