package com.hexaware.cricketmanagement.service;

import com.hexaware.cricketmanagement.dto.PlayerDto;
import java.util.List;

public interface PlayerService {

    List<PlayerDto> getAllPlayers();
    PlayerDto getPlayerById(Long id);
    PlayerDto createPlayer(PlayerDto playerDto);
    PlayerDto updatePlayer(Long id, PlayerDto playerDto);
    void deletePlayer(Long id);
}
