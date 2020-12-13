package com.example.ZPABD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiApplication {

    private EmployeeManager employeeManager;

    @Autowired
    public ApiApplication(EmployeeManager employeeManager) {
        super();
        this.employeeManager = employeeManager;
    }

    @GetMapping("/employees/byId")
    public Optional<Employee> getById(@RequestParam Long index){
        return employeeManager.findById(index);
    }

    @GetMapping("/employees/allEmplo")
    public Iterable<Employee> getAll(){
        return employeeManager.findAll();
    }

    @PostMapping("/employees/saveEmplo")
    public Employee addEmplo(@RequestBody Employee employee){
        return employeeManager.save(employee);
    }

    @DeleteMapping("/employees/deleteEmplo")
    public void deleteEmplo(@RequestParam Long index){
        employeeManager.deleteById(index);
    }

    @PutMapping("/employees/updateEmplo")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeManager.update(employee);
    }

    @GetMapping("/employees/nameEmplo")
    public Iterable<Employee> getByLastName(@RequestParam String index){
        return employeeManager.findByLastName(index);
    }

    @GetMapping("/department/byId")
    public Optional<Department> getByIdDept(@RequestParam Long id){
        return employeeManager.findByIdDept(id);
    }

    @GetMapping("/department/allDept")
    public Iterable<Department> getAllDept(){
        return employeeManager.findAllDept();
    }

    @GetMapping("/departemnt/addDept")
    public Department addDepartment(@RequestBody Department department){
        return employeeManager.saveDept(department);
    }

    @DeleteMapping("/department/deleteDept")
    public void deleteDept(@RequestParam Long index){
        employeeManager.deleteByIdDept(index);
    }
}
