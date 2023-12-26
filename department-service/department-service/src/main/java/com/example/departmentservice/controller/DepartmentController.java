package com.example.departmentservice.controller;

import com.example.departmentservice.client.EmployeeClient;
import com.example.departmentservice.model.Department;
import com.example.departmentservice.repository.DepartmentRepository;
import com.example.departmentservice.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping("/add")
    public ResponseEntity<Department> add(@RequestBody Department department){
        LOGGER.info("Department add: {}", department);
        Department savedDepartment = departmentService.addDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Department>> findAll(){
        LOGGER.info("Department find All");
        List<Department> departments = departmentService.getAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Department> findById(@PathVariable Integer id){
        LOGGER.info("Department find: id={}", id);
        Department department = departmentService.getDepartmentById(id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @GetMapping("/with-employees")
    public ResponseEntity<List<Department>> findAllWithEmployees(){
        LOGGER.info("Department find");
        List<Department> departments
                = departmentService.getAllDepartments();
        departments.forEach(department ->
                department.setEmployees(employeeClient.findByDepartment(department.getDeptId())));
        return  new ResponseEntity<>(departments, HttpStatus.OK);
    }
}
