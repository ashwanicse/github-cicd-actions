package com.github.cicd;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ComGithubCicdActionsApplication {

	@GetMapping("/home")
	public String home() {
		String hostName = "Default";
		try {
			hostName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return "Welcome on docker actions. - hostName: " + hostName;
	}

	public static void main(String[] args) {
		SpringApplication.run(ComGithubCicdActionsApplication.class, args);
	}

}
