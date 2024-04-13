package org.example.steampowered;

import org.example.steampowered.pojo.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



class UserTest {
    
    private static User paul;

    @BeforeAll
    public static void setUp(){
        // paul = new User("MindOfPaul", "1111");
        // paul.setWebsiteUserName("WebsiteMindOfPaul");
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