package org.example.steampowered.pojo;

import java.net.URL;

public class Game {

    private String appid;
    private String name;
    private String imgIconURL;
    private boolean multiplayer;
    // Games can have multiple genres.  Might need to use an arraylists
    // private String genre;

    public Game(String appid, String name, String imgIconURL, boolean multiplayer) {
        this.appid = appid;
        this.name = name;
        this.imgIconURL = imgIconURL;
        this.multiplayer = multiplayer;        
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgIconURL() {
        return imgIconURL;
    }

    public void setImgIconURL(String imgIconURL) {
        this.imgIconURL = imgIconURL;
    }

    public boolean getMultiplayer() {
        return multiplayer;
    }

    public void setMultiplayer(boolean multiplayer) {
        this.multiplayer = multiplayer;
    }
}
