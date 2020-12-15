package com.example.ZPABD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class EmployeeManager {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public EmployeeManager(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        super();
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public Optional<Employee> findById(Long id){
        return employeeRepository.findById(id);
    }

    public Iterable<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteById(Long id){
        employeeRepository.deleteById(id);
    }

    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Iterable<Employee> findByLastName(String lastName){
        return employeeRepository.findByLastName(lastName);
    }

    public Optional<Department> findByIdDept(Long id){
        return departmentRepository.findById(id);
    }

    public Iterable<Department> findAllDept(){
        return departmentRepository.findAll();
    }

    public Department saveDept(Department department){
        return departmentRepository.save(department);
    }

    public void deleteByIdDept(Long id){
        departmentRepository.deleteById(id);
    }

    @PostConstruct
    public void runAtStart(){
        Department department = new Department();
        department.setNameDept("IT");
        department.setJob("Manager");
        departmentRepository.save(department);

        Department department2 = new Department();
        department2.setNameDept("Production");
        department2.setJob("Staff");
        departmentRepository.save(department2);

        Employee employee = new Employee();
        employee.setIdDept(department.getDeptID());
        employee.setFirstName("Natalia");
        employee.setLastName("Ciosek");
        employee.setSalary(new BigDecimal("5000"));
        employee.setEmploymentDate(LocalDate.of(2019, 05, 16));
        employeeRepository.save(employee);

        Employee employee2 = new Employee();
        employee2.setFirstName("Zofia");
        employee2.setLastName("Ciepłucha");
        employee2.setDepartment(department);
        employee2.setSalary(new BigDecimal("75000"));
        employee.setEmploymentDate(LocalDate.of(2020, 02, 27));
        employeeRepository.save(employee2);

        Employee employee3 = new Employee();
        employee3.setFirstName("Dawid");
        employee3.setLastName("Karolewski");
        employee3.setDepartment(department2);
        employee3.setSalary(new BigDecimal("1000"));
        employeeRepository.save(employee3);

        Employee employee4 = new Employee();
        employee4.setFirstName("Dawid");
        employee4.setLastName("Karolewski");
        employee4.setDepartment(department2);
        employee4.setSalary(new BigDecimal("1000"));
        employeeRepository.save(employee4);


        Iterable<Employee> emp = employeeRepository.findByFirstName("Natalia");
        for (Employee e : emp){
            System.out.println("W bazie: " + e);
        }

        /*Iterable<Employee> emplo = employeeRepository.findAllWhereName("K%");
        for (Employee e : emplo){
            System.out.println("W bazie nazwiska na literę K: \n" + e);
        }*/
    }
}
