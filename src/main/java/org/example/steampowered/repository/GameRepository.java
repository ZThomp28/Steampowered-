package org.example.steampowered.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.example.steampowered.pojo.Game;
import org.springframework.stereotype.Repository;

@Repository
public class GameRepository {
    
    // private List<Game> games = new ArrayList<>();

    // temporary list until database is made
    List<Game> games = Arrays.asList(
        new Game("400", "Portal", "https://cdn.akamai.steamstatic.com/steam/apps/400/header.jpg?t=1699003695", false, true, "Game Description"),
        new Game("20900", "The Witcher", "https://cdn.akamai.steamstatic.com/steam/apps/20900/header.jpg?t=1700481839", false, true, "Game Description"),
        new Game("23310", "The Last Remnant", "https://cdn.akamai.steamstatic.com/steam/apps/23310/header.jpg?t=1536078342", false, true, "Game Description"),
        new Game("8930", "Sid Meyer's Civilization V", "https://cdn.akamai.steamstatic.com/steam/apps/8930/header.jpg?t=1579731804", true, true, "Game Description"),
        new Game("553850", "Helldivers 2", "https://cdn.akamai.steamstatic.com/steam/apps/553850/header.jpg?t=1709666906", false, true, "Game Description"),
        new Game("271590", "Grand Theft Auto V", "https://cdn.akamai.steamstatic.com/steam/apps/271590/header.jpg?t=1711059470", false, true, "Game Description"),
        new Game("1086940", "Baldur's Gate 3", "https://cdn.akamai.steamstatic.com/steam/apps/1086940/header.jpg?t=1711532262", false, true, "Game Description"),
        new Game("381210", "Dead By Daylight", "https://cdn.akamai.steamstatic.com/steam/apps/381210/header.jpg?t=1710268442", true, true, "Game Description"),
        new Game("2195250", "EA SPORTS FC 24", "https://cdn.akamai.steamstatic.com/steam/apps/2195250/header.jpg?t=1709567756", false, true, "Game Description"),
        new Game("1599340", "Lost Ark", "https://cdn.akamai.steamstatic.com/steam/apps/1599340/header.jpg?t=1702454470", false, true, "Game Description"),
        new Game("2357570", "Overwatch 2", "https://cdn.akamai.steamstatic.com/steam/apps/2357570/header.jpg?t=1711555325", false, true, "Game Description"),
        new Game("218620", "PAYDAY 2", "https://cdn.akamai.steamstatic.com/steam/apps/218620/header.jpg?t=1710441592", true, true, "Game Description"),
        new Game("1623730", "Palworld", "https://cdn.akamai.steamstatic.com/steam/apps/1623730/header.jpg?t=1707904340", false, true, "Game Description"),
        new Game("2073850", "THE FINALS", "https://cdn.akamai.steamstatic.com/steam/apps/2073850/header.jpg?t=1711535327", false, true, "Game Description"),
        new Game("1966720", "Lethal Company", "https://cdn.akamai.steamstatic.com/steam/apps/1966720/header.jpg?t=1700231592", false, true, "Game Description"),
            new Game("322170", "Geometry Dash", "https://cdn.akamai.steamstatic.com/steam/apps/322170/header.jpg?t=1703006148", false, true, "Game Description"),
            new Game("892970", "Valheim", "https://cdn.akamai.steamstatic.com/steam/apps/892970/header.jpg?t=1708348390", false, true, "Game Description"),
            new Game("739630", "Phasmophobia", "https://cdn.akamai.steamstatic.com/steam/apps/739630/header.jpg?t=1702309974", false, true, "Game Description"),
            new Game("1517290", "Battlefield 2042", "https://cdn.akamai.steamstatic.com/steam/apps/1517290/header.jpg?t=1711360662", true, true, "Game Description"),
            new Game("960090", "Bloons TD 6", "https://cdn.akamai.steamstatic.com/steam/apps/960090/header.jpg?t=1709862306", false, true, "Game Description"),
            new Game("1778820", "TEKKEN 8", "https://cdn.akamai.steamstatic.com/steam/apps/1778820/header.jpg?t=1710123236", false, true, "Game Description"),
            new Game("1172620", "Sea of Thieves", "https://cdn.akamai.steamstatic.com/steam/apps/1172620/header.jpg?t=1710946237", false, true, "Game Description"),
            new Game("2054970", "Dragon's Dogma 2", "https://cdn.akamai.steamstatic.com/steam/apps/2054970/header.jpg?t=1711067553", true, true, "Game Description"),
            new Game("1214650", "SOUTH PARK: SNOW DAY!", "https://cdn.akamai.steamstatic.com/steam/apps/1214650/header.jpg?t=1711537386", false, true, "Game Description"),
            new Game("2420110", "Horizon Forbidden West Complete Edition", "https://cdn.akamai.steamstatic.com/steam/apps/2420110/header.jpg?t=1711473066", false, true, "Game Description"),
            new Game("359550", "Tom Clancy's Rainbow Six Siege", "https://cdn.akamai.steamstatic.com/steam/apps/359550/header.jpg?t=1711470437", false, true, "Game Description"),
            new Game("440", "Team Fortress 2", "https://cdn.akamai.steamstatic.com/steam/apps/440/header.jpg?t=1695767057", true, true, "Game Description"),
            new Game("1938090", "Call of Duty®", "https://cdn.akamai.steamstatic.com/steam/apps/1938090/header.jpg?t=1710262744", false, true, "Game Description"),
            new Game("1172470", "Apex Legends", "https://cdn.akamai.steamstatic.com/steam/apps/1172470/header.jpg?t=1708706824", false, true, "Game Description"),
            new Game("252490", "Rust", "https://cdn.akamai.steamstatic.com/steam/apps/252490/header.jpg?t=1701938429", false, true, "Game Description")

    ); 

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
