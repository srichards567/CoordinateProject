package com.example.eventsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EventsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventsApiApplication.class, args);
	}

	@GetMapping("/")
	public String home() {
		return "events API homepage";
	}

}
