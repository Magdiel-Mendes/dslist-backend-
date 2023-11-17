package com.curso.dslist.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
	
}
