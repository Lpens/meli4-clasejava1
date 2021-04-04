package com.mercadolibre.linktracker.repository;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.dto.LinkResponseDTO;
import com.mercadolibre.linktracker.dto.MetricsDTO;
import com.mercadolibre.linktracker.exceptions.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkRepositoryImpl implements LinkRepository{

    private final HashMap<Integer,LinkDTO> urlList = new HashMap<>();
    private final HashMap<Integer,Double> metricList = new HashMap<>();
    private Integer counter = 0;
    Double noviews = Double.parseDouble("0");;

    @Override
    public int save(LinkDTO link) {
        int id = counter++;
        urlList.put(id,link);
        return id;
    }

    @Override
    public MetricsDTO getMetrics(Integer linkId) throws NotFoundException {

        LinkDTO link = this.getLink(linkId);
        Double views = null;
        views = metricList.get(linkId);
        if(link != null && views == null)
        {
            views = noviews;
        }
        return new MetricsDTO(views, link);
    }

    @Override
    public LinkDTO getLink(Integer linkId) throws NotFoundException {
        LinkDTO resultLink = null;
        resultLink = urlList.get(linkId);
        if (resultLink == null) throw new NotFoundException(linkId.toString());
        return resultLink;
    }

    @Override
    public void addView(MetricsDTO metrics, Integer linkId) {

        metricList.put(linkId,metrics.getCantidadDeRedirecciones()+1);
    }
}
