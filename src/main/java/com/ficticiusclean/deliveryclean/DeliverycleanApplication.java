package com.ficticiusclean.deliveryclean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Delivery Clean API", version = "1.0", description = "Delivery Clean API"))
public class DeliverycleanApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliverycleanApplication.class, args);
	}

}
