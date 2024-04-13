package org.example.steampowered.service;

import java.util.concurrent.ExecutionException;
import java.util.List;
import java.util.ArrayList;

import org.example.steampowered.pojo.Category;
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
public class CategoryService {   
    
    private final Firestore firestore;

    @Autowired
    public CategoryService(Firestore firestore) {
        this.firestore = firestore;
    }
    
    public String saveCategory(Category category) throws InterruptedException, ExecutionException{      
        ApiFuture<WriteResult> writeResult = firestore.collection("categories").document(category.getId()).set(category);
        return writeResult.get().getUpdateTime().toString();
    }

    public Category getCategoryById(String categoryId) throws InterruptedException, ExecutionException {
        DocumentReference docRef = firestore.collection("categories").document(categoryId);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();

        if(document.exists()){
            return document.toObject(Category.class);
        }else {
            return null;
        }
    }

    public List<Category> getAllCategories() throws InterruptedException, ExecutionException {        
        CollectionReference collectionRef = firestore.collection("categories");
        ApiFuture<QuerySnapshot> future = collectionRef.get();       
        List<Category> categories = new ArrayList<>();      
        
        for (DocumentSnapshot document : future.get()) {
            Category category = document.toObject(Category.class);
            categories.add(category);
        }
        
        return categories;
    }
}
