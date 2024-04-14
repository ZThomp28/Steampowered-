package org.example.steampowered.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.example.steampowered.pojo.FailedCall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

@Service
public class FailedCallService {
    
    private final Firestore firestore;

    @Autowired
    public FailedCallService(Firestore firestore) {
        this.firestore = firestore;
    }

    public String saveFailedCall(FailedCall failedCall) throws InterruptedException, ExecutionException {
        ApiFuture<WriteResult> writeResult = firestore.collection("failed_games").document(failedCall.getAppId()).set(failedCall);
        return writeResult.get().getUpdateTime().toString();
    }

    public boolean failedCallExists(String appId) throws InterruptedException, ExecutionException {
        DocumentReference docRef = firestore.collection("failed_games").document(appId);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        return document.exists();
    }

    public ArrayList<FailedCall> getAllFailedCalls() throws InterruptedException, ExecutionException {
        CollectionReference collectionRef = firestore.collection("failed_games");
        ApiFuture<QuerySnapshot> future = collectionRef.get();       
        ArrayList<FailedCall> failedGames = new ArrayList<>();  

        for (DocumentSnapshot document : future.get()) {
            FailedCall fc = document.toObject(FailedCall.class);
            failedGames.add(fc);
        }
        
        return failedGames;
    }

    
    public HashMap<String, FailedCall> getAllFailedCallsAsMap() throws InterruptedException, ExecutionException {
        CollectionReference collectionRef = firestore.collection("failed_games");
        ApiFuture<QuerySnapshot> future = collectionRef.get();       
        HashMap<String , FailedCall> failedGames = new HashMap<>(); 
        
        for (DocumentSnapshot document : future.get()) {
            FailedCall fc = document.toObject(FailedCall.class);
            if(fc != null) {
                failedGames.put(fc.getAppId(), fc);
            }            
        }
        
        return failedGames;
    }

    public FailedCall getFailedCallById(String appId) throws InterruptedException, ExecutionException {
        DocumentReference docRef = firestore.collection("failed_games").document(appId);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();

        if(document.exists()){
            return document.toObject(FailedCall.class);
        }else {
            return null;
        }
    }
}
