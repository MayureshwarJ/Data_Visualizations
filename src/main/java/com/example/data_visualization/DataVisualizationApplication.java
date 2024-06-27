package com.example.data_visualization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DataVisualizationApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(DataVisualizationApplication.class, args);

	}

	@GetMapping(value = "/")
	public String sayHello () {
		return  "hello Spring Boot";
	}

}
