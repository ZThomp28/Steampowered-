package org.example.steampowered.service;

import java.util.List;

import org.example.steampowered.pojo.Game;
import org.example.steampowered.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GameService {    

    @Autowired
    GameRepository gameRepository;    

    public List<Game> getGames() {
        return gameRepository.getGames();
    }
    
    public Game getGame(int index) {
        return gameRepository.getGame(index);
    }

    public void addGame(Game game) {
        gameRepository.addGame(game);
    }

    public void deleteGame(int index) {
        gameRepository.deleteGame(index);
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
    
}
