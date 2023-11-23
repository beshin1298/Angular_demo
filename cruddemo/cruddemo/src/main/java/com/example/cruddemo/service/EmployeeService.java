package com.example.cruddemo.service;

import com.example.cruddemo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findById(int id);

    public Employee addNewEmployee(Employee employee);
    public void deleteEmployee(int id);
}
