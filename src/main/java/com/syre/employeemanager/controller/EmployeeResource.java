package com.syre.employeemanager.controller;

import com.syre.employeemanager.model.Employee;
import com.syre.employeemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")Long id) throws Throwable {
        Employee employee = employeeService.findEmployeeByID(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(Employee employee){
        Employee updateEmployee = employeeService.update(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable("id")Long id) throws Throwable {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
