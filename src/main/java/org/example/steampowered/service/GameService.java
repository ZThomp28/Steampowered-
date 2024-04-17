package org.example.steampowered.service;

import java.util.Collection;
import java.util.concurrent.CountDownLatch;

import org.example.steampowered.pojo.Game;
import org.example.steampowered.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GameService {    

    private final CountDownLatch gameDetailsLatch = new CountDownLatch(1);

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

//    public String getGamesAsJson(){
//        ObjectMapper objectMapper = new ObjectMapper();
//        String gamesJson = "[]";
//
//        try {
//            gamesJson = objectMapper.writeValueAsString(getGames());
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return gamesJson;
//    }
}
