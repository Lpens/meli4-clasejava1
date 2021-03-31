package com.mercadolibre.foodcalculator.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.foodcalculator.dto.IngredienteDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository {
    public IngredienteDTO findIngredientByName(String name)
    {
        List<IngredienteDTO> IngredientList = null;
        IngredienteDTO result = null;
        IngredientList = loadDataBase();
        if (IngredientList != null)
        {
            Optional<IngredienteDTO> item = IngredientList.stream().
                    filter(ingredienteDTO -> ingredienteDTO.getName().equals(name))
                    .findFirst();
            if (item.isPresent())
            {
                result = item.get();
            }

        }
        return result;
    }
    private List<IngredienteDTO> loadDataBase() {
        File file = null;
        try
        {
            file = ResourceUtils.getFile("classpath:food.json");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredienteDTO>> typeRef = new TypeReference<>(){};
        List<IngredienteDTO> ingredientList = null;
        try {
            ingredientList = objectMapper.readValue(file, typeRef);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return ingredientList;
    }
}
