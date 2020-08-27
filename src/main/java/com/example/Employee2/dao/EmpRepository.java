package com.example.Employee2.dao;

import com.example.Employee2.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository <Employee, Integer>{
}
