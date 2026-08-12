package com.dheeraj.payroll.services;

import com.dheeraj.payroll.model.Employee;
import com.dheeraj.payroll.repository.EmployeeRepository;

public class EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();
    public void addEmployee(long id, Employee employee){
        employeeRepository.addEmployee(id,employee);
        IO.println("The Employee Created Of ID: "+id);
    }

    public void deleteEmployee(long id){
        employeeRepository.deleteEmployee(id);
        IO.println("Deleted Employee with Id: "+id);
    
    }
}
