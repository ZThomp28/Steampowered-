package org.example.steampowered.controller;

import org.example.steampowered.service.OpenIdService;
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

    @GetMapping("/")
    public String getIndexPage(HttpServletRequest request, Model model){
        openIdService.filterOpenIdResults(request);
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