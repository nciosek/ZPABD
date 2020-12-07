package com.example.ZPABD;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lastName;
    private String firstName;
    private BigDecimal salary;
    private LocalDate employmentDate;

    @ManyToOne
    @JoinColumn(name="departmentId")
    private Department department;

    public Employee() { super(); }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) { this.firstName = firstName;}

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getEmploymentDate() { return employmentDate; }

    public void setEmploymentDate(LocalDate employmentDate) { this.employmentDate = employmentDate; }

    public Department getDepartment() { return department; }

    public void setDepartment(Department department) { this.department = department; }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", salary=" + salary + ", date=" + employmentDate +", department=" + department +" ]";
    }

}
