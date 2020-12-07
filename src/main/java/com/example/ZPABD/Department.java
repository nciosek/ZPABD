package com.example.ZPABD;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deptID;
    private String nameDept;
    private String job;

    @OneToMany(mappedBy = "department")
    Set<Employee> employees;

    public Long getDeptID() {
        return deptID;
    }

    public void setDeptID(Long deptID) {
        this.deptID = deptID;
    }

    public String getNameDept() {
        return nameDept;
    }

    public void setNameDept(String nameDept) {
        this.nameDept = nameDept;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }


    @Override
    public String toString() {
        return "Department [DeptIT=" + deptID + ", NameDept=" + nameDept + ", Job=" + job + "]";
    }
}
