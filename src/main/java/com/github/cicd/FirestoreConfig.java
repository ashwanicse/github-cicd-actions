package com.github.cicd;

import java.io.IOException;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

//import com.google.api.gax.core.CredentialsProvider;
//import com.google.api.gax.retrying.RetrySettings;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;

@Service
public class FirestoreConfig {
	@Value("${app.repo-settings.project}")
	private String dataProject;

	//@Autowired
	//private CredentialsProvider credentialsProvider;
	
	@Bean
	public Firestore generateFirestore() throws IOException {
		FirestoreOptions firestoreOptions = 
				FirestoreOptions.getDefaultInstance().toBuilder()
				.setProjectId(dataProject)
				.setCredentials(GoogleCredentials.getApplicationDefault())
				.build();
		Firestore db = firestoreOptions.getService();
		return db;
	}
	

/*
	@Bean
	public Firestore generateFirestore(RetrySettings retrySettings) throws IOException {
		return FirestoreOptions.newBuilder().setProjectId(dataProject)
				.setCredentials(credentialsProvider.getCredentials()).setRetrySettings(retrySettings).build()
				.getService();
	}
	*/
}
