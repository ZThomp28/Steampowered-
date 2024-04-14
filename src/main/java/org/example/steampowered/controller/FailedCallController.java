package org.example.steampowered.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.example.steampowered.pojo.FailedCall;
import org.example.steampowered.service.FailedCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FailedCallController {
    
    @Autowired
    private FailedCallService failedCallService;

    @PostMapping("/failedCall")
    public String saveFailedCall(@RequestBody FailedCall failedCall) throws InterruptedException, ExecutionException {
        return failedCallService.saveFailedCall(failedCall);
    }

    @GetMapping("failedCall/{appId}")
    public FailedCall getFailedCallById(@PathVariable String appId) {
        try {
            return failedCallService.getFailedCallById(appId);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("failedCall/all")
    public List<FailedCall> getAllFailedCalls() {
        try {
            return failedCallService.getAllFailedCalls();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }
}
