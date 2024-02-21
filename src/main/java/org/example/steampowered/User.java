package org.example.steampowered;

public class User {

    private String websiteUserName;
    private String steamUserName;
    private String steamID;

    // Uses this constructor when using steam openID
    // WebsiteUsername will be added later
    public User(String steamUserName, String steamID) {        
        this.steamUserName = steamUserName;
        this.steamID = steamID;
    }

    public String getWebsiteUserName() {
        return websiteUserName;
    }

    public void setWebsiteUserName(String websiteUserName) {
        this.websiteUserName = websiteUserName;
    }

    public String getSteamUserName() {
        return steamUserName;
    }

    public void setSteamUserName(String steamUserName) {
        this.steamUserName = steamUserName;
    }

    public String getSteamID() {
        return steamID;
    }

    public void setSteamID(String steamID) {
        this.steamID = steamID;
    }
}
