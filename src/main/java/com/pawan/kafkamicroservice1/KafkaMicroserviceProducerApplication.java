package com.pawan.kafkamicroservice1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaMicroserviceProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaMicroserviceProducerApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
		return args -> {
			for(int i=0; i < 1000000; i++) {
				kafkaTemplate.send("kafkaProducer" , "Oooo Dhanno , OO Dhanno " + i);
			}
		};
	}

}
