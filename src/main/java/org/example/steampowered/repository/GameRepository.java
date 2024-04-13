package org.example.steampowered.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

import org.example.steampowered.pojo.Game;
import org.springframework.stereotype.Repository;

@Repository
public class GameRepository {
    
    // private List<Game> games = new ArrayList<>();

    HashMap<String, Game> gameMap = new HashMap<>();

    // HashMap<String, Game> gameMap = new HashMap<String, Game>() {{
    //     put("400", new Game("400", "Portal", "https://cdn.akamai.steamstatic.com/steam/apps/400/header.jpg?t=1699003695",  "Game Description"));
    //     put("20900", new Game("20900", "The Witcher", "https://cdn.akamai.steamstatic.com/steam/apps/20900/header.jpg?t=1700481839",  "Game Description"));
    //     put("23310", new Game("23310", "The Last Remnant", "https://cdn.akamai.steamstatic.com/steam/apps/23310/header.jpg?t=1536078342",  "Game Description"));
    //     put("8930", new Game("8930", "Sid Meyer's Civilization V", "https://cdn.akamai.steamstatic.com/steam/apps/8930/header.jpg?t=1579731804",  "Game Description"));
    //     put("553850", new Game("553850", "Helldivers 2", "https://cdn.akamai.steamstatic.com/steam/apps/553850/header.jpg?t=1709666906",  "Game Description"));
    //     put("1086940", new Game("1086940", "Baldur's Gate 3", "https://cdn.akamai.steamstatic.com/steam/apps/1086940/header.jpg?t=1711532262",  "Game Description"));
    //     put("381210", new Game("381210", "Dead By Daylight", "https://cdn.akamai.steamstatic.com/steam/apps/381210/header.jpg?t=1710268442",  "Game Description"));
    //     put("2195250", new Game("2195250", "EA SPORTS FC 24", "https://cdn.akamai.steamstatic.com/steam/apps/2195250/header.jpg?t=1709567756",  "Game Description"));
    //     put("1599340", new Game("1599340", "Lost Ark", "https://cdn.akamai.steamstatic.com/steam/apps/1599340/header.jpg?t=1702454470",  "Game Description"));
    //     put("2357570", new Game("2357570", "Overwatch 2", "https://cdn.akamai.steamstatic.com/steam/apps/2357570/header.jpg?t=1711555325",  "Game Description"));
    //     put("218620", new Game("218620", "PAYDAY 2", "https://cdn.akamai.steamstatic.com/steam/apps/218620/header.jpg?t=1710441592",  "Game Description"));
    //     put("1623730", new Game("1623730", "Palworld", "https://cdn.akamai.steamstatic.com/steam/apps/1623730/header.jpg?t=1707904340",  "Game Description"));
    //     put("2073850", new Game("2073850", "THE FINALS", "https://cdn.akamai.steamstatic.com/steam/apps/2073850/header.jpg?t=1711535327",  "Game Description"));
    //     put("1966720", new Game("1966720", "Lethal Company", "https://cdn.akamai.steamstatic.com/steam/apps/1966720/header.jpg?t=1700231592",  "Game Description"));
    //     put("322170", new Game("322170", "Geometry Dash", "https://cdn.akamai.steamstatic.com/steam/apps/322170/header.jpg?t=1703006148",  "Game Description"));
    //     put("892970", new Game("892970", "Valheim", "https://cdn.akamai.steamstatic.com/steam/apps/892970/header.jpg?t=1708348390",  "Game Description"));
    //     put("739630", new Game("739630", "Phasmophobia", "https://cdn.akamai.steamstatic.com/steam/apps/739630/header.jpg?t=1702309974",  "Game Description"));
    //     put("1517290", new Game("1517290", "Battlefield 2042", "https://cdn.akamai.steamstatic.com/steam/apps/1517290/header.jpg?t=1711360662",  "Game Description"));
    //     put("960090", new Game("960090", "Bloons TD 6", "https://cdn.akamai.steamstatic.com/steam/apps/960090/header.jpg?t=1709862306",  "Game Description"));

    // }};  

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
