package com.example.eval;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private PlayerService playerService;

    @GetMapping("/question")
    public ResponseEntity<String> getCapitalByCountryId() {
        List<Country> countries = countryService.findAll();

        if (countries.isEmpty()) {
            return ResponseEntity.ok("No country.");
        }

        Country randomCountry = getRandomCountry(countries);
        return ResponseEntity.ok("What's the capital of : " + randomCountry.getName() + " (id: " + randomCountry.getId() + ") ?");
    }

    @PostMapping("/response")
    public ResponseEntity<Map<String, Object>> checkAnswer(@RequestParam String playerName, @RequestParam Integer id, @RequestParam String answer) {
        Optional<Country> countryOptional = countryService.findById(id);
        Map<String, Object> response = new HashMap<>();

        if (!countryOptional.isPresent()) {
            response.put("error", "Can't find country");
            return ResponseEntity.ok(response);
        }

        Country country = countryOptional.get();
        Player player = playerService.getOrCreatePlayer(playerName);
        if (country.getCapital().equalsIgnoreCase(answer)) {
            playerService.updateScore(player, 1);
            response.put("message", "Well play : +1");
        } else {
            playerService.updateScore(player, -1);
            response.put("message", "Bad answer : -1");
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/score")
    public ResponseEntity<Map<String, Object>> getScore(@RequestParam String playerName) {
        Map<String, Object> response = new HashMap<>();
        Optional<Player> playerOptional = playerService.findByName(playerName);

        if (playerOptional.isPresent()) {
            response.put("message", "You have " + playerOptional.get().getScore() + " points!");
        } else {
            response.put("message", "Player not found.");
        }

        return ResponseEntity.ok(response);
    }

    private Country getRandomCountry(List<Country> countries) {
        Random random = new Random();
        int randomIndex = random.nextInt(countries.size());
        return countries.get(randomIndex);
    }
}
