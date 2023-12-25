package com.example.departmentservice.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Department {
    @Id
    @Column(name = "dept_id")
    private Integer deptId;
    @Column(name = "dept_name")
    private String deptName;
    @Transient
    private List<Employee> employees;
}
