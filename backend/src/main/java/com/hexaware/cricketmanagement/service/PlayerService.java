package com.hexaware.cricketmanagement.service;

import java.util.List;

import com.hexaware.cricketmanagement.dto.PlayerDto;
import com.hexaware.cricketmanagement.entity.Player;

public interface PlayerService {

    List<Player> getAllPlayers();
    Player createPlayer(PlayerDto dto);
    Player getPlayerById(int id);
    Player updatePlayer(int id, PlayerDto dto);
    String deleteById(int id);
    List<Player> getPlayersByTeam(String teamName);
    List<Player> getByTotalMatchesGreaterThan(int totalMatches);
}
