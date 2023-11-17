package com.curso.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.dslist.entities.GameList;
import com.curso.dslist.repositories.GameListRepository;




@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GameList> findAll(){
		List<GameList> game = gameListRepository.findAll();
		return game;
	}

}
