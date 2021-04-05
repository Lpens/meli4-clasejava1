package com.mercadolibre.linktracker.services;

import com.mercadolibre.linktracker.dto.DeleteSuccessDTO;
import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.dto.LinkResponseDTO;
import com.mercadolibre.linktracker.dto.MetricsDTO;
import com.mercadolibre.linktracker.exceptions.NotFoundException;
import com.mercadolibre.linktracker.exceptions.WrongPasswordException;
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



    private void addview(Integer linkId) throws NotFoundException {
        MetricsDTO views = null;
        views = linkRepository.getMetrics(linkId);
        linkRepository.addView(views, linkId);
    }

    @Override
    public LinkDTO getLink(Integer linkId, String password) throws NotFoundException, WrongPasswordException {
        LinkDTO resultLink = linkRepository.getLink(linkId);
        String pwd = resultLink.getPassword();
        if(pwd != null && !pwd.equals(password)) throw  new WrongPasswordException();
        this.addview(linkId);
        return resultLink;
    }

    @Override
    public MetricsDTO getMetrics(Integer linkId) throws NotFoundException {
        return linkRepository.getMetrics(linkId);
    }

    @Override
    public DeleteSuccessDTO deleteLink(Integer linkId) throws NotFoundException {

        LinkDTO resultLink = linkRepository.deleteLink(linkId);
        return new DeleteSuccessDTO("successfully deleted", resultLink);
    }
}
