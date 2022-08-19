package br.com.tom.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping("/")
public class CloudParkingApplication {

	public static void main(String[] args) {

		SpringApplication.run(CloudParkingApplication.class, args);
	}

}
