package io.github.ilyxahobby.CensureService;

import io.github.ilyxahobby.CensureService.config.CredentialProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(CredentialProperties.class)
public class CensureServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CensureServiceApplication.class, args);
	}

}
