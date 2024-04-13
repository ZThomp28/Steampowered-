package org.example.steampowered.service;

import java.util.concurrent.ExecutionException;

import org.example.steampowered.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.auto.service.AutoService;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.cloud.firestore.WriteResult;

@Service
public class UserDbService {
    
    private final Firestore firestore;

    @Autowired
    public UserDbService(Firestore firestore) {
        this.firestore = firestore;
    }

    public String saveUser(User user) throws InterruptedException, ExecutionException {
        ApiFuture<WriteResult> writeResult = firestore.collection("users").document(user.getSteamID()).set(user);
        return writeResult.get().getUpdateTime().toString();
    }

    public boolean exists(String steamId) throws InterruptedException, ExecutionException {
        DocumentReference docRef = firestore.collection("users").document(steamId);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        return document.exists();
    }
}
