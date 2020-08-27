package com.example.Employee2.service;

import com.example.Employee2.dao.EmpRepository;
import com.example.Employee2.model.Employee;
import com.example.Employee2.model.Response;
import com.example.Employee2.util.exceptions.InvalidRequestException;
import com.example.Employee2.util.exceptions.Employee2Exception;
import com.example.Employee2.util.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    EmpRepository empRepository;


    public List<Employee> getAll()
    {
        return empRepository.findAll();
    }

    public Employee persist(Employee employee)
    {


        empRepository.save(employee);
        return employee;
    }

//    public Employee getEmp(int id)
//    {
//        return empRepository.findById(id).get();
//    }
    public Employee getEmp(int id) {
        Optional<Employee> employee = empRepository.findById(id);

        if (employee.isPresent())
            return employee.get();

        throw new NotFoundException(("Employee with id:"+ id +" not present"));
    }
    public Response delete(int id) {
        Optional<Employee> employee = empRepository.findById(id);
        if (employee.isPresent()) {
            empRepository.deleteById(id);
            return new Response(false,("Employee with id:"+ id +" not present"));
        }
//        throw new SpringBootDemoException(String.format("Employee with id: %s not present", id));
        throw new Employee2Exception("Employee with id:"+ id +" not present");
    }
}
