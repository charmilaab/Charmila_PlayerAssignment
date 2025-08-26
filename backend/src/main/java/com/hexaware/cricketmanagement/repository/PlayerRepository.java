package com.hexaware.cricketmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.cricketmanagement.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    List<Player> findByTeamName(String teamName);

    List<Player> findByTotalMatchesGreaterThan(Integer matches);

    List<Player> findByTotalMatchesLessThan(Integer matches);

    List<Player> findByName(String name);
}
