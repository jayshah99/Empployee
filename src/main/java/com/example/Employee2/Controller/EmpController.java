package com.example.Employee2.Controller;

import com.example.Employee2.model.Comment;
import com.example.Employee2.model.Employee;
import com.example.Employee2.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

@RestController
public class EmpController {

    @Autowired
    EmpService empService;

    @GetMapping("/employees")
    public List<Employee> getAll()
    {
        return empService.getAll();
    }
    @PostMapping("/employee")
    public Employee persist(@Valid @RequestBody Employee employee)
    {
        empService.persist(employee);
        return employee;
    }
    @GetMapping("/employee/{id}")
    private Employee getEmp(@PathVariable("id") int id)
    {
        return empService.getEmp(id);
    }
}
