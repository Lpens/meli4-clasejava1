package com.mercadolibre.linktracker.services;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.dto.LinkResponseDTO;
import com.mercadolibre.linktracker.dto.MetricsDTO;
import com.mercadolibre.linktracker.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
@Service
public class LinkServiceImpl implements LinkService{
    private final HashMap<Integer,LinkDTO> urlList = new HashMap<>();
    private final HashMap<Integer,Double> metricList = new HashMap<>();
    private Integer counter = 0;
    Double noviews = Double.parseDouble("0");;
    @Override
    public LinkResponseDTO saveLink(LinkDTO link) {
        int id = counter++;
        LinkResponseDTO response = new LinkResponseDTO();
        urlList.put(id,link);
        response.setLinkId(id);
        return response;
    }

    @Override
    public LinkDTO getLink(Integer linkId) throws NotFoundException {
        LinkDTO resultLink = urlList.get(linkId);

        if (resultLink == null) throw new NotFoundException(linkId.toString());
        return resultLink;
    }
    public void redirectCalled(Integer linkId)throws NotFoundException{
        Double views = null;
        views = metricList.get(linkId);
        if (views == null)
        {
            views = noviews;
        }
        metricList.put(linkId,views+1);
    }

    @Override
    public MetricsDTO getMetrics(Integer linkId) throws NotFoundException {
        LinkDTO link = getLink(linkId);
        Double views = null;
        views = metricList.get(linkId);
        if(link != null && views == null)
        {
            views = noviews;
        }
        return new MetricsDTO(views, link);
    }
}
