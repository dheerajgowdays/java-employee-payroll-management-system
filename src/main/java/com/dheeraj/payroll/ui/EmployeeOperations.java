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
        IO.print("Enter Employee Name: ");
        String employeeName = sc.nextLine();
        IO.print("Enter Department: ");
        Department department = Department.valueOf(sc.nextLine());
        IO.print("Enter Employee Type: ");
        EmployeeType employeeType = EmployeeType.valueOf(sc.nextLine());
        IO.print("Enter Salary: ");
        BigDecimal salary = sc.nextBigDecimal();
        long employeeId = generator.employeeIdGenerator();
        Employee employee = new Employee(employeeId,employeeName,department,employeeType,salary);
        employeeService.addEmployee(employeeId,employee);
    }
    public void searchEmployee(){
        IO.println("========= SEARCH EMPLOYEE ==========");
        while(true){
            IO.println("1. SEARCH BY EMPLOYEE ID");
            IO.println("2. SEARCH BY EMPLOYEE NAME\n");
            IO.println("Enter Your Search: ");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    IO.println("Enter Employee ID: ");
                    long employeeId = sc.nextLong();
                    employeeService.searchByEmployeeId(employeeId);
                    break;
                case 2:
                    IO.println("Enter Employee Name: ");
                    String employeeName = sc.nextLine();
                    employeeService.searchByEmployeeName(employeeName);
                    break;
                default:
                    IO.println("Enter valid choice !");
            }
        }
    }
    public void deleteEmployee(){
        IO.println("Enter Employee ID: ");
        long employeeId = sc.nextLong();
        employeeService.deleteEmployee(employeeId);
    }
}
