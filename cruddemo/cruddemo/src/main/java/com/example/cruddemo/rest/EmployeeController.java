package com.example.cruddemo.rest;

import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.service.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id){
        if (employeeService.findById(id) == null || id <= 0){
             throw new RuntimeException("Employee not found");
        }
        return employeeService.findById(id);

    }
    @PostMapping("/employees")
    public  Employee addNewEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        if(employee.getAge()<=18){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Wrong information",new Exception());
        }

        Employee dbEmployee = employeeService.addNewEmployee(employee);
        return dbEmployee;
    }
    @PutMapping("/employees")
    public  Employee SaveEmployee(@RequestBody Employee employee) {
        if(employee.getAge() < 18){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Age must be larger than 17: "+ employee.getId(),new Exception());
        }
//        if( employee.getPosition() < 0 ){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Position invalid",new Exception());
//        }

        Employee dbEmployee = employeeService.addNewEmployee(employee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{id}")
    public String DeleteEmployee(@PathVariable int id){
        Employee findEmployee = employeeService.findById(id);
        if(id < 0 || findEmployee == null){
            return "Not found employee has id "+id;

        }else{
            employeeService.deleteEmployee(id);
            return "Delete success employee id "+id;
        }

    }
}
