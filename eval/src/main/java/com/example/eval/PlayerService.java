package com.example.eval;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Player getOrCreatePlayer(String playerName) {
        return playerRepository.findByName(playerName).orElseGet(() -> {
            Player player = new Player();
            player.setName(playerName);
            player.setScore(0);
            return playerRepository.save(player);
        });
    }

    public Player updateScore(Player player, int points) {
        player.setScore(player.getScore() + points);
        return playerRepository.save(player);
    }

    public Optional<Player> findByName(String playerName) {
        return playerRepository.findByName(playerName);
    }
}
