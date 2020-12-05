package com.example.ZPABD;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    //Iterable<Employee> findByFirstName(String firstName);
    Iterable<Employee> findByFirstName(String firstName);
}
