package com.mercadolibre.starwars.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository{

    @Override
    public List<CharacterDTO> findCharacterByName(String name) {
        List<CharacterDTO> characterList = null;
        List<CharacterDTO> result = null;
        characterList = loadDataBase();
        if (characterList != null)
        {
            result = characterList.stream()
                    .collect(
                            Collectors.filtering(characterDTO ->
                                    characterDTO.getName().startsWith(name) || characterDTO.getName().endsWith(name),
                            Collectors.toList()
                    ));
        }
        return result;
    }

    private List<CharacterDTO> loadDataBase() {
        File file = null;
        try
        {
            file = ResourceUtils.getFile("classpath:starwars.json");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDTO>> typeRef = new TypeReference<>(){};
        List<CharacterDTO> characterList = null;
        try {
            characterList = objectMapper.readValue(file, typeRef);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return characterList;
    }
}
