package com.example.replay.controller;

import com.example.replay.client.ApiClient;
import com.example.replay.client.Hero;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/replay")
public class TestController {

    private final ApiClient apiClient;

    public TestController(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @GetMapping
    public String getReplay() {
        Hero hero = apiClient.getHero(56L);
        return "replay " + hero;
    }
}
