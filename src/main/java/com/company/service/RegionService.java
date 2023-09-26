package com.company.service;

import com.company.model.Region;
import com.company.respository.RegionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {


    @Autowired
    private RegionRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    public List<Region> listRegions() {
        try {
            List<Region> regions = repository.findAll();
            logger.info("Retrieved {} employees", regions.size());
            return regions;
        } catch (Exception e) {
            logger.error("Error while retrieving employees", e);
            throw e; // You might want to handle this exception further up the stack.
        }
    }

    public void saveRegion(Region region) {
        repository.save(region);
    }

    public Region getRegionById(Integer id) {
        return repository.findById(id).get();
    }

    public void deleteRegionById(Integer id) {
        repository.deleteById(id);
    }
}
