package com.example.webstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class WebStoreApplication {

	public static void main(String[] args) {
		SpringApplication
				.run(WebStoreApplication.class,
						args);

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String pass = "12345";
		String encodePass = passwordEncoder.encode(pass);

		System.out.println("Password: " + pass);
		System.out.println("Encoded Password: " + encodePass);
	}

}
