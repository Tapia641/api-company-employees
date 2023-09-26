package com.company.controller;

import com.company.model.Region;
import com.company.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegionController {

    @Autowired
    private RegionService service;

    @GetMapping("/regions")
    public List<Region> listRegions(){
        return service.listRegions();
    }
}
