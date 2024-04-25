package fr.uphf.bienImmo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BienImmoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BienImmoApplication.class, args);
	}

}
