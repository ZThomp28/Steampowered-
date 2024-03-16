package org.example.steampowered.repository;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parser {
    
    private final String USER_API_URL = "http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?key=B6B215A4D22ACEB1D8161A4CB318F136&steamid=%s&format=json&include_appinfo=True&include_played_free_games=True";

    // Grabs the user's Library with the steam ID that was acquired with OpenID. 
    // returns an ArrayList of all of the IDs
    public ArrayList<String> getUserLibrary(String userID){
        ArrayList<String> gameIds = new ArrayList<>();
        // Only set up to format the string as of now
        String apiUrlWithSteamId = String.format(USER_API_URL, userID);

        try{
            URL url = new URL(apiUrlWithSteamId);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(url);
            
            JsonNode gamesNode = root.path("response").path("games");
            for(JsonNode gameNode: gamesNode){
                String appId = gameNode.path("appid").asText();
                gameIds.add(appId);
            }
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("Error grabbing user library with Steam ID");
        }
        
        return gameIds;        
    }
}