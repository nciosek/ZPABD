package com.example.ZPABD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class ApiApplication {

    private EmployeeManager employeeManager;

    @Autowired
    public ApiApplication(EmployeeManager employeeManager) {
        super();
        this.employeeManager = employeeManager;
    }

    @GetMapping("/byId")
    public Optional<Employee> getById(@RequestParam Long index){
        return employeeManager.findById(index);
    }

    @GetMapping("/all")
    public Iterable<Employee> getAll(){
        return employeeManager.findAll();
    }

    @PostMapping("/saveEmplo")
    public Employee addEmplo(@RequestBody Employee employee){
        return employeeManager.save(employee);
    }

    @DeleteMapping("/deleteEmplo")
    public void deleteEmplo(@RequestParam Long index){
        employeeManager.deleteById(index);
    }
}
