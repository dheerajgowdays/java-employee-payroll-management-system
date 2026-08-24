package com.dheeraj.payroll.services;

import com.dheeraj.payroll.enums.AttendanceStatus;
import com.dheeraj.payroll.model.Attendance;
import com.dheeraj.payroll.repository.AttendanceRepository;
import com.dheeraj.payroll.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AttendanceServiceTest {

    @Test
    void shouldMarkAttendance(){
        AttendanceRepository attendanceRepository = new AttendanceRepository();
        EmployeeRepository employeeRepository = new EmployeeRepository();
        AttendanceService attendanceService = new AttendanceService(attendanceRepository,employeeRepository);
        Attendance attendance = new Attendance(1, AttendanceStatus.ABSENT);
        Attendance attendance1 = new Attendance(2,AttendanceStatus.PRESENT);
        attendanceService.markAttendance(2,attendance1);
        assertFalse(attendanceService.markAttendance(1,attendance));
    }
    @Test
    void shouldGetAttendance(){
        AttendanceRepository attendanceRepository = new AttendanceRepository();
        EmployeeRepository employeeRepository = new EmployeeRepository();
        AttendanceService attendanceService = new AttendanceService(attendanceRepository,employeeRepository);
        Attendance attendance = new Attendance(2, AttendanceStatus.ABSENT);
        Attendance attendance1 = new Attendance(2,AttendanceStatus.PRESENT);
        attendanceRepository.add(1,attendance);
        attendanceRepository.add(2,attendance1);
        attendanceService.markAttendance(2,attendance1);
        ArrayList<Attendance> list  = attendanceService.viewAttendance(2);
        assertFalse(list.isEmpty());
        assertEquals(AttendanceStatus.PRESENT,list.getFirst().getAttendanceStatus());
    }

}
