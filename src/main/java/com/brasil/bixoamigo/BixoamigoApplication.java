package com.brasil.bixoamigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class BixoamigoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BixoamigoApplication.class, args);
	}

}
