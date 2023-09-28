package com.company.app.service;

import com.company.app.model.Regions;
import com.company.app.respository.RegionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    @Autowired
    private RegionRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(RegionService.class);

    public List<Regions> listRegions() {
        try {
            List<Regions> regions = repository.findAll();
            logger.info("Retrieved {} regions on Service", regions.size());
            return regions;
        } catch (Exception e) {
            logger.error("Error while retrieving regions: ", e);
            throw e;
        }
    }

    public void saveRegion(Regions region) {
        repository.save(region);
    }

    public Regions getRegionById(Integer id) {
        return repository.findById(id).get();
    }

    public void deleteRegionById(Integer id) {
        repository.deleteById(id);
    }
}
