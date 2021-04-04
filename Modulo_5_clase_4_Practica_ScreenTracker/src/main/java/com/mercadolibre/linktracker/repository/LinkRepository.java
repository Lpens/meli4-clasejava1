package com.mercadolibre.linktracker.repository;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.dto.MetricsDTO;
import com.mercadolibre.linktracker.exceptions.NotFoundException;

public interface LinkRepository {

    int save(LinkDTO link);
    LinkDTO getLink(Integer linkId) throws NotFoundException;
    MetricsDTO getMetrics(Integer linkId) throws NotFoundException;
    void addView(MetricsDTO metrics, Integer linkId);
}
