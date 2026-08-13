package com.dheeraj.payroll;

import com.dheeraj.payroll.ui.EmployeeOperations;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner sc = new Scanner(System.in);
        EmployeeOperations employeeOperations = new EmployeeOperations();
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
            switch (choice) {
                case 1:
                    //add employee
                    employeeOperations.addEmployee();
                    break;
                case 2:
                    //search employee
                    employeeOperations.deleteEmployee();
                    break;
                case 3:
                    //view all employee
                    employeeOperations.searchEmployee();
                    break;
                case 4:
                    employeeOperations.updateEmployee();
                    //update employee
                    break;
                case 5:
                    //remove employee
                    break;
                case 6:
                    //mark attendance
                    break;
                case 7:
                    //view employee attendance
                    break;
                case 8:
                    //view monthly attendance
                    break;
                case 9:
                    //calculate salary
                    break;
                case 10:
                    //Generate Payslip
                    break;
                case 11:
                    //view Payslip
                    break;
                case 12:
                    //employee by department
                    break;
                case 13:
                    //employee by salary
                    break;
                case 14:
                    //Highest paid employee
                    break;
                case 15:
                    //average salary
                    break;
                case 16:
                    //employee count by department
                    break;
                case 17:
                    //attendance statistics
                    break;
                case 18:
                    //exit
                    IO.println("    THANK YOU   ");
                    System.exit(0);
                default:
                    IO.println("ENTER A VALID CHOICE ! ");
            }
        }
    }
}
