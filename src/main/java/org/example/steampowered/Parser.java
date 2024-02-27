package org.example.steampowered;

public class Parser {
    
    private final String USER_API_URL = "http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?key=B6B215A4D22ACEB1D8161A4CB318F136&steamid=%s&format=json&include_appinfo=True&include_played_free_games=True";

    public void getUserInfo(String userID){
        // Only set up to format the string as of now
        String apiUrlWithSteamId = String.format(USER_API_URL, userID);
        System.out.println(apiUrlWithSteamId);
    }
}