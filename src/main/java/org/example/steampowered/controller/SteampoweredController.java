package org.example.steampowered.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.example.steampowered.pojo.Game;
import org.example.steampowered.pojo.User;
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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

    public SteampoweredController() throws JsonProcessingException {
    }

    @GetMapping("/")
    public String getIndexPage(HttpServletRequest request, Model model){
        openIdService.filterOpenIdResults(request);

        ObjectMapper objectMapper = new ObjectMapper();
        String gamesJson = "[]";
        String steamId = openIdService.getSteamId();
        try {
            gamesJson = objectMapper.writeValueAsString(games);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        if(steamId != null) {
            try {
                User userInfo = openIdService.steamUserDisplay(steamId);
                model.addAttribute("profileImage", userInfo.getProfileImage());
                model.addAttribute("steamUserName", userInfo.getSteamUserName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("games", games);
        model.addAttribute("gamesJson", gamesJson);
        return "index";

    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/multiplayer")
    public String getMultiplayerPage(){ return "multiplayer"; }

    @GetMapping("/profile")
    public String getProfilePage(HttpServletRequest request, Model model){
        openIdService.filterOpenIdResults(request);
        String steamId = openIdService.getSteamId();


        if(steamId != null) {
            try {
                User userInfo = openIdService.steamUserDisplay(steamId);
                model.addAttribute("profileImage", userInfo.getProfileImage());
                model.addAttribute("steamUserName", userInfo.getSteamUserName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "profile";
    }

    @RequestMapping(value="/redirect", method = RequestMethod.GET)
    public ModelAndView runManager(){
        String url = openIdService.activateOpenId();
        return new ModelAndView("redirect:" + url);
    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {

        request.getSession().invalidate();

        return "redirect:/";
    }
}