package com.example.Employee.dao;

import com.example.Employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository <Employee, Integer>{
}
