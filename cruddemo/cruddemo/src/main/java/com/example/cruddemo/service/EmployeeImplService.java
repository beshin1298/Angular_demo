package com.example.cruddemo.service;


import com.example.cruddemo.DAO.EmployeeRepository;
import com.example.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeImplService implements EmployeeService{
    EmployeeRepository employeeRepo;

   @Autowired
    public EmployeeImplService(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> findAll() {

        return employeeRepo.findAll();
    }

    @Override
    public Employee findById(int id) {
       Optional<Employee> result = employeeRepo.findById(id);
       Employee employee = null;
       if(result.isPresent()){
           employee = result.get();
       }
      return employee;

    }

    @Override
    public Employee addNewEmployee(Employee employee) {

        return employeeRepo.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
         employeeRepo.deleteById(id);
    }


}
