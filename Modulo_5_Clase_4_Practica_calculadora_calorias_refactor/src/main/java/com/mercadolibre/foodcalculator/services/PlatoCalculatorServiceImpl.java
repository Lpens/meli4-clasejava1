package com.mercadolibre.foodcalculator.services;

import com.mercadolibre.foodcalculator.dto.IngredienteDTO;
import com.mercadolibre.foodcalculator.dto.PlatoDTO;
import com.mercadolibre.foodcalculator.dto.PlatoReturnDTO;
import com.mercadolibre.foodcalculator.exceptions.IngredientNotFound;
import com.mercadolibre.foodcalculator.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatoCalculatorServiceImpl implements PlatoCalculatorService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public PlatoReturnDTO calcularPlato(PlatoDTO plato) throws IngredientNotFound {
        PlatoReturnDTO result = new PlatoReturnDTO();
        int caloriasTotales = 0;
        List<Integer> listado = new ArrayList<>();
        IngredienteDTO mostCalorico = null;
        IngredienteDTO ingredient = null;
        for(IngredienteDTO ingrediente: plato.getIngredientes())
        {
            //calorias
            ingredient = ingredientRepository.findIngredientByName(ingrediente.getName());
            if(ingredient != null)
            {

                caloriasTotales += ingredient.getCalories();

                //listado calorias
                listado.add(ingredient.getCalories());

                //most calorico
                if(mostCalorico != null)
                {

                    mostCalorico = mostCalorico.getCalories()< ingredient.getCalories()?ingredient:mostCalorico;
                }
                else
                {
                    mostCalorico = ingredient;
                }
            }
        }
        result.setCaloriasTotales(caloriasTotales);
        result.setListaDeCalorias(listado);
        result.setIngredienteCalorico(mostCalorico);

        return result;
    }

    @Override
    public List<PlatoReturnDTO> calcularListadoPlato(List<PlatoDTO> listadoPlatos) throws IngredientNotFound {
        List<PlatoReturnDTO> resultList = new ArrayList<>();
        for(PlatoDTO plato : listadoPlatos)
        {
            resultList.add(this.calcularPlato(plato));
        }
        return resultList;
    }
}
