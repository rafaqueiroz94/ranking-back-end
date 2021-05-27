package com.everis.ranking.Controller;

import com.everis.ranking.Entity.NewPlayerEntity;
import com.everis.ranking.Service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping({"/api"})
@CrossOrigin(origins = "*")
public class FixedPlayersController {

    @Autowired
    RankingService service;

    @GetMapping({"/fixed-players"})
    public List getFixedPlayers() {
        return service.getFixedPlayers();
    }

    @PostMapping({"/new-player"})
    public ResponseEntity postPlayer(@RequestBody NewPlayerEntity newPlayer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.postPlayer(newPlayer));
    }

    @PutMapping(value="/{id}")
    public ResponseEntity putPointsPlayer(@PathVariable("id") long id, @RequestBody NewPlayerEntity playerData) {
        return service.putPointsPlayer(id, playerData);
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity deletePlayer(@PathVariable long id) {
        return service.deletePlayer(id);
    }

}
