package com.company.app.service;

import com.company.app.model.Employees;
import com.company.app.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Service
public class EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);


    @Autowired
    private EmployeeRepository repository;

     public List<Employees> listEmployees(){
         return repository.findAll();
     }

     public void saveEmployee(Employees employee){
         repository.save(employee);
     }

     public Employees getEmployeeById(Integer id){
         return repository.findById(id).get();
     }

     public void deleteEmployeeById(Integer id){
         repository.deleteById(id);
     }

}