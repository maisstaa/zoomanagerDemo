package de.volkswagen.zoomanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("de.volkswagen.zoomanager.repositories")
@EntityScan("de.volkswagen.zoomanager.models")
@SpringBootApplication
public class ZoomanagerApplication {

	public static void main(String[] args) {

		SpringApplication.run(ZoomanagerApplication.class, args);

		
		DataBaseServiceImpl database = context.getBean(DataBaseServiceImpl.class);

	}

}
