package com.example.employeeservice.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    @Column(name = "emp_id")
    Integer empId;
    @Column(name = "dept_id")
    Integer deptId;
    @Column(name = "emp_name")
    String empName;
    Integer age;
    String position;
}
