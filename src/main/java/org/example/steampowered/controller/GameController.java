package org.example.steampowered.controller;

import org.example.steampowered.pojo.Game;
import org.example.steampowered.service.GameDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class GameController {
    
    @Autowired
    private GameDbService gameDbService;

    @PostMapping("/games")
    public String saveGame(@RequestBody Game game) throws InterruptedException, ExecutionException {
        return gameDbService.saveGame(game);
    }
}
