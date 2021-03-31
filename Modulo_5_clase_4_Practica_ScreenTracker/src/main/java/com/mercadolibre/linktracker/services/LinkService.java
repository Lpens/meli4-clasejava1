package com.mercadolibre.linktracker.services;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.dto.LinkResponseDTO;
import com.mercadolibre.linktracker.dto.MetricsDTO;
import com.mercadolibre.linktracker.exceptions.NotFoundException;

public interface LinkService {
    LinkResponseDTO saveLink(LinkDTO link);
    LinkDTO getLink(Integer linkId)throws NotFoundException;
    MetricsDTO getMetrics(Integer linkId) throws NotFoundException;
    void redirectCalled(Integer linkId) throws NotFoundException;
}
