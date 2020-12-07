package com.example.ZPABD;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IDdept;
    private String NameDept;
    private String job;

    @OneToMany(cascade= {CascadeType.REFRESH, CascadeType.REMOVE}, mappedBy = "department")
    Set<Employee> employees;

    public Long getIDdept() {
        return IDdept;
    }

    public void setIDdept(Long IDdept) {
        this.IDdept = IDdept;
    }

    public String getNameDept() {
        return NameDept;
    }

    public void setNameDept(String nameDept) {
        NameDept = nameDept;
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
        return "Department [IDdept=" + IDdept + ", NameDept=" + NameDept + ", Job=" + job + ", Employees=" + employees + "]";
    }
}
