package org.example.steampowered.pojo;

import java.net.URL;

public class Game {

    private String appid;
    private String name;
    private String imgIconURL;
    private boolean multiplayer;
    private boolean crossPlatform;
    private String shortDescription;

    public Game(String appid, String name, String imgIconURL, boolean multiplayer, boolean crossPlatform, String shortDescription) {
        this.appid = appid;
        this.name = name;
        this.imgIconURL = imgIconURL;
        this.multiplayer = multiplayer;  
        this.crossPlatform = crossPlatform;
        this.shortDescription = shortDescription;
    }


    public String getAppid() {
        return this.appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgIconURL() {
        return this.imgIconURL;
    }

    public void setImgIconURL(String imgIconURL) {
        this.imgIconURL = imgIconURL;
    }

    public boolean isMultiplayer() {
        return this.multiplayer;
    }

    public boolean getMultiplayer() {
        return this.multiplayer;
    }

    public void setMultiplayer(boolean multiplayer) {
        this.multiplayer = multiplayer;
    }

    public boolean isCrossPlatform() {
        return this.crossPlatform;
    }

    public boolean getCrossPlatform() {
        return this.crossPlatform;
    }

    public void setCrossPlatform(boolean crossPlatform) {
        this.crossPlatform = crossPlatform;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
    
}
