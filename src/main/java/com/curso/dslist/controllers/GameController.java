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
import com.curso.dslist.entities.Game;
import com.curso.dslist.exceptions.GameNotFoundException;
import com.curso.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public ResponseEntity<List<GameDTO>> findAll(){
		try {
			List<Game> game = gameService.findAll();
			if(game.isEmpty()){
				throw new GameNotFoundException("Não há jogos a serem exibidos");
			}
			List<GameDTO> gameDTO = game.stream().map(obj -> new GameDTO(obj)).collect(Collectors.toList());
			return ResponseEntity.ok().body(gameDTO);
		}catch (GameNotFoundException e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@GetMapping("{id}")
	 public ResponseEntity<Game> findById(@PathVariable Long id) {
        try {
            Game game = gameService.findById(id); 
            return ResponseEntity.ok().body(game);
        } catch (GameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
