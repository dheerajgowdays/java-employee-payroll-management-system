package com.dheeraj.payroll.ui;

import com.dheeraj.payroll.enums.Department;
import com.dheeraj.payroll.model.Employee;
import com.dheeraj.payroll.services.EmployeeService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

public class ReportsUI {
    Scanner sc;
    EmployeeService employeeService;
    public ReportsUI(Scanner sc,EmployeeService employeeService){
        this.sc = sc;
        this.employeeService = employeeService;
    }
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
    public void employeeByDepartment(){
        IO.println("\n===========================================");
        IO.println("      EMPLOYEES BY DEPARTMENT REPORT ");
        IO.println("============================================\n");
        IO.println("Enter Department: ");
        try{
            Department department = Department.valueOf(sc.nextLine().trim().toUpperCase());
            List<Employee> list = employeeService.employeesByDepartment(department);
            if(list.isEmpty()){
                IO.println("----------------------------");
                IO.println("     NO Employee Exist      ");
                IO.println("----------------------------");
            }else{
                IO.println("----------------------------");
                IO.println("       EMPLOYEE LIST        ");
                IO.println("----------------------------");
                list.forEach(this::output);
            }
        }catch (IllegalArgumentException e){
            IO.println("--------------------------------------------------------");
            IO.println("    Invalid Input ! Please Enter Valid Department");
            IO.println("--------------------------------------------------------");
        }
    }
    public void employeeBySalary() {
        IO.println("\n====================================");
        IO.println("     EMPLOYEES BY SALARY REPORT ");
        IO.println("====================================\n");
        IO.println("Enter Salary: ");
        try {
            BigDecimal salary = sc.nextBigDecimal();
            List<Employee> list = employeeService.employeesBySalary(salary);
            if (list.isEmpty()) {
                IO.println("----------------------------");
                IO.println("     NO Employee Exist      ");
                IO.println("----------------------------");
            } else {
                IO.println("----------------------------");
                IO.println("       EMPLOYEE LIST        ");
                IO.println("----------------------------");
                list.forEach(this::output);
            }
        } catch (IllegalArgumentException e) {
            IO.println("--------------------------------------------------------");
            IO.println("    Invalid Input ! Please Enter Only Numbers");
            IO.println("--------------------------------------------------------");
        }
    }
    public void countByDepartment(){
        IO.println("\n======================================");
        IO.println("     EMPLOYEES COUNT BY DEPARTMENT ");
        IO.println("======================================\n");
        IO.println("Enter Department");
        try{
            Department department = Department.valueOf(sc.nextLine().trim().toUpperCase());
            List<Employee> list = employeeService.employeesByDepartment(department);
            int count = list.size();
            IO.println("\n------------------------------------------------------------");
            System.out.printf("      The Number of Employees in %s is %d",department,count);
            IO.println("\n------------------------------------------------------------");

        }catch (IllegalArgumentException e){
            IO.println("--------------------------------------------------------");
            IO.println("    Invalid Input ! Please Enter Valid Department");
            IO.println("--------------------------------------------------------");
        }
    }
    public void highestPaidEmployee(){
        IO.println("\n=================================");
        IO.println("     HIGHEST PAID EMPLOYEE");
        IO.println("=================================\n");
        IO.println("-------------------------------------");
        Optional<Employee> employee = employeeService.highestPaidEmployee();
        employee.ifPresent(this::output);
    }
    public void averageSalary(){
        IO.println("\n==================================");
        IO.println("    AVERAGE SALARY BY DEPARTMENT");
        IO.println("====================================");
        IO.println("Enter Department: ");
        Department department = Department.valueOf(sc.nextLine().trim().toUpperCase());
        IO.println("---------------------------------------------------");
        System.out.println("Average salary Of department %s%n: "+department+employeeService.averageSalary(department));
        IO.println("---------------------------------------------------");
    }
}
