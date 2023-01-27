package com.github.cicd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

@Component
public class FirestoreRepository {

	@Value("${app.repo-settings.collection.name}")
	private String collectionName;

	private Firestore firestore;
	private ObjectMapper objectMapper;

	@Autowired
	public FirestoreRepository(Firestore firestore, ObjectMapper objectMapper) {
		this.firestore = firestore;
		this.objectMapper = objectMapper;
	}

	private CollectionReference getCollection() {
		return firestore.collection(collectionName);
	}

	public Map<String, String> getAllDocuments() {
		Map<String, String> map = new HashMap<>();
		ApiFuture<QuerySnapshot> query = getCollection().get();
		QuerySnapshot querySnapshot;
		try {
			querySnapshot = query.get();
			List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
			for (QueryDocumentSnapshot document : documents) {
				map.put(document.getString("name"), document.getString("email"));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		return map;
	}

}
