package com.dheeraj.payroll.services;

import com.dheeraj.payroll.model.Attendance;
import com.dheeraj.payroll.repository.AttendanceRepository;
import com.dheeraj.payroll.repository.EmployeeRepository;

import java.util.ArrayList;

public class AttendanceService {
    AttendanceRepository attendanceRepository;
    EmployeeRepository employeeRepository;
    public AttendanceService(AttendanceRepository attendanceRepository,EmployeeRepository employeeRepository){
        this.attendanceRepository = attendanceRepository;
        this.employeeRepository = employeeRepository;
    }
    public boolean markAttendance(long employeeId, Attendance attendance){
        if(employeeRepository.contains(employeeId)){
            attendanceRepository.add(employeeId,attendance);
            return true;
        }else {
            return false;
        }
    }
    public ArrayList<Attendance> viewAttendance(long employeeId){
        if(attendanceRepository.presentId(employeeId)){
            return attendanceRepository.get(employeeId);
        }
        return new ArrayList<>();
    }
}
