package com.hexaware.cricketmanagement.service;

import com.hexaware.cricketmanagement.dto.PlayerDto;
import com.hexaware.cricketmanagement.entity.Player;
import com.hexaware.cricketmanagement.exception.PlayerNotFoundException;
import com.hexaware.cricketmanagement.repository.PlayerRepository;
import com.hexaware.cricketmanagement.service.PlayerService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    private PlayerDto convertToDto(Player player) {
        PlayerDto dto = new PlayerDto();
        BeanUtils.copyProperties(player, dto);
        return dto;
    }

    private Player convertToEntity(PlayerDto dto) {
        Player player = new Player();
        BeanUtils.copyProperties(dto, player);
        return player;
    }

    @Override
    public List<PlayerDto> getAllPlayers() {
        List<Player> players = playerRepository.findAll();
        return players.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public PlayerDto getPlayerById(Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with id: " + id));
        return convertToDto(player);
    }

    @Override
    public PlayerDto createPlayer(PlayerDto playerDto) {
        Player player = convertToEntity(playerDto);
        Player savedPlayer = playerRepository.save(player);
        return convertToDto(savedPlayer);
    }

    @Override
    public PlayerDto updatePlayer(Long id, PlayerDto playerDto) {
        Player existingPlayer = playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with id: " + id));

        // Update fields
        existingPlayer.setPlayerName(playerDto.getPlayerName());
        existingPlayer.setJerseyNumber(playerDto.getJerseyNumber());
        existingPlayer.setRole(playerDto.getRole());
        existingPlayer.setTotalMatches(playerDto.getTotalMatches());
        existingPlayer.setTeamName(playerDto.getTeamName());
        existingPlayer.setCountryName(playerDto.getCountryName());
        existingPlayer.setDescription(playerDto.getDescription());

        Player updatedPlayer = playerRepository.save(existingPlayer);
        return convertToDto(updatedPlayer);
    }

    @Override
    public void deletePlayer(Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with id: " + id));
        playerRepository.delete(player);
    }
}
