package com.mercadolibre.linktracker.controllers;

import com.mercadolibre.linktracker.dto.*;
import com.mercadolibre.linktracker.exceptions.BadUrlException;
import com.mercadolibre.linktracker.exceptions.NotFoundException;
import com.mercadolibre.linktracker.exceptions.WrongPasswordException;
import com.mercadolibre.linktracker.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.feed.RssChannelHttpMessageConverter;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/link")
public class ScreenTrackerController {
    @Autowired
    private LinkService linkService;

    @PostMapping("/")
    public ResponseEntity saveLink(@RequestBody LinkDTO link) throws BadUrlException {
        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(link.getUrl());
        if (!m.matches())throw new BadUrlException(link.getUrl());

        LinkResponseDTO linkid = linkService.saveLink(link);
        return new ResponseEntity(linkid, HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public  ResponseEntity invalidateLink (@PathVariable Integer linkId) throws NotFoundException {
        DeleteSuccessDTO deleteMessage = linkService.deleteLink(linkId);
        return new ResponseEntity(deleteMessage, HttpStatus.OK);
    }
    @GetMapping("/{linkId}")
    public ModelAndView Redirect(@PathVariable Integer linkId, @RequestParam(defaultValue = "") String password) throws NotFoundException, WrongPasswordException {
        LinkDTO linkToRedirect = linkService.getLink(linkId, password);
        return new ModelAndView("redirect:"+ linkToRedirect.getUrl());
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity getMetrics(@PathVariable Integer linkId) throws NotFoundException {
        MetricsDTO metricsDTO = linkService.getMetrics(linkId);
        return new ResponseEntity(metricsDTO,HttpStatus.OK);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity linkNotFound(NotFoundException n)
    {
        ErrorDTO error= new ErrorDTO();
        error.setMessage("Invalid Link Id");
        error.setDescription("the id : " + n.getMessage() + " did not exist");
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WrongPasswordException.class)
    public ResponseEntity wrongPassword(WrongPasswordException n)
    {
        ErrorDTO error= new ErrorDTO();
        error.setMessage("Unable to redirect to the link");
        error.setDescription(n.getMessage());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadUrlException.class)
    public ResponseEntity badUrlSent(BadUrlException n)
    {
        ErrorDTO error= new ErrorDTO();
        error.setMessage("Invalid Url Sent");
        error.setDescription("the url provided : " + n.getMessage() + " is not a valid URL like 'http://google.com'");
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity badRequestType(HttpRequestMethodNotSupportedException e)
    {
        ErrorDTO error = new ErrorDTO();
        error.setMessage("invalid Request Type");
        error.setDescription("the Request type you are trying to execute isn't available please contact with API Admin");
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
}
