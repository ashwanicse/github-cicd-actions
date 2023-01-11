package com.github.cicd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ComGithubCicdActionsApplication {
	
	@GetMapping("/home")
	public String home() {
		return "Welcome on docker actions.";
	}

	public static void main(String[] args) {
		SpringApplication.run(ComGithubCicdActionsApplication.class, args);
	}

}
