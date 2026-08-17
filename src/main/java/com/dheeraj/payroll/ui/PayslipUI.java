package com.dheeraj.payroll.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PayslipUI {
    Scanner sc;
    public PayslipUI(Scanner sc){
        this.sc = sc;
    }
    public void calculateSalary(){
        IO.println("\n--------------------------------------------");
        IO.println("           CALCULATE SALARY ");
        IO.println("-------------------------------------------- \n");
        IO.println("Enter Employee Id: ");
        try{
            long employeeId = sc.nextLong();
            try {
                IO.println("Enter Bonus(%): ");
                int bonus = sc.nextInt();
                
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
}
