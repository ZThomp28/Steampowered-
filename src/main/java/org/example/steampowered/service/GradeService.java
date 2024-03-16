package org.example.steampowered.service;

import java.util.List;

import org.example.steampowered.pojo.Game;
import org.example.steampowered.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeService {
    

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
}
