package com.company.app.controller;

import com.company.app.model.Employees;
import com.company.app.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/")
public class EmployeeController{

    // Bean llamando a CountryRepository para poder usar sus funciones
    @Autowired
    private EmployeeService service;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping(path="/employees")
    public ResponseEntity<List<Employees>> listEmployees() {
        try {
            List<Employees> employees = service.listEmployees();
            logger.info("Retrieved {} employees on Controller", employees.size());
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/employees/{id}")
    public ResponseEntity<Employees> getEmployee(@PathVariable Integer id){
        try {
            Employees employee = service.getEmployeeById(id);
            logger.info("Retrieved th ID: {} employees on Controller", employee.getEmployee_id());
            return new ResponseEntity<Employees>(employee, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("An error occurred while fetching Employees.", e);
            return new ResponseEntity<Employees>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping(path = "/employees")
    public ResponseEntity<Employees> saveEmployees(@RequestBody Employees employee){
        try {
            service.saveEmployee(employee);
            return new ResponseEntity<Employees>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<Employees>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping(path = "/employees/{id}")
    public ResponseEntity<?> updateEmployees(@RequestBody Employees employee, @PathVariable Integer id){
        try {
            Employees employee_exists = service.getEmployeeById(id);
            employee_exists.setEmail(employee.getEmail());
            employee_exists.setDepartment_id(employee.getDepartment_id());
            employee_exists.setFirst_name(employee.getFirst_name());
            employee_exists.setHire_date(employee.getHire_date());
            employee_exists.setJob_id(employee.getJob_id());
            employee_exists.setSalary(employee.getSalary());
            employee_exists.setLast_name(employee.getLast_name());
            employee_exists.setManager_id(employee.getManager_id());
            employee_exists.setPhone_number(employee.getPhone_number());
            service.saveEmployee(employee_exists);
            return new ResponseEntity<Employees>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<Employees>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/employees/{id}")
    public ResponseEntity<Employees> deleteEmployees(@PathVariable Integer id){
        try {
            service.deleteEmployeeById(id);
            return new ResponseEntity<Employees>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<Employees>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
