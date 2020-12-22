package com.example.ZPABD;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentManager {

    private final DepartmentRepository departmentRepository;

    public DepartmentManager(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
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
}
