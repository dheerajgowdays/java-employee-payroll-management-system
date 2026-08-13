package com.dheeraj.payroll.services;

import com.dheeraj.payroll.model.Employee;
import com.dheeraj.payroll.repository.EmployeeRepository;

public class EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();

    public void output(Employee employee){
        IO.println("Employee ID  : "+employee.getEmployeeId());
        IO.println("Employee Name: "+employee.getEmployeeName());
        IO.println("Department   : "+employee.getDepartment());
        IO.println("Employee Type: "+employee.getEmployeeType());
        IO.println("Salary       : "+employee.getSalary());
        IO.println("Joining Date : "+employee.getJoiningDate());
    }
    public void addEmployee(long id, Employee employee){
        employeeRepository.addEmployee(id,employee);
        IO.println("The Employee Created Of ID: "+id);
    }
    public void searchByEmployeeId(long id){
        if(employeeRepository.contains(id)){
            Employee employee = employeeRepository.ifIdExist(id);
            output(employee);
        }else{
            IO.println("Employee Does not exist with Id: "+id);
        }
    }
    public void searchByEmployeeName(String name){
        if(employeeRepository.searchByName(name) == null){
            System.out.printf("Employee with %s Does not exist",name);
        }else{
            Employee employee = employeeRepository.searchByName(name);
            output(employee);
        }
    }

    public void deleteEmployee(long id){
        employeeRepository.deleteEmployee(id);
        IO.println("Deleted Employee with Id: "+id);
    }
}
