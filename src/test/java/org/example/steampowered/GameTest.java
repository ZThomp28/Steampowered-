package org.example.steampowered;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.example.steampowered.pojo.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URL;

public class GameTest {

    public static String STEAM_URL = "https://store.steampowered.com/api/appdetails?appids=";
    String appid = "730";

    //counter strike 2 JSON
    //https://store.steampowered.com/api/appdetails?appids=730&l=en

    public static Game getGameFromSteam(String appID) {
        Game g = null;
        //boolean mp = false;
        try {
            ObjectMapper mapper = new ObjectMapper();
            URL url = new URL(STEAM_URL + appID + "&l=en");
            JsonNode root = mapper.readTree(url);
            //appid
            String ID = root.get(appID).get("data").get("steam_appid").asText();
            //name
            String name = root.get(appID).get("data").get("name").asText();
            //image
            String image = root.get(appID).get("data").get("header_image").asText();
            //multiplayer
            //String mpFlag = root.get(appID).get("data").get("categories").get("description").asText();
            //if (mpFlag.equals("Multi-player")) {
            //    mp = true;
            //}
            // g = new Game(ID, name, image);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return g;
    }



    @Test
    void getAppid() {
        Game cs2 = getGameFromSteam(appid);
        System.out.println(cs2.getAppid());
        Assertions.assertEquals("730", cs2.getAppid());
    }

    @Test
    void getName() {
        Game cs2 = getGameFromSteam(appid);
        System.out.println(cs2.getName());
        Assertions.assertEquals("Counter-Strike 2", cs2.getName());
    }

    @Test
    void getImgIconURL() {
        Game cs2 = getGameFromSteam(appid);
        System.out.println(cs2.getImgIconURL());
        Assertions.assertEquals("https://cdn.akamai.steamstatic.com/steam/apps/730/header.jpg?t=1698860631", cs2.getImgIconURL());
    }

    @Test
    void getGameInfo() {
        Game cs2 = getGameFromSteam(appid);
        System.out.println("App ID: " + cs2.getAppid());
        System.out.println("Game Name: " + cs2.getName());
        System.out.println("Game Image: " + cs2.getImgIconURL());
    }

}
