package com.example.ZPABD;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Iterable<Employee> findByFirstName(String firstName);
    Iterable<Employee> findByLastName(String lastName);

    /*@Query("SELECT e FROM Employee e WHERE e.lastName LIKE %?1")
    Iterable<Employee> findAllWhereName(String lastName);*/
}
