package com.mercadolibre.linktracker.services;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.dto.LinkResponseDTO;
import com.mercadolibre.linktracker.dto.MetricsDTO;
import com.mercadolibre.linktracker.exceptions.NotFoundException;
import com.mercadolibre.linktracker.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
@Service
public class LinkServiceImpl implements LinkService{
    @Autowired
    private LinkRepository linkRepository;

    private final HashMap<Integer,LinkDTO> urlList = new HashMap<>();
    private final HashMap<Integer,Double> metricList = new HashMap<>();
    private Integer counter = 0;
    Double noviews = Double.parseDouble("0");;


    @Override
    public LinkResponseDTO saveLink(LinkDTO link) {
        int id = linkRepository.save(link);
        LinkResponseDTO response = new LinkResponseDTO();
        response.setLinkId(id);
        return response;
    }

    @Override
    public LinkDTO getLink(Integer linkId) throws NotFoundException {
        LinkDTO resultLink = linkRepository.getLink(linkId);
        MetricsDTO views = null;
        views = linkRepository.getMetrics(linkId);
        linkRepository.addView(views, linkId);
        return resultLink;
    }

    @Override
    public MetricsDTO getMetrics(Integer linkId) throws NotFoundException {
        return linkRepository.getMetrics(linkId);
    }
}
