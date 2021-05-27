package com.everis.ranking.Repository;

import com.everis.ranking.Entity.NewPlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewPlayerRepository extends JpaRepository<NewPlayerEntity,Long> {

}
