package com.example.departmentservice.service;


import com.example.departmentservice.model.Department;
import com.example.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department addDepartment(Department department){
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Integer id){
        return departmentRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Invalid id : "+id));
    }
}
