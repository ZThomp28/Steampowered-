package org.example.steampowered.pojo;

public class User {

    
    private String steamUserName;
    private String steamID;
    private String websiteUserName;
    private String profileImage;


    public User(String steamUserName, String steamID, String profileImage) {
        this.steamUserName = steamUserName;
        this.steamID = steamID;
        this.websiteUserName = "Placeholder";
        this.profileImage = profileImage;
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

    public String getWebsiteUserName() {
        return this.websiteUserName;
    }

    public void setWebsiteUserName(String websiteUserName) {
        this.websiteUserName = websiteUserName;
    }

    public String getProfileImage() {
        return this.profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
   
}
