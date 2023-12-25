package com.example.employeeservice.service;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmploye(Employee department) {
        return employeeRepository.save(department);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id : " + id));
    }

//    public List<Employee> findByDepartment(Long departmentId) {
//        return employees.stream()
//                .filter(a -> a.departmentId().equals(departmentId))
//                .toList();
//    }

        public List<Employee> findByDepartment(Integer deptId) {
//            return (List<Employee>) employeeRepository.findByDeptId(deptId)
//                    .orElseThrow(() -> new IllegalArgumentException("Invalid id : " + deptId));

            List<Employee> employeeList = employeeRepository.findByDeptId(deptId);
            return employeeList;
       }
}
