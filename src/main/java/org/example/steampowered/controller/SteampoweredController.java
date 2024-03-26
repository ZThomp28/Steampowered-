package org.example.steampowered.controller;

import java.util.ArrayList;
import java.util.List;

import org.example.steampowered.pojo.Game;
import org.example.steampowered.service.OpenIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SteampoweredController {

    List<Game> games = Arrays.asList(
        new Game("400", "Portal", "https://cdn.akamai.steamstatic.com/steam/apps/400/header.jpg?t=1699003695", false, true, "Game Description"),
        new Game("20900", "The Witcher", "https://cdn.akamai.steamstatic.com/steam/apps/20900/header.jpg?t=1700481839", false, true, "Game Description"),
        new Game("23310", "The Last Remnant", "https://cdn.akamai.steamstatic.com/steam/apps/23310/header.jpg?t=1536078342", false, true, "Game Description"),
        new Game("8930", "Sid Meyer's Civilization V", "https://cdn.akamai.steamstatic.com/steam/apps/8930/header.jpg?t=1579731804", true, true, "Game Description")
    );

    @Autowired
    OpenIdService openIdService;

    @GetMapping("/")
    public String getIndexPage(HttpServletRequest request, Model model){
        openIdService.filterOpenIdResults(request);        
        model.addAttribute("games", games);
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
        String url = openIdService.activateOpenId();
        return new ModelAndView("redirect:" + url);
    }

}