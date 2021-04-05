package com.mercadolibre.linktracker.services;

import com.mercadolibre.linktracker.dto.DeleteSuccessDTO;
import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.dto.LinkResponseDTO;
import com.mercadolibre.linktracker.dto.MetricsDTO;
import com.mercadolibre.linktracker.exceptions.NotFoundException;
import com.mercadolibre.linktracker.exceptions.WrongPasswordException;

public interface LinkService {
    LinkResponseDTO saveLink(LinkDTO link);
    LinkDTO getLink(Integer linkId, String password) throws NotFoundException, WrongPasswordException;
    MetricsDTO getMetrics(Integer linkId) throws NotFoundException;
    DeleteSuccessDTO deleteLink(Integer linkId) throws NotFoundException;
}
