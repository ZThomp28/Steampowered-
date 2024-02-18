package org.example.steampowered;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SteampoweredController {

    @GetMapping("/")
    public String getIndexPage(){
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/multiplayer")
    public String getMultiplayerPage(){
        return "multiplayer";
    }

    @GetMapping("/profile")
    public String getProfilePage(){
        return "profile";
    }
}
