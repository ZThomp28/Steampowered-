package org.example.steampowered.repository;

import java.util.ArrayList;
import java.util.List;

import org.example.steampowered.pojo.Game;
import org.springframework.stereotype.Repository;

@Repository
public class GameRepository {
    
    private List<Game> games = new ArrayList<>();

    public List<Game> getGames() {
        return games;
    }

    public Game getGame(int index) {
        return games.get(index);
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public void deleteGame(int index) {
        games.remove(index);
    }
}
