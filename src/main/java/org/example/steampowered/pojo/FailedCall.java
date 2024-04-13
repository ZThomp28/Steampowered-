package org.example.steampowered.pojo;

public class FailedCall {

    // This class is used to store the data of the failed calls and add them to a database so they are not
    // called again when logging in
    private String appId;

    public FailedCall() {        
    }

    public FailedCall(String appId) {
        this.appId = appId;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

}
