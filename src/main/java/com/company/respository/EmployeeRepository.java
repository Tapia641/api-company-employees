package com.company.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.company.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}