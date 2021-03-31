package com.mercadolibre.starwars.controllers;

import com.mercadolibre.starwars.Services.CharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/character")
public class CharacterController {

    private final  CharacterService characterService;

    public CharacterController(CharacterService characterService)
    {
        this.characterService = characterService;
    }

    @GetMapping("/{name}")
    public ResponseEntity findCharacter(@PathVariable String name)
    {
        try {
            return new ResponseEntity(this.characterService.getCharacter(name), HttpStatus.OK);
        }catch (Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity("could not find a Character named: " + name
                    , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
