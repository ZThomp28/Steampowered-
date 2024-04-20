package org.example.steampowered.pojo;

import java.util.ArrayList;


public class User {
    
    private String steamUserName;
    private String steamID;    
    private String profileImage;
    private ArrayList<String> userGames;

    public User(){    
        this.userGames = new ArrayList<>(); 
    }

    public User(String steamUserName, String steamID, String profileImage) {
        this.steamUserName = steamUserName;
        this.steamID = steamID;        
        this.profileImage = profileImage;
        this.userGames = new ArrayList<>();    
    }  

    public String getSteamUserName() {
        return this.steamUserName;
    }

    public void setSteamUserName(String steamUserName) {
        this.steamUserName = steamUserName;
    }

    public String getSteamID() {
        return this.steamID;
    }

    public void setSteamID(String steamID) {
        this.steamID = steamID;
    }    

    public String getProfileImage() {
        return this.profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public ArrayList<String> getUserGames(){
        return this.userGames;
    }

    public void setUserGames(ArrayList<String> userGames) {
        this.userGames = userGames;
    }

    @Override
    public String toString() {
        return "Steam Id: " + steamID + "\nUsername: " + steamUserName + "\nprofile link: " + profileImage;
    }
   
}
