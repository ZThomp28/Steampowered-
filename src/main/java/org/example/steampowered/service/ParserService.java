package org.example.steampowered.service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import org.example.steampowered.Constants;
import org.example.steampowered.pojo.Game;
import org.example.steampowered.pojo.Genre;
import org.example.steampowered.pojo.Category;
import org.example.steampowered.pojo.FailedCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ParserService {

    @Autowired
    GameService gameService;  

    @Autowired
    GameDbService gameDbService;

    @Autowired
    UserDbService userDbService;

    @Autowired
    UserService userService;

    @Autowired
    FailedCallService failedCallService;

    private String libraryUrl = Constants.USER_LIBRARY_API_URL;      
    private String appInfoUrl = Constants.APP_INFO_API_URL;

    private HashMap<String, Game> dbGames = new HashMap<>();
    private HashMap<String, FailedCall> dBFailedCalls = new HashMap<>();

    // Grabs the user's Library with the steam ID that was acquired with OpenID. 
    // returns an ArrayList of all of the IDs
    private ArrayList<String> getUserLibraryIds(String userId) throws InterruptedException, ExecutionException{
        
        // Fills an ArrayList of all of the games and failed call Id's in the database to check agains what 
        // is gathered from the API
        dbGames = gameDbService.getAllGamesAsMap();
        dBFailedCalls = failedCallService.getAllFailedCallsAsMap();

        ArrayList<String> gameIds = new ArrayList<>();
        
        String apiUrlWithSteamId = String.format(libraryUrl, userId);

        try{
            URL url = new URL(apiUrlWithSteamId);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(url);
            
            JsonNode gamesNode = root.path("response").path("games");
            for(JsonNode gameNode: gamesNode){
                String appId = gameNode.path("appid").asText();

                // Checks if the id exists in the games or failed calls stored in the database.
                // If it does exist, it adds the object to the proper service and continues
                // so that the ID is not added to gameIds which reduces our for loop in the
                // next method and subsequently the number of api calls needed.
                if(dbGames.containsKey(appId)) {
                    gameService.addGame(dbGames.get(appId));
                    continue;
                }

                if(dBFailedCalls.containsKey(appId)) {
                    failedCallService.saveFailedCall(dBFailedCalls.get(appId));
                    continue;
                }
                
                gameIds.add(appId);
            }
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("Error grabbing user library with Steam ID");
        } 
        
        
        
        userService.getUser().setUserGames(gameIds);
        
        // If the user is not currently in the database, add them
        if(!userDbService.exists(userService.getUser().getSteamID())) {
            userDbService.saveUser(userService.getUser());
        }

        return gameIds;        
    }  
    
    public void getGameDetails(String userId) throws InterruptedException, ExecutionException {
        // Populate the arraylist by calling getUserLibraryId
        ArrayList<String> gameIds = getUserLibraryIds(userId);
        
        // Game Details API only takes one ID at a time, so we have to loop through all of the IDs and
        // grab the details individually
        try{
            for(String id: gameIds) {               
                
                String gameApi = String.format(appInfoUrl, id);                
                URL url = new URL(gameApi);
                ObjectMapper mapper = new ObjectMapper();
                JsonNode root = mapper.readTree(url);

                if(!root.get(id).get("success").asBoolean()) {
                    System.out.println("Api call for api ID " + id + " was not successful");
                    failedCallService.saveFailedCall(new FailedCall(id));
                    continue;
                }

                String name = "";
                String imgIconUrl = "";                
                String description = "";            
                               
                if(root.get(id).get("data").get("name") != null) {
                    name = root.get(id).get("data").get("name").asText();
                }                
                
                if(root.get(id).get("data").get("header_image") != null) {
                    imgIconUrl = root.get(id).get("data").get("header_image").asText();
                } 
                
                if(root.get(id).get("data").get("short_description") != null) {
                    description = root.get(id).get("data").get("short_description").asText();
                } 

                Game game = new Game(id, name, imgIconUrl, description);

                JsonNode categoriesNode = root.get(id).get("data").get("categories");
                if (categoriesNode != null && categoriesNode.isArray()) {
                    HashMap<String, Category> tempCategories = new HashMap<String, Category>();
                    for (JsonNode categoryNode : categoriesNode) {
                        String categoryId = categoryNode.get("id").asText();
                        String categoryDescription = categoryNode.get("description").asText();
                        tempCategories.put(categoryId, new Category(categoryId, categoryDescription));
                    }
                    game.setCategories(tempCategories);
}

                JsonNode genresNode = root.get(id).get("data").get("genres");
                if (genresNode != null && genresNode.isArray()) {
                    HashMap<String, Genre> tempGenres = new HashMap<String, Genre>();
                    for (JsonNode genreNode : genresNode) {
                        String genreId = genreNode.get("id").asText();
                        String genreDescription = genreNode.get("description").asText();
                        tempGenres.put(genreId, new Genre(genreId, genreDescription));
                    }
                    game.setGenres(tempGenres);
                }           
                              
                // Make sure no details are missing and 
                if(!name.isEmpty() && !imgIconUrl.isEmpty()) {
                    gameService.addGame(game);  
                    gameDbService.saveGame(game);                 
                }               
                
            }
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("Error grabbing game details");
        }

        
    }    
}