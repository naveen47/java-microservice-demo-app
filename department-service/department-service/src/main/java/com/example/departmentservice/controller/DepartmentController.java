package com.example.departmentservice.controller;

import com.example.departmentservice.client.EmployeeClient;
import com.example.departmentservice.model.Department;
import com.example.departmentservice.repository.DepartmentRepository;
import com.example.departmentservice.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Department add(@RequestBody Department department) {
        LOGGER.info("Department add: {}", department);
        return departmentService.addDepartment(department);
    }

    @GetMapping("/all")
    public List<Department> findAll() {
        LOGGER.info("Department find");
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Integer id) {
        LOGGER.info("Department find: id={}", id);
        return departmentService.getDepartmentById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees() {
        LOGGER.info("Department find");
        List<Department> departments
                = departmentService.getAllDepartments();
        departments.forEach(department ->
                department.setEmployees(employeeClient.findByDepartment(department.getDeptId())));
        return  departments;
    }
}
