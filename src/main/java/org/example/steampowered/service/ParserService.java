package org.example.steampowered.service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.example.steampowered.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ParserService {

    @Autowired
    GameService gameService;  

    private String libraryUrl = Constants.USER_LIBRARY_API_URL;  
    private String  playerSummaryUrl = Constants.PLAYER_SUMMARIES_API_URL;
    private String appInfoUrl = Constants.APP_INFO_API_URL;

    // Grabs the user's Library with the steam ID that was acquired with OpenID. 
    // returns an ArrayList of all of the IDs
    public ArrayList<String> getUserLibrary(String userID){
        ArrayList<String> gameIds = new ArrayList<>();
        // Only set up to format the string as of now
        String apiUrlWithSteamId = String.format(libraryUrl, userID);

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