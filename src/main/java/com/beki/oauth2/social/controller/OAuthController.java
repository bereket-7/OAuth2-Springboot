package com.beki.oauth2.social.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/oauth2")
public class OAuthController {
    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Greeting from OAuth2");
    }
}
