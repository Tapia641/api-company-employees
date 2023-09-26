package com.company.service;

import com.company.model.Employee;
import com.company.respository.EmployeeRepository;
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

     public List<Employee> listEmployees(){
         try {
             List<Employee> employees = repository.findAll();
             logger.info("Retrieved {} employees", employees.size());
             return employees;
         } catch (Exception e) {
             logger.error("Error while retrieving employees", e);
             throw e; // You might want to handle this exception further up the stack.
         }
     }

     public void saveEmployee(Employee employee){
         repository.save(employee);
     }

     public Employee getEmployeeById(Integer id){
         return repository.findById(id).get();
     }

     public void deleteEmployeeById(Integer id){
         repository.deleteById(id);
     }

}