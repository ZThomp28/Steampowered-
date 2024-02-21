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
	@RequestMapping(value="/redirect", method = RequestMethod.GET)
    public ModelAndView runManager(){
        OpenIdManager manager = new OpenIdManager();
        manager.setReturnTo("http://localhost:8080");
        manager.setRealm("http://localhost:8080");

        Endpoint endpoint = manager.lookupEndpoint("https://steamcommunity.com/openid/");
        System.out.println(endpoint);

        Association association = manager.lookupAssociation(endpoint); 
        System.out.println(association);

        String url = manager.getAuthenticationUrl(endpoint, association);
        System.out.println("Copy the authentication URL in browser:\n" + url);

        return new ModelAndView("redirect:" + url);
    }
}
