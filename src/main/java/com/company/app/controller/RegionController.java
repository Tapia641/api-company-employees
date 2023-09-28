package com.company.app.controller;

import com.company.app.model.Regions;
import com.company.app.service.RegionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//NUESTRA API REST

@RestController
@RequestMapping(path="/api/")
public class RegionController {

    @Autowired
    private RegionService service;

    private static final Logger logger = LoggerFactory.getLogger(RegionController.class);

    @GetMapping(path="/regions")
    public List<Regions> listRegions(){
        logger.info("Retrieved {} regions on Controller:", service.listRegions().size());
        return service.listRegions();
    }
}
