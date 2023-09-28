package com.company.app.controller;

import com.company.app.model.Employees;
import com.company.app.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/api/")
public class EmployeeController{

    // Bean llamando a CountryRepository para poder usar sus funciones
    @Autowired
    private EmployeeService service;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);


    @GetMapping(path="/employees")
    public List<Employees> listEmployees(){
        logger.info("Retrieved {} employees on Controller:", service.listEmployees());
        return service.listEmployees();
    }

    @GetMapping(path="/employees2")
    public ResponseEntity<List<Employees>> listEmployees2() {
        try {
            List<Employees> employees = service.listEmployees();
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
