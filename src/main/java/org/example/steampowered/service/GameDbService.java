package org.example.steampowered.service;

import org.example.steampowered.pojo.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

import java.util.ArrayList;
import java.util.HashMap;
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
   

    public ArrayList<Game> getAllGames() throws InterruptedException, ExecutionException { 
        CollectionReference collectionRef = firestore.collection("games");
        ApiFuture<QuerySnapshot> future = collectionRef.get();       
        ArrayList<Game> games = new ArrayList<>();   

        for (DocumentSnapshot document : future.get()) {
            Game category = document.toObject(Game.class);
            games.add(category);
        }
        
        return games;
    }

    public HashMap<String, Game> getAllGamesAsMap() throws InterruptedException, ExecutionException {
        CollectionReference collectionRef = firestore.collection("games");
        ApiFuture<QuerySnapshot> future = collectionRef.get();       
        HashMap<String , Game> games = new HashMap<>(); 
        
        for (DocumentSnapshot document : future.get()) {
            Game game = document.toObject(Game.class);
            if(game != null) {
                games.put(game.getAppId(), game);
            }            
        }
        
        return games;
    }

    
}
