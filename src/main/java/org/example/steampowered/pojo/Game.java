package org.example.steampowered.pojo;

public class Game {

    private String appid;
    private String name;
    private String imgIconURL;

    public Game(String appid, String name, String imgIconURL) {
        this.appid = appid;
        this.name = name;
        this.imgIconURL = imgIconURL;
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
}
