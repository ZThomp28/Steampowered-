package org.example.steampowered;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class UserTest {

    User paul = new User("MindOfPaul", "1111");

    @Test
    void getWebsiteUserName() {
        Assertions.assertEquals("WebsiteMindOfPaul", paul.getWebsiteUserName());
    }

    @Test
    void getSteamUserName() {
        Assertions.assertEquals("MindOfPaul", paul.getSteamUserName());
    }

    @Test
    void getSteamID() {
        Assertions.assertEquals("1111", paul.getSteamID());
    }
}