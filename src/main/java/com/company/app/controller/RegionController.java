package com.company.app.controller;

import com.company.app.model.Employees;
import com.company.app.model.Regions;
import com.company.app.service.RegionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//NUESTRA API REST

@RestController
@RequestMapping(path = "/api/")
public class RegionController {

    @Autowired
    private RegionService service;

    private static final Logger logger = LoggerFactory.getLogger(RegionController.class);

    @GetMapping(path = "/regions")
    public ResponseEntity<List<Regions>> listRegions(){
        try {
            List<Regions> regions = service.listRegions();
            logger.info("Retrieved {} regions on Controller:", regions.size());
            return ResponseEntity.ok(regions);
        } catch (Exception e) {
            // Log the exception
            logger.error("An error occurred while fetching regions.", e);
            // Return an INTERNAL_SERVER_ERROR status with an empty list or a custom error message
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping(path = "/regions/{id}")
    public ResponseEntity<Regions> getRegion(@PathVariable Integer id) {
        try{
            Regions region = service.getRegionById(id);
            logger.info("Retrieved {} regions on Controller:", region.getRegion_name());
            return new ResponseEntity<Regions>(region,HttpStatus.OK);
        }catch (Exception e){
            logger.error("An error occurred while fetching regions.", e);
            return new ResponseEntity<Regions>(HttpStatus.NOT_FOUND);
        }
    }
}
