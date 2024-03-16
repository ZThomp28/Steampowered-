package org.example.steampowered.controller;

import java.util.HashMap;
import java.util.Map;

import org.expressme.openid.Association;
import org.expressme.openid.Endpoint;
import org.expressme.openid.OpenIdManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SteampoweredController {

    @GetMapping("/")
    public String getIndexPage(HttpServletRequest request, Model model){
        // When the openID returns the user to the index page, grab the values from the nav bar
        Map<String, String[]> parameterMap = request.getParameterMap();     
        
        // Filter out only the parameters openid.claimed_id and openid.identity
        Map<String, String[]> filteredParameters = new HashMap<>();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            String paramName = entry.getKey();
            if ("openid.claimed_id".equals(paramName) || "openid.identity".equals(paramName)) {
                filteredParameters.put(paramName, entry.getValue());
            }
        }       

        // print out the values to verify that it worked
        if(filteredParameters.size() > 0){
            for (Map.Entry<String, String[]> entry : filteredParameters.entrySet()) {
                String paramName = entry.getKey();
                String[] paramValues = entry.getValue();

                System.out.println("Parameter: " + paramName);
                System.out.print("Values: ");
                for (String value : paramValues) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        }
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
        // TODO  change these from localhost after uploading the project to a hosting site
        manager.setReturnTo("http://localhost:8080");
        manager.setRealm("http://localhost:8080");

        Endpoint endpoint = manager.lookupEndpoint("https://steamcommunity.com/openid/");      
        Association association = manager.lookupAssociation(endpoint);      
        String url = manager.getAuthenticationUrl(endpoint, association);        
        return new ModelAndView("redirect:" + url);
    }

}