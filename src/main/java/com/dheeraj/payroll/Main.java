package com.dheeraj.payroll;

import com.dheeraj.payroll.model.Payslip;
import com.dheeraj.payroll.repository.AttendanceRepository;
import com.dheeraj.payroll.repository.EmployeeRepository;
import com.dheeraj.payroll.repository.PayslipRepository;
import com.dheeraj.payroll.services.AttendanceService;
import com.dheeraj.payroll.services.EmployeeService;
import com.dheeraj.payroll.services.PayslipService;
import com.dheeraj.payroll.ui.AttendanceUI;
import com.dheeraj.payroll.ui.EmployeeUI;
import com.dheeraj.payroll.ui.PayslipUI;
import com.dheeraj.payroll.ui.ReportsUI;
import com.dheeraj.payroll.util.Generator;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner sc = new Scanner(System.in);
        Generator generator = new Generator();
        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        EmployeeUI employeeOperations = new EmployeeUI(generator,employeeService,sc);
        AttendanceRepository attendanceRepository = new AttendanceRepository();
        AttendanceService attendanceService = new AttendanceService(attendanceRepository,employeeRepository);
        AttendanceUI attendanceUI = new AttendanceUI(attendanceService,sc);
        PayslipRepository payslipRepository = new PayslipRepository();
        PayslipService payslipService = new PayslipService(employeeService,payslipRepository);
        PayslipUI payslipUI = new PayslipUI(sc,payslipService);
        ReportsUI reportsUI = new ReportsUI(sc,employeeService);
        while (true){
            IO.println("\n========================================");
            IO.println("     Employee Payroll Management");
            IO.println("========================================");
            IO.println("\nEMPLOYEE");
            IO.println("1.  ADD EMPLOYEE");
            IO.println("2.  SEARCH EMPLOYEE");
            IO.println("3.  VIEW ALL EMPLOYEE");
            IO.println("4.  UPDATE EMPLOYEE");
            IO.println("5.  REMOVE EMPLOYEE\n");
            IO.println("ATTENDANCE");
            IO.println("6.  MARK ATTENDANCE");
            IO.println("7.  VIEW EMPLOYEE ATTENDANCE");
            IO.println("8.  VIEW MONTHLY ATTENDANCE \n");
            IO.println("PAYROLL");
            IO.println("9.  CALCULATE SALARY");
            IO.println("10. GENERATE PAYSLIP");
            IO.println("11. VIEW PAYSLIP\n");
            IO.println("REPORTS");
            IO.println("12. EMPLOYEE BY DEPARTMENT");
            IO.println("13. EMPLOYEE BY SALARY");
            IO.println("14. HIGHEST PAYED EMPLOYEES");
            IO.println("15. AVERAGE SALARY");
            IO.println("16. EMPLOYEE COUNT BY DEPARTMENT");
            IO.println("17. ATTENDANCE STATISTICS\n");
            IO.println("18. EXIT");
            IO.println("\n  Enter Your Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    //add employee
                    employeeOperations.addEmployee();
                    break;
                case 2:
                    //search employee
                    employeeOperations.searchEmployee();
                    break;
                case 3:
                    //view all employee
                    employeeOperations.getAllEmployee();
                    break;
                case 4:
                    //update employee
                    employeeOperations.updateEmployee();
                    break;
                case 5:
                    //remove employee
                    employeeOperations.deleteEmployee();
                    break;
                case 6:
                    //mark attendance
                    attendanceUI.markAttendance();
                    break;
                case 7:
                    //view employee attendance
                    attendanceUI.viewAttendance();
                    break;
                case 8:
                    //view monthly attendance
                    attendanceUI.viewAttendanceByMonth();
                    break;
                case 9:
                    //calculate salary
                    payslipUI.calculateSalary();
                    break;
                case 10:
                    //Generate Payslip
                    payslipUI.generatePayslip();
                    break;
                case 11:
                    //view Payslip
                    payslipUI.viewPayslip();
                    break;
                case 12:
                    //employee by department
                    reportsUI.employeeByDepartment();
                    break;
                case 13:
                    //employee by salary
                    reportsUI.employeeBySalary();
                    break;
                case 14:
                    //Highest paid employee
                    reportsUI.highestPaidEmployee();
                    break;
                case 15:
                    //average salary
                    break;
                case 16:
                    //employee count by department
                    reportsUI.countByDepartment();
                    break;
                case 17:
                    //attendance statistics
                    break;
                case 18:
                    //exit
                    IO.println("    THANK YOU   ");
                    System.exit(0);
                default:
                    IO.println("-----------------------------");
                    IO.println("    ENTER A VALID CHOICE !");
                    IO.println("-----------------------------");
            }
        }
    }
}
