package com.dheeraj.payroll.ui;
import com.dheeraj.payroll.enums.Department;
import com.dheeraj.payroll.enums.EmployeeType;
import com.dheeraj.payroll.model.Employee;
import com.dheeraj.payroll.repository.EmployeeRepository;
import com.dheeraj.payroll.services.EmployeeService;
import com.dheeraj.payroll.util.Generator;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeUI {
    Scanner sc = new Scanner(System.in);
    Generator generator = new Generator();
    EmployeeRepository employeeRepository = new EmployeeRepository();
    EmployeeService employeeService = new EmployeeService(employeeRepository);
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
    public void addEmployee() {
        sc.nextLine();
        IO.print("Enter Employee Name: ");
        String employeeName = "";
        try {
            employeeName = sc.nextLine();
        } catch (IllegalArgumentException e) {
            IO.println("Invalid Input! Please Enter String Only");
        }
        IO.print("Enter Department: ");
        Department department = null;
        try {
            department = Department.valueOf(sc.nextLine().trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            IO.println("Invalid Input! Please Enter Valid Department Only");
        }
        IO.print("Enter Employee Type: ");
        EmployeeType employeeType = null;
        try {
            employeeType = EmployeeType.valueOf(sc.nextLine().trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            IO.println("Invalid Input! Please Enter Valid Employee Type Only");
        }
        IO.print("Enter Salary: ");
        BigDecimal salary = null;
        try {
            salary = sc.nextBigDecimal();
        } catch (InputMismatchException e) {
            IO.println("Invalid Input! Please Enter Numbers Only");
        }
        long employeeId = generator.employeeIdGenerator();
        Employee employee = new Employee(employeeId, employeeName, department, employeeType, salary);
        if(employeeService.addEmployee(employeeId, employee)){
            IO.println("--------------------------------------------------");
            IO.println("       The Employee Created Of ID: "+employeeId);
            IO.println("--------------------------------------------------");
        }
    }
    public void searchEmployee() {
        IO.print("Enter Employee ID: ");
        try {
            long employeeId = sc.nextLong();
            employeeService.searchByEmployeeId(employeeId);
        } catch (InputMismatchException e) {
            IO.println("Invalid Input! Please Enter  Numbers Only");
        }
    }
    public void updateEmployee(){
        IO.print("Enter Employee Id: ");
        long employeeId = 0;
        try {
            employeeId = sc.nextLong();
        } catch (InputMismatchException e) {
            IO.println("Invalid Input! Please Enter  Numbers Only");
        }
        if(!employeeService.checkID(employeeId)){
            IO.println("\n-----------------------------");
            IO.println("    ENTER A VALID ID !");
            IO.println("-----------------------------");
        }else{
            label:
            while (true){
                IO.println("\n==========================");
                IO.println("         UPDATE           ");
                IO.println("==========================");
                IO.println("1. UPDATE EMPLOYEE NAME ");
                IO.println("2. UPDATE EMPLOYEE DEPARTMENT");
                IO.println("3. UPDATE EMPLOYEE TYPE");
                IO.println("4. UPDATE EMPLOYEE SALARY");
                IO.println("5. Exit");
                IO.print("Enter Your Choice: ");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice){
                    case 1:
                        IO.print("Enter Employee Name: ");
                        String employeeName = "";
                        try {
                            employeeName = sc.nextLine();
                        } catch (IllegalArgumentException e) {
                            IO.println("Invalid Input! Please Enter String Only");
                        }
                        employeeService.updateEmployeeName(employeeId,employeeName);
                        break;
                    case 2:
                        IO.print("Enter Employee Department: ");
                        Department department = null;
                        try {
                            department = Department.valueOf(sc.nextLine().trim().toUpperCase());
                        } catch (IllegalArgumentException e) {
                            IO.println("Invalid Input! Please Enter Valid Department Only");
                        }
                        employeeService.updateEmployeeDepartment(employeeId,department);
                        break;
                    case 3:
                        IO.print("Enter Employee Type: ");
                        EmployeeType employeeType = null;
                        try {
                            employeeType = EmployeeType.valueOf(sc.nextLine().trim().toUpperCase());
                        } catch (IllegalArgumentException e) {
                            IO.println("Invalid Input! Please Enter Valid Employee Type Only");
                        }
                        employeeService.updateEmployeeType(employeeId,employeeType);
                        break;
                    case 4:
                        IO.print("Enter Salary: ");
                        BigDecimal salary = null;
                        try {
                            salary = sc.nextBigDecimal();
                            sc.nextLine();
                        } catch (InputMismatchException e) {
                            IO.println("Invalid Input! Please Enter Numbers Only");
                        }
                        employeeService.updateSalary(employeeId,salary);
                        break;
                    case 5:
                        break label;
                    default:
                        IO.println("-----------------------------");
                        IO.println("    ENTER A VALID CHOICE !");
                        IO.println("-----------------------------");
                }
            }
        }
    }
    public void getAllEmployee(){
        employeeService.getAllEmployee();
    }
    public void deleteEmployee(){
        IO.print("Enter Employee ID: ");
        try {
            long employeeId = sc.nextLong();
            employeeService.deleteEmployee(employeeId);

        } catch (InputMismatchException e) {
            IO.println("Invalid Input! Please Enter  Numbers Only");
        }
    }
}
