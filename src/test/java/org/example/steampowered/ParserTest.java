package org.example.steampowered;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ParserTest {
    
    private static String userId = "76561198046659335";
    private static Parser parser;    
    
   @BeforeAll
   public static void setUp(){
    parser = new Parser();
   }

    @Test
    void testGetUserLibrary() {
        ArrayList<String> appIds = new ArrayList<>(parser.getUserLibrary(userId));
        // Using Paul's library.  There should be 295 apps
        Assertions.assertEquals(295, appIds.size());
    }
}
