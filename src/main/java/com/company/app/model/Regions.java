package com.company.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Regions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer region_id;
    private String region_name;


    public Regions() {
        super();
    }

    public Regions(Integer region_id, String region_name) {
        super();
        this.region_id = region_id;
        this.region_name = region_name;
    }

    public Integer getRegion_id() {
        return region_id;
    }

    public void setRegion_id(Integer region_id) {
        this.region_id = region_id;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }
}
