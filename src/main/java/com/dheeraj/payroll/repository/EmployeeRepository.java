package com.dheeraj.payroll.repository;

import com.dheeraj.payroll.model.Employee;

import java.util.LinkedHashMap;

public class EmployeeRepository {
    LinkedHashMap<Long, Employee> employees = new LinkedHashMap<>();
    public void addEmployee(long id,Employee employee){
        employees.put(id,employee);
    }
    public void deleteEmployee(long id){
        employees.remove(id);
    }
}
