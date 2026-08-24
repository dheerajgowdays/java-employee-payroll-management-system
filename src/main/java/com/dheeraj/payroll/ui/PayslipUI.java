package com.dheeraj.payroll.ui;

import com.dheeraj.payroll.model.Payslip;
import com.dheeraj.payroll.services.PayslipService;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class PayslipUI {
    Scanner sc;
    PayslipService payslipService;
    public PayslipUI(Scanner sc,PayslipService payslipService){
        this.sc = sc;
        this.payslipService = payslipService;
    }
    public void payslip(Payslip payslip){
        IO.println("\nEmployee Id : "+payslip.getEmployeeId());
        IO.println("Employee Name :"+payslip.getEmployeeName());
        IO.println("Department    :"+payslip.getDepartment());
        IO.println("Pay Period    :"+payslip.getPayPeriod());
        IO.println("\n---------------------------------------");
        IO.println("Basic Salary  : ₹"+payslip.getBasicSalary());
        IO.println("Bonus         : ₹"+payslip.getBonus());
        IO.println("Tax           : ₹"+payslip.getTax());
        IO.println("-----------------------------------------");
        IO.println("Net Salary    : ₹"+payslip.getNetSalary());
        IO.println("========================================\n");


    }
    public void calculateSalary(){
        IO.println("\n=============================================");
        IO.println("           CALCULATE SALARY ");
        IO.println("=============================================\n");
        IO.print("Enter Employee Id: ");
        try{
            long employeeId = sc.nextLong();
            try {
                IO.print("Enter Bonus(%): ");
                BigDecimal bonus = sc.nextBigDecimal();
                BigDecimal netSalary = payslipService.calculateSalary(employeeId,bonus);
                IO.println("----------------------------------------------------");
                IO.println("         The Net Salary is : "+netSalary);
                IO.println("----------------------------------------------------");
            }catch (InputMismatchException e){
                IO.println("--------------------------------------------------------");
                IO.println("    Invalid Input ! Please Enter Only Numbers");
                IO.println("--------------------------------------------------------");
            }
        }catch (InputMismatchException e){
            IO.println("--------------------------------------------------------");
            IO.println("    Invalid Input ! Please Enter Only Numbers");
            IO.println("--------------------------------------------------------");
        }
    }
    public void generatePayslip(){
        IO.println("\n========================================");
        IO.println("          GENERATE PAYSLIP");
        IO.println("========================================\n");
        IO.print("Enter Employee ID: ");
        try{
            long employeeId = sc.nextLong();
            sc.nextLine();
            if(!payslipService.check(employeeId)){
                IO.println("--------------------------------------------");
                IO.println("     Employee Does not exist with Id: "+employeeId);
                IO.println("--------------------------------------------");
                return;
            }
            try{
                IO.print("Enter PayPeriod: ");
                YearMonth payPeriod = YearMonth.parse(sc.nextLine().trim());
                try {
                    IO.print("Enter Bonus(%): ");
                    BigDecimal bonus = sc.nextBigDecimal();
                    payslipService.generatePayslip(employeeId,payPeriod,bonus);
                    IO.println("--------------------------------------------");
                    IO.println("   The Payslip Generated Successfully");
                    IO.println("--------------------------------------------");


                }catch (InputMismatchException e){
                    IO.println("--------------------------------------------------------");
                    IO.println("    Invalid Input ! Please Enter Only Numbers");
                    IO.println("--------------------------------------------------------");
                }
            }catch (DateTimeParseException e) {
                IO.println("----------------------------------------------------------");
                IO.println("    Invalid format! Please use YYYY-MM (e.g., 2026-08).");
                IO.println("----------------------------------------------------------");
            }
        }catch (InputMismatchException e){
            IO.println("--------------------------------------------------------");
            IO.println("    Invalid Input ! Please Enter Only Numbers");
            IO.println("--------------------------------------------------------");
        }
    }
    public void viewPayslip(){
        IO.println("\n========================================");
        IO.println("                PAYSLIP");
        IO.println("========================================\n");
        IO.println("Enter Employee ID: ");
        try{
            long employeeId = sc.nextLong();
            Optional<Payslip> payslip = payslipService.viewPayslip(employeeId);
            payslip.ifPresent(this::payslip);
        }catch(InputMismatchException e){
            IO.println("--------------------------------------------------------");
            IO.println("    Invalid Input ! Please Enter Only Numbers");
            IO.println("--------------------------------------------------------");
        }
    }
}
