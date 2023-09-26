package com.company.controller;

import com.company.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.service.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController{

    @Autowired
    private EmployeeService service;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);


    @GetMapping("/employees")
    public List<Employee> listEmployees(){
        logger.info("Retrieved {} employees on Controller:", service.listEmployees());
        return service.listEmployees();
    }

    @GetMapping("/employees2")
    public ResponseEntity<List<Employee>> listEmployees2() {
        try {
            List<Employee> employees = service.listEmployees();
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
