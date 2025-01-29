package com.caalzate.spring.security.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/api/rickandmorty")
public class RickAndMortyController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/characters")
    public ResponseEntity<?> getCharacters() {
        String url = "https://rickandmortyapi.com/api/character";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return ResponseEntity.ok(response.getBody());
    }

    @GetMapping("/characters/filter")
    public ResponseEntity<?> getCharactersFiltered(
        @RequestParam(value = "name", required = false) String name,
        @RequestParam(value = "status", required = false) String status,
        @RequestParam(value = "species", required = false) String species,
        @RequestParam(value = "type", required = false) String type,
        @RequestParam(value = "gender", required = false) String gender
    ) {
        
        StringBuilder url = new StringBuilder("https://rickandmortyapi.com/api/character/?");

        if (name != null && !name.isEmpty()) {
            url.append("name=").append(name).append("&");
        }
        if (status != null && !status.isEmpty()) {
            url.append("status=").append(status).append("&");
        }
        if (species != null && !species.isEmpty()) {
            url.append("species=").append(species).append("&");
        }
        if (type != null && !type.isEmpty()) {
            url.append("type=").append(type).append("&");
        }
        if (gender != null && !gender.isEmpty()) {
            url.append("gender=").append(gender).append("&");
        }

        // Remove the last '&' if present
        if (url.charAt(url.length() - 1) == '&') {
            url.deleteCharAt(url.length() - 1);
        }

        ResponseEntity<String> response = restTemplate.getForEntity(url.toString(), String.class);
        return ResponseEntity.ok(response.getBody());

    }
    
}
