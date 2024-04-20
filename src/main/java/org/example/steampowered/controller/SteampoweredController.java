package org.example.steampowered.controller;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import jakarta.servlet.http.HttpServletResponse;
import org.example.steampowered.service.GameService;
import org.example.steampowered.service.OpenIdService;
import org.example.steampowered.service.UserDbService;
import org.example.steampowered.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SteampoweredController {   
    
    @Autowired
    OpenIdService openIdService;

    @Autowired
    UserService userService;

    @Autowired
    GameService gameService;  
    
    @Autowired
    UserDbService userDbService;

    @GetMapping("/index")
    public String getIndexPage(HttpServletRequest request, Model model) throws IOException, InterruptedException, ExecutionException{
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
        model.addAttribute("gamesJson", gameService.getGamesAsJson());
        return "profile";
    }

    @RequestMapping(value="/redirect", method = RequestMethod.GET)
    public ModelAndView runManager(){
        String url = openIdService.activateOpenId();
        return new ModelAndView("redirect:" + url);
    }

    @GetMapping("/logout")
    public String logout() {
        userService.nullUser();
        return "redirect:/";
    }
}