package com.example.employeeservice.controller;


import com.example.employeeservice.model.Employee;
import com.example.employeeservice.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Employee add(@RequestBody Employee department) {
        LOGGER.info("Department add: {}", department);
        return employeeService.addEmploye(department);
    }

    @GetMapping("/all")
    public List<Employee> findAll() {
        LOGGER.info("Department find");
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Integer id) {
        LOGGER.info("Department find: id={}", id);
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/department/{deptId}")
    public List<Employee> findByDepartment(@PathVariable("deptId") Integer deptId) {
        LOGGER.info("Employee find: deptId={}", deptId);
        return employeeService.findByDepartment(deptId);
    }

}
