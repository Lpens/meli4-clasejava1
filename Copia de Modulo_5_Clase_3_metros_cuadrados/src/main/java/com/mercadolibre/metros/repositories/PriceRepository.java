package com.mercadolibre.metros.repositories;

import com.mercadolibre.metros.entity.PriceDTO;

public interface PriceRepository {

    PriceDTO findPriceByLocation(String location);
}
