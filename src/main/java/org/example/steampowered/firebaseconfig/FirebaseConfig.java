package org.example.steampowered.firebaseconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;


@Configuration
public class FirebaseConfig {

    @Bean
    public FirebaseInitialization firebaseInitialization() {
        return new FirebaseInitialization();
    }    
    
    // Waits until the Initialization is done before grabbing the Firestore Object
    @Bean
    @DependsOn("firebaseInitialization")
    public Firestore firestore() {
        return FirestoreClient.getFirestore();
    }
}
