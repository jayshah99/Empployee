package com.example.Employee.Controller;

import com.example.Employee.model.Comment;
import com.example.Employee.model.Employee;
import com.example.Employee.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Comment persist(@RequestBody Employee employee)
    {
        Comment comment=new Comment();
        try {
             empService.persist(employee);
        }
        catch (Exception e) {
            e.printStackTrace();
            StringWriter error = new StringWriter();
            e.printStackTrace(new PrintWriter(error));
            comment.setComment(error.toString());
        }
        return comment;
    }
    @GetMapping("/employee/{id}")
    private Employee getEmp(@PathVariable("id") int id)
    {
        return empService.getEmp(id);
    }
}
