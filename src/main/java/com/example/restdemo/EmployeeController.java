package com.example.restdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.restdemo.entity.Employee;
import com.example.restdemo.repository.EmpRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@Component
@RestController
public class EmployeeController {
    
    @Autowired
    private EmpRepository empRepository;
    
    @PostMapping("create")
    public void addEmployeee(@RequestBody Employee e){
        empRepository.store(e);
    }
    
    @GetMapping("get/{id}")
    public Employee getEmployeeeById(@PathVariable int id){
        Employee e = empRepository.retrieve(id);
        return e;
    }

    @GetMapping("getbyname/{name}")
    public Employee getEmployeeeByName(@PathVariable String name){
        Employee e = empRepository.search(name);
        return e;
    }

    @DeleteMapping("/remove/{id}")
    public Employee deleteEmployeee(@PathVariable int id){
        Employee e = empRepository.delete(id);
        return e;
    }

    @GetMapping("getAll")
    public List<Employee> getAllEmployeee(){
        List<Employee> empList = empRepository.getAll();
        return empList;
    }
}