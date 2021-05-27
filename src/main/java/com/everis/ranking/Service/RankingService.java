package com.everis.ranking.Service;

import com.everis.ranking.Entity.NewPlayerEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RankingService {

    List getFixedPlayers();

    List postPlayer(NewPlayerEntity newPlayer);

    ResponseEntity putPointsPlayer(long id, NewPlayerEntity playerData);

    ResponseEntity deletePlayer(long id);
}
