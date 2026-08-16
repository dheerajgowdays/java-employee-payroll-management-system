package com.dheeraj.payroll.ui;

import com.dheeraj.payroll.enums.AttendanceStatus;
import com.dheeraj.payroll.model.Attendance;
import com.dheeraj.payroll.services.AttendanceService;

import java.time.Month;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AttendanceUI {
    Scanner sc ;
    AttendanceService attendanceService;
    public AttendanceUI(AttendanceService attendanceService,Scanner sc){
        this.attendanceService = attendanceService;
        this.sc = sc;
    }

    public void markAttendance(){
        IO.println("\n==========================================");
        IO.println("               ATTENDANCE  ");
        IO.println("==========================================\n");

        IO.print("Enter Employee ID: ");
        long employeeId;
        try {
            employeeId = sc.nextLong();
            sc.nextLine();
        }catch (InputMismatchException e){
            IO.println("--------------------------------------------------------------");
            IO.println("       Invalid Input! Please Enter Numbers Only");
            IO.println("--------------------------------------------------------------");
            return;
        }

        IO.print("Mark Attendance: ");
        AttendanceStatus attendanceStatus;
        try{
            attendanceStatus = AttendanceStatus.valueOf(sc.nextLine().trim().toUpperCase());
        }catch (InputMismatchException e){
            IO.println("--------------------------------------------------------------");
            IO.println("     Invalid Input! Please Enter Valid Attendance Status");
            IO.println("--------------------------------------------------------------");
            return;
        }

        Attendance attendance = new Attendance(employeeId,attendanceStatus);

        if(attendanceService.markAttendance(employeeId,attendance)) {
            System.out.println("\n---------------------------------------------");
            System.out.printf("   Attendance Marked for Employee Id: %d   ", employeeId);
            System.out.println("\n---------------------------------------------");
        }else {
            System.out.println("\n---------------------------------------------");
            System.out.printf("   Employee With Id: %d Doest not Exist !  ", employeeId);
            System.out.println("\n---------------------------------------------");
        }
    }
    public void viewAttendance(){
        IO.println("\n==========================================");
        IO.println("               ATTENDANCE  ");
        IO.println("==========================================\n");
        IO.print("Enter the Employee Id: ");
        try{
            long employeeId = sc.nextLong();
            sc.nextLine();
            ArrayList<Attendance> list = attendanceService.viewAttendance(employeeId);
            IO.println("Employee ID: "+employeeId);
            if(list.isEmpty()){
                IO.println("\n----------------------------------------");
                IO.println("       No Attendance Records Found      ");
                IO.println("----------------------------------------\n");
            }else{
                IO.println("\n----------------------------------------");
                IO.println(" Date               |    Status         ");
                IO.println("----------------------------------------");
            }
            list.
                    forEach(attendance -> IO.println(attendance.getDate()+ "          |    " +attendance.getAttendanceStatus()));
        }catch (InputMismatchException e){
            IO.println("--------------------------------------------------------------");
            IO.println("       Invalid Input! Please Enter Numbers Only");
            IO.println("--------------------------------------------------------------");
        }
    }
    public void viewAttendanceByMonth(){
        IO.println("\n==========================================");
        IO.println("               ATTENDANCE  ");
        IO.println("==========================================\n");
        IO.print("Enter the Employee Id: ");
        try {
            long employeeId = sc.nextLong();
            sc.nextLine();
            ArrayList<Attendance> list = attendanceService.viewAttendance(employeeId);
            IO.print("Enter Month Number (1 for January, 12 for December): ");
            try {
                int monthInt = sc.nextInt();
                sc.nextLine();
                Month month = Month.of(monthInt); // Automatically validates 1–12
                IO.println("Selected Month: " + month);
                if(list.isEmpty() || list.stream().noneMatch(attendance -> attendance.getDate().getMonthValue() == monthInt)){
                    IO.println("\n----------------------------------------");
                    IO.println("       No Attendance Records Found      ");
                    IO.println("----------------------------------------\n");
                }else{
                    IO.println("\n----------------------------------------");
                    IO.println(" Date               |    Status         ");
                    IO.println("----------------------------------------");
                }
                list.stream()
                        .filter(attendance -> attendance.getDate().getMonthValue() == monthInt )
                        .forEach(attendance -> IO.println(attendance.getDate()+ "          |   " +attendance.getAttendanceStatus()) );
            } catch (Exception e) {
                IO.println("--------------------------------------------------------------");
                IO.println("    Invalid Input! Please enter a number between 1 and 12.");
                IO.println("--------------------------------------------------------------");
                sc.nextLine();
            }
        }catch (InputMismatchException e){
            IO.println("--------------------------------------------------------------");
            IO.println("       Invalid Input! Please Enter Numbers Only");
            IO.println("--------------------------------------------------------------");
        }
    }
}
