package com.kafka.demo.amoeba;

import com.kafka.demo.amoeba.producer.EventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AmoebaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmoebaApplication.class, args);
	}

	@Autowired
	EventProducer producer;

	@PostMapping("/create/event")
	public void createEvent(){
		producer.sendEvent();
	}
}
