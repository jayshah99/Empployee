package com.example.Employee.service;

import com.example.Employee.dao.EmpRepository;
import com.example.Employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpService {
    @Autowired
    EmpRepository empRepository;


    public List<Employee> getAll()
    {
        return empRepository.findAll();
    }

    public Employee persist(Employee employee) throws Exception
    {
        if(employee.getName()==null)
            throw new Exception("Name not found");
        if(employee.getAddress()==null)
            throw new Exception("Address not found");
        if(employee.getPhone()==null)
            throw new Exception("Phone not found");
        if(employee.getRole()==null)
            throw new Exception("Role not found");

        empRepository.save(employee);
        return employee;
    }

    public Employee getEmp(int id)
    {
        return empRepository.findById(id).get();
    }
}
