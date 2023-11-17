package com.curso.dslist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.dslist.dto.GameDTO;
import com.curso.dslist.entities.Game;
import com.curso.dslist.projectons.GameMinProjection;
import com.curso.dslist.repositories.GameListRepository;
import com.curso.dslist.repositories.GameRepository;



@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private GameListRepository listRepository;
	
	@Transactional(readOnly = true)
	public List<Game> findAll(){
		List<Game> game = gameRepository.findAll();
		return game;
	}
	
	public List<GameDTO> findByList(Long id){
		List<GameMinProjection> game = listRepository.searchByList(id);
		return game.stream().map(obj -> new GameDTO(obj)).toList();
	}
	@Transactional(readOnly = true)
	public Game findById(Long id){
	    Optional<Game> game = gameRepository.findById(id);
		return game.get();
	}
}
