package com.example.springbootemployeeservice.repository;

import com.example.springbootemployeeservice.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
