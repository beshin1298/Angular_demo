package com.example.cruddemo.DAO;

import com.example.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT new com.example.cruddemo.entity.Employee(id,name,age) FROM Employee ")
    public List<Employee> getSomeThing();


}
