package com.github.cicd;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@Autowired
	private FirestoreRepository repo;

	@GetMapping("/")
	public String home() {
		String hostName = "Default";
		try {
			hostName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
		}
		return "Welcome to Firestore App[host: " + hostName + "]";
	}

	@GetMapping("/docs")
	public Map<String, String> getAllDocs() {
		return repo.getAllDocuments();
	}

}
