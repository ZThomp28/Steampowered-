package org.example.steampowered.pojo;

import java.util.List;
import java.util.ArrayList;


public class Game {

    private String appId;
    private String name;
    private String imgIconURL;    
    private String shortDescription;
    private List<Category> categories;

    public Game(String appId, String name, String imgIconURL, String shortDescription) {
        this.appId = appId;
        this.name = name;
        this.imgIconURL = imgIconURL;       
        this.shortDescription = shortDescription;
        this.categories = new ArrayList<Category>();
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
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

    public String getShortDescription() {
        return this.shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
    
}
