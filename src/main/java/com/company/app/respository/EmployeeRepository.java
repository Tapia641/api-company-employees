package com.company.app.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.company.app.model.Employees;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer> {

}