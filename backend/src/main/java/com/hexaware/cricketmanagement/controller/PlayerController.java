package com.hexaware.cricketmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hexaware.cricketmanagement.dto.PlayerDto;
import com.hexaware.cricketmanagement.entity.Player;
import com.hexaware.cricketmanagement.service.PlayerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService service;

    @PostMapping("/add")
    public Player createPlayer(@Valid @RequestBody PlayerDto dto) {
        return service.createPlayer(dto);
    }

    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable int id, @Valid @RequestBody PlayerDto dto) {
        return service.updatePlayer(id, dto);
    }

    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable int id) {
        return service.getPlayerById(id);
    }

    @GetMapping("/getall")
    public List<Player> getAllPlayers() {
        return service.getAllPlayers();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id) {
        return service.deleteById(id);
    }

    @GetMapping("/team/{teamName}")
    public List<Player> getPlayersByTeam(@PathVariable String teamName) {
        return service.getPlayersByTeam(teamName);
    }

    @GetMapping("/totalMatches/{totalMatches}")
    public List<Player> getByTotalMatchesGreaterThan(@PathVariable int totalMatches) {
        return service.getByTotalMatchesGreaterThan(totalMatches);
    }
}
