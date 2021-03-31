package com.mercadolibre.starwars.Services;

import com.mercadolibre.starwars.dto.CharacterDTO;

import java.util.List;

public interface CharacterService {
    List<CharacterDTO> getCharacter(String name);
}
