package org.example.steampowered.service;

import org.example.steampowered.pojo.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;

import java.util.concurrent.ExecutionException;

@Service
public class GameDbService {
    
    private final Firestore firestore;

    @Autowired
    public GameDbService(Firestore firestore) {
        this.firestore = firestore;
    }

    public String saveGame(Game game) throws InterruptedException, ExecutionException {
        ApiFuture<WriteResult> writeResult = firestore.collection("games").document(game.getAppId()).set(game);
        return writeResult.get().getUpdateTime().toString();
    }

    public Game getGameById(String appId) throws InterruptedException, ExecutionException {
        DocumentReference docRef = firestore.collection("games").document(appId);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();

        if(document.exists()){
            return document.toObject(Game.class);
        }else {
            return null;
        }
    }

    public boolean exists(String appId) throws InterruptedException, ExecutionException {
        DocumentReference docRef = firestore.collection("games").document(appId);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        return document.exists();
    }

    public void 
}
