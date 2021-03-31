package com.mercadolibre.starwars.Services;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChracterServiceImpl implements CharacterService{

    private final CharacterRepository characterRepository;

    public ChracterServiceImpl(CharacterRepository characterRepository)
    {
        this.characterRepository = characterRepository;
    }

    @Override
    public List<CharacterDTO> getCharacter(String name) {
        List<CharacterDTO> character = this.characterRepository.findCharacterByName(name);
        return character;
    }
}
