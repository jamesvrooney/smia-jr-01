package com.jamesvrooney.licensing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class LicensingServiceApplication {

	@Value("${spring.datasource.password}")
	private static String databasePassword;

	public static void main(String[] args) {
		log.info("BEFORE: {}", databasePassword);
		SpringApplication.run(LicensingServiceApplication.class, args);
		log.info("AFTER: {}", databasePassword);
	}
}
