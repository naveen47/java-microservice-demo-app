package com.example.departmentservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name = "employee")
public class Employee {

//    @Id
    Integer empId;
    Integer deptId;
    String empName;
    Integer age;
    String position;
}
