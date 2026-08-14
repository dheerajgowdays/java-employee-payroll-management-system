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
        sc.nextLine();
        long employeeId = generator.employeeIdGenerator();
        Employee employee = new Employee(employeeId,employeeName,department,employeeType,salary);
        employeeService.addEmployee(employeeId,employee);
    }
    public void searchEmployee(){
        IO.print("Enter Employee ID: ");
        long employeeId = sc.nextLong();
        employeeService.searchByEmployeeId(employeeId);
    }
    public void updateEmployee(){
        IO.print("Enter Employee Id: ");
        long employeeId = sc.nextLong();
        if(!employeeService.checkID(employeeId)){
            IO.println("-----------------------------");
            IO.println("      Enter A Valid ID");
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
                        String employeeName = sc.nextLine();
                        employeeService.updateEmployeeName(employeeId,employeeName);
                        break;
                    case 2:
                        IO.print("Enter Employee Department: ");
                        Department department = Department.valueOf(sc.nextLine());
                        employeeService.updateEmployeeDepartment(employeeId,department);
                        break;
                    case 3:
                        IO.print("Enter Employee Type: ");
                        EmployeeType employeeType = EmployeeType.valueOf(sc.nextLine());
                        employeeService.updateEmployeeType(employeeId,employeeType);
                        break;
                    case 4:
                        IO.print("Enter Salary: ");
                        BigDecimal salary = sc.nextBigDecimal();
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
        long employeeId = sc.nextLong();
        employeeService.deleteEmployee(employeeId);
    }
}
