package org.example.steampowered.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

import org.example.steampowered.pojo.Game;
import org.springframework.stereotype.Repository;

@Repository
public class GameRepository {   
    
    HashMap<String, Game> gameMap = new HashMap<>();
   
    public HashMap<String, Game> getGames() {
        return gameMap;
    }

    public Game getGame(String id) {
        return gameMap.get(id);
    }    

    public void addGame(Game game) {
        gameMap.put(game.getAppId(), game);
    }

    public void deleteGame(String id) {
        gameMap.remove(id);
    }
}
