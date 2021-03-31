package com.mercadolibre.metros.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.metros.entity.PriceDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Repository
public class PriceRepositoryImpl implements PriceRepository{

    @Override
    public PriceDTO findPriceByLocation(String location) {
        List<PriceDTO> priceList = null;
        PriceDTO result = null;
        priceList = loadDataBase();
        if (priceList != null)
        {
            Optional<PriceDTO> item = priceList.stream().
                    filter(priceDTO -> priceDTO.getLocation().equals(location))
                    .findFirst();
            if (item.isPresent())
            {
                result = item.get();
            }

        }
        return result;
    }

    private List<PriceDTO> loadDataBase() {
        File file = null;
        try
        {
            file = ResourceUtils.getFile("classpath:prices.json");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<PriceDTO>> typeRef = new TypeReference<>(){};
        List<PriceDTO> priceList = null;
        try {
            priceList = objectMapper.readValue(file, typeRef);
        }
        catch (Exception e)
        {
         e.printStackTrace();
        }
        return priceList;
    }
}
