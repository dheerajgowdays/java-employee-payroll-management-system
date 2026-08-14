package com.dheeraj.payroll.services;

import com.dheeraj.payroll.enums.Department;
import com.dheeraj.payroll.enums.EmployeeType;
import com.dheeraj.payroll.model.Employee;
import com.dheeraj.payroll.repository.EmployeeRepository;

import java.math.BigDecimal;
import java.util.List;

public class EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();

    public void output(Employee employee){
        IO.println("\n--------------------------------------------");
        IO.println("Employee ID  : "+employee.getEmployeeId());
        IO.println("Employee Name: "+employee.getEmployeeName());
        IO.println("Department   : "+employee.getDepartment());
        IO.println("Employee Type: "+employee.getEmployeeType());
        IO.println("Salary       : "+employee.getSalary());
        IO.println("Joining Date : "+employee.getJoiningDate());
        IO.println("--------------------------------------------");
    }
    public void addEmployee(long id, Employee employee){
        employeeRepository.addEmployee(id,employee);
        IO.println("--------------------------------------------------");
        IO.println("       The Employee Created Of ID: "+id);
        IO.println("--------------------------------------------------");
    }
    public void searchByEmployeeId(long id){
        if(employeeRepository.contains(id)){
            Employee employee = employeeRepository.ifIdExist(id);
            output(employee);
        }else{
            IO.println("--------------------------------------------");
            IO.println("     Employee Does not exist with Id: "+id);
            IO.println("--------------------------------------------");
        }
    }
    public void getAllEmployee() {
        List<Employee> employees = (List<Employee>) employeeRepository.getAllEmployee();

        if (employees.isEmpty()) {
            IO.println("----------------------------");
            IO.println("     NO Employee Exist      ");
            IO.println("----------------------------");
        } else {
            IO.println("----------------------------");
            IO.println("       EMPLOYEE LIST        ");
            IO.println("----------------------------");
            employees
                    .forEach(this::output);
        }
    }
    public boolean checkID(long id){
        return employeeRepository.contains(id);
    }
    public void updateEmployeeName(long id,String name){
        Employee employee = employeeRepository.ifIdExist(id);
        employee.setEmployeeName(name);
        IO.println("-------------------------------------------");
        IO.println("    Employee Name Updated Successfully");
        IO.println("-------------------------------------------");
    }
    public void updateEmployeeDepartment(long id, Department department){
        Employee employee = employeeRepository.ifIdExist(id);
        employee.setDepartment(department);
        IO.println("--------------------------------------------------");
        IO.println("     Employee Department Updated Successfully");
        IO.println("--------------------------------------------------");
    }
    public void updateEmployeeType(long id, EmployeeType employeeType){
        Employee employee = employeeRepository.ifIdExist(id);
        employee.setEmployeeType(employeeType);
        IO.println("--------------------------------------------------");
        IO.println("       Employee Type Updated Successfully");
        IO.println("--------------------------------------------------");
    }
    public void updateSalary(long id, BigDecimal salary){
        Employee employee = employeeRepository.ifIdExist(id);
        employee.setSalary(salary);
        IO.println("--------------------------------------------------");
        IO.println("     Employee Salary Updated Successfully");
        IO.println("--------------------------------------------------");
    }
    public void deleteEmployee(long id){
        if(!employeeRepository.contains(id)){
            IO.println("--------------------------------------------------");
            IO.println("      Employee does not exist with ID: "+id);
            IO.println("--------------------------------------------------");
        }else {
            employeeRepository.deleteEmployee(id);
            IO.println("----------------------------------------------------");
            IO.println("     Successfully Deleted Employee with Id: " + id);
            IO.println("----------------------------------------------------");
        }
    }
}
