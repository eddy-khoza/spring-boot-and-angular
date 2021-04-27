package com.syre.employeemanager.service;

import com.syre.employeemanager.exception.UserNotFoundException;
import com.syre.employeemanager.model.Employee;
import com.syre.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo empRepo;

    @Autowired
    public EmployeeService(EmployeeRepo empRepo) {
        this.empRepo = empRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return empRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return empRepo.findAll();
    }

    public Employee update(Employee employee){
    return empRepo.save(employee);
    }

    public void deleteEmployee(long id){
        empRepo.deleteEmployeeById(id);
    }

    public Employee findEmployeeByID(Long id) throws Throwable {
       return empRepo.findEmployeeById(id)
               .orElseThrow(() -> new UserNotFoundException("User by id "+ id +" was not found"));
    }
}
