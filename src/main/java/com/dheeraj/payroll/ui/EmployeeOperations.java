package com.dheeraj.payroll.ui;

import com.dheeraj.payroll.enums.Department;
import com.dheeraj.payroll.enums.EmployeeType;
import com.dheeraj.payroll.model.Employee;
import com.dheeraj.payroll.services.EmployeeService;
import com.dheeraj.payroll.util.Generator;

import java.math.BigDecimal;
import java.util.Scanner;

public class EmployeeOperations {
    Scanner sc = new Scanner(System.in);
    Generator generator = new Generator();
    EmployeeService employeeService = new EmployeeService();
    public void addEmployee(){
        IO.println("Enter Employee Name: ");
        String employeeName = sc.nextLine();
        IO.println("Enter Department: ");
        Department department = Department.valueOf(sc.nextLine());
        IO.println("Enter Employee Type: ");
        EmployeeType employeeType = EmployeeType.valueOf(sc.nextLine());
        IO.println("Enter Salary: ");
        BigDecimal salary = sc.nextBigDecimal();
        long employeeId = generator.employeeIdGenerator();
        Employee employee = new Employee(employeeId,employeeName,department,employeeType,salary);
        employeeService.addEmployee(employeeId,employee);
    }
}
