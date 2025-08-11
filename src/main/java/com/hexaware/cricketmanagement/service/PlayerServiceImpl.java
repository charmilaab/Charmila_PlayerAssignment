package com.hexaware.cricketmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cricketmanagement.dto.PlayerDto;
import com.hexaware.cricketmanagement.entity.Player;
import com.hexaware.cricketmanagement.exception.PlayerNotFoundException;
import com.hexaware.cricketmanagement.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository repo;

    @Override
    public Player createPlayer(PlayerDto dto) {
        Player player = new Player();

        // Note: ID is generated, no need to set

        player.setName(dto.getName());
        player.setJerseyNumber(dto.getJerseyNumber());
        player.setRole(dto.getRole());
        player.setTotalMatches(dto.getTotalMatches());
        player.setTeamName(dto.getTeamName());
        player.setState(dto.getState());
        player.setDescription(dto.getDescription());

        return repo.save(player);
    }

    @Override
    public Player updatePlayer(int id, PlayerDto dto) {
        Player existingPlayer = repo.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with id: " + id));

        existingPlayer.setName(dto.getName());
        existingPlayer.setJerseyNumber(dto.getJerseyNumber());
        existingPlayer.setRole(dto.getRole());
        existingPlayer.setTotalMatches(dto.getTotalMatches());
        existingPlayer.setTeamName(dto.getTeamName());
        existingPlayer.setState(dto.getState());
        existingPlayer.setDescription(dto.getDescription());

        return repo.save(existingPlayer);
    }

    @Override
    public Player getPlayerById(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with ID: " + id));
    }

    @Override
    public String deleteById(int id) {
        repo.deleteById(id);
        return "Player deleted successfully";
    }

    @Override
    public List<Player> getAllPlayers() {
        return repo.findAll();
    }

    @Override
    public List<Player> getByTotalMatchesGreaterThan(int totalMatches) {
        return repo.findByTotalMatchesGreaterThan(totalMatches);
    }

    @Override
    public List<Player> getPlayersByTeam(String teamName) {
        return repo.findByTeamName(teamName);
    }
}
