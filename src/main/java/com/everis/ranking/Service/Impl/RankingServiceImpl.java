package com.everis.ranking.Service.Impl;

import com.everis.ranking.Entity.NewPlayerEntity;
import com.everis.ranking.Repository.NewPlayerRepository;
import com.everis.ranking.Service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingServiceImpl implements RankingService {

    @Autowired
    private NewPlayerRepository repository;

    @Override
    public List getFixedPlayers() {
        return repository.findAll();
    }

    @Override
    public List postPlayer(NewPlayerEntity newPlayer) {
        repository.save(newPlayer);
        return repository.findAll();
    }

    @Override
    public ResponseEntity putPointsPlayer(long id, NewPlayerEntity playerData) {
        return repository.findById(id)
                .map(player -> {
                    player.setName(playerData.getName());
                    player.setPoints(player.getPoints() + playerData.getPoints());
                    repository.save(player);
                    return ResponseEntity.ok().body(repository.findAll());
                }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity deletePlayer(long id) {
        return repository.findById(id)
                .map(result -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
