package com.philiperequena.fizzbuzz.controller;

import com.philiperequena.fizzbuzz.domain.response.GameResponse;
import com.philiperequena.fizzbuzz.service.GameService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController("/")
public class GameController {
    
    private GameService gameService;

    // TODO restfull docs
    @GetMapping
    public GameResponse playTheGame(){
        return gameService.playTheGame();
    }

}
