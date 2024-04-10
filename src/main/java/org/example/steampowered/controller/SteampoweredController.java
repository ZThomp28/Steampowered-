package org.example.steampowered.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.example.steampowered.pojo.Game;
import org.example.steampowered.pojo.User;
import org.example.steampowered.service.GameService;
import org.example.steampowered.service.OpenIdService;
import org.example.steampowered.service.UserService;
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

    User user = new User("MindOfPaul", "76561198046659335", "https://avatars.steamstatic.com/e7ceb08d9799a78adb8b62cc39c695549e2a6c47_medium.jpg");

    @Autowired
    OpenIdService openIdService;

    @Autowired
    UserService userService;

    @Autowired
    GameService gameService;    

    @GetMapping("/index")
    public String getIndexPage(HttpServletRequest request, Model model) throws IOException{
        openIdService.filterOpenIdResults(request);       
        
        model.addAttribute("user", userService.getUser());        
        model.addAttribute("gamesJson", gameService.getGamesAsJson());
        return "index";
    }

    @GetMapping("/")
    public String getLoginPage(HttpServletRequest request){        
        return "login";
    }

    @GetMapping("/multiplayer")
    public String getMultiplayerPage(){ return "multiplayer"; }

    @GetMapping("/profile")
    public String getProfilePage(HttpServletRequest request, Model model){            
        model.addAttribute("user", userService.getUser());
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