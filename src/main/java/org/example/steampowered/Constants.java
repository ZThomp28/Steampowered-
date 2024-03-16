package org.example.steampowered;

public class Constants {
    public static final String USER_LIBRARY_API_URL = "http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?key=B6B215A4D22ACEB1D8161A4CB318F136&steamid=%s&format=json&include_appinfo=True&include_played_free_games=True";
    public static final String PLAYER_SUMMARIES_API_URL = "http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=B6B215A4D22ACEB1D8161A4CB318F136&steamids=%s";
    public static final String APP_INFO_API_URL = "https://store.steampowered.com/api/appdetails?appids=%s";
}
