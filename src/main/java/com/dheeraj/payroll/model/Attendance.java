package com.dheeraj.payroll.model;

import com.dheeraj.payroll.enums.AttendanceStatus;

import java.time.LocalDate;


public class Attendance {

    private final long employeeId;
    private final LocalDate date;
    private final AttendanceStatus attendanceStatus;

    public Attendance(long employeeId ,AttendanceStatus attendanceStatus){
        this.employeeId = employeeId;
        this.date = LocalDate.now();
        this.attendanceStatus = attendanceStatus;
    }

    public long getEmployeeId(){
        return employeeId;
    }
    public LocalDate getDate(){
        return date;
    }
    public AttendanceStatus getAttendanceStatus(){
        return attendanceStatus;
    }

}
