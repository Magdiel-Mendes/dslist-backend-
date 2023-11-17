package com.curso.dslist.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.dslist.dto.GameDTO;
import com.curso.dslist.dto.GameListDTO;

import com.curso.dslist.entities.GameList;
import com.curso.dslist.exceptions.GameNotFoundException;
import com.curso.dslist.services.GameListService;
import com.curso.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListService gameService;
	@Autowired
	private GameService service;
	
	@GetMapping
	public ResponseEntity<List<GameListDTO>> findAll(){
		try {
			List<GameList> game = gameService.findAll();
			if(game.isEmpty()){
				throw new GameNotFoundException("Não há jogos a serem exibidos");
			}
			List<GameListDTO> gameDTO = game.stream().map(obj -> new GameListDTO(obj)).collect(Collectors.toList());
			return ResponseEntity.ok().body(gameDTO);
		}catch (GameNotFoundException e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@GetMapping(value = "/{id}/games")
	public List<GameDTO> findByList(@PathVariable Long id){
		List<GameDTO> listGames = service.findByList(id);
		return  listGames;
	}
}
