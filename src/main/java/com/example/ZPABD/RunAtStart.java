package com.example.ZPABD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class RunAtStart {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public RunAtStart(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @PostConstruct
    public void runAtStart(){
        Employee employee = new Employee();
        employee.setFirstName("Natalia");
        employee.setLastName("Ciosek");
        employee.setSalary(new BigDecimal("5000"));
        employee.setEmploymentDate(LocalDate.of(2019, 05, 16));
        employeeRepository.save(employee);

        Employee employee2 = new Employee();
        employee2.setFirstName("Zofia");
        employee2.setLastName("Ciepłucha");
        employee2.setSalary(new BigDecimal("75000"));
        employeeRepository.save(employee2);

        /*Iterable<Employee> emp = employeeRepository.findByFirstName("Natalia");
        for (Employee e : emp){
            System.out.println("W bazie: " + e);
        }*/

        Iterable<Employee> emplo = employeeRepository.findAllWhereName("C%");
        for (Employee e : emplo){
            System.out.println(e);
        }
    }
}
