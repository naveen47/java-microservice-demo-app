package com.example.departmentservice.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    Integer empId;
    Integer deptId;
    String empName;
    Integer age;
    String position;
}
