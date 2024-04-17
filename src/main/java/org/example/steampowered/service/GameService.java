package org.example.steampowered.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.CountDownLatch;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.io.InputStreamReader;


import org.example.steampowered.pojo.Game;
import org.example.steampowered.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GameService {  
    
    @Autowired
    GameRepository gameRepository;    

    // Converts the hashmap to a Collection to act the same as an ArrayList when passed to the html
    public Collection<Game> getGames() {
        return gameRepository.getGames().values();
    }
    
    public Game getGame(String id) {
        return gameRepository.getGame(id);
    }

    public void addGame(Game game) {
        gameRepository.addGame(game);
    }

    public void deleteGame(String id) {
        gameRepository.deleteGame(id);
    }


    public String getGamesAsJson(){
        ObjectMapper objectMapper = new ObjectMapper();
        String gamesJson = "[]";

        try {
            gamesJson = objectMapper.writeValueAsString(getGames());            
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return gamesJson;
    }   
    
    public void writeGamesToJson(){
        try(FileWriter fileWriter = new FileWriter("game_data.json")) {
            fileWriter.write(getGamesAsJson());
            System.out.println("Game data has been written to the file successfully");
        } catch(IOException e) {
            System.out.println("An error has occurred writing the games file");
            e.printStackTrace();
        }
    }

    public void readGamesFromFile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Collection<Game> games = objectMapper.readValue(new InputStreamReader(new FileInputStream("game_data.json"), StandardCharsets.UTF_8), new TypeReference<Collection<Game>>() {});
            
            
            // Adding each game to the GameService
            for (Game game : games) {
                addGame(game);
            }
            
            System.out.println("Games have been added successfully from the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading games from the file.");
            e.printStackTrace();
        }
    }
}
