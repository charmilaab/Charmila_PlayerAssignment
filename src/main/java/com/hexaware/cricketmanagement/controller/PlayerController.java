package com.hexaware.cricketmanagement.controller;

import com.hexaware.cricketmanagement.dto.PlayerDto;
import com.hexaware.cricketmanagement.service.PlayerService;
import com.hexaware.cricketmanagement.exception.PlayerNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/getall")
    public ResponseEntity<List<PlayerDto>> getAllPlayers() {
        return ResponseEntity.ok(playerService.getAllPlayers());
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<PlayerDto> getPlayerById(@PathVariable Long playerId) {
        PlayerDto playerDto = playerService.getPlayerById(playerId);
        return ResponseEntity.ok(playerDto);
    }

    @PostMapping
    public ResponseEntity<PlayerDto> createPlayer(@RequestBody PlayerDto playerDto) {
        PlayerDto createdPlayer = playerService.createPlayer(playerDto);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    @PutMapping("/{playerId}")
    public ResponseEntity<PlayerDto> updatePlayer(@PathVariable Long playerId, @RequestBody PlayerDto playerDto) {
        PlayerDto updatedPlayer = playerService.updatePlayer(playerId, playerDto);
        return ResponseEntity.ok(updatedPlayer);
    }

    @DeleteMapping("/{playerId}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long playerId) {
        playerService.deletePlayer(playerId);
        return ResponseEntity.noContent().build();
    }

    // Exception Handler
    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<String> handlePlayerNotFoundException(PlayerNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
