package com.example.ZPABD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

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

        employeeRepository.save(employee);

        Iterable<Employee> emp = employeeRepository.findByFirstName("Natalia");
        for (Employee e : emp){
            System.out.println("W bazie: " + e);
        }
    }
}
