package com.everis.ranking;

import com.everis.ranking.Repository.NewPlayerRepository;
import com.everis.ranking.Entity.NewPlayerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RankingApplication implements CommandLineRunner {

	@Autowired
	private NewPlayerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(RankingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.save(new NewPlayerEntity("Renata", 120));
		repository.save(new NewPlayerEntity("Fernanda", 120));
		repository.save(new NewPlayerEntity("Francisco", 120));
		repository.save(new NewPlayerEntity("Boris", 110));
		repository.save(new NewPlayerEntity("Eduardo", 100));
		repository.save(new NewPlayerEntity("Claudia", 100));
		repository.save(new NewPlayerEntity("Franciele", 90));
	}
}
