package com.example.employeeservice.controller;


import com.example.employeeservice.model.Employee;
import com.example.employeeservice.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private static final Logger LOGGER
            = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<Employee>add(@RequestBody Employee employee){
        LOGGER.info("Employee add: {}", employee);
        Employee savedEmployee = employeeService.addEmploye(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> findAll(){
        LOGGER.info("Employee find All");
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee>findById(@PathVariable Integer id){
        LOGGER.info("Department find: id={}", id);
        Employee employee  = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/department/{deptId}")
    public ResponseEntity<List<Employee>> findByDepartment(@PathVariable("deptId") Integer deptId){
        LOGGER.info("Employee find: deptId={}", deptId);
        List<Employee> employees = employeeService.findByDepartment(deptId);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

}
