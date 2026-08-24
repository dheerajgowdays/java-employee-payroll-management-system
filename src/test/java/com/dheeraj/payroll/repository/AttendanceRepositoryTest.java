package com.dheeraj.payroll.repository;

import com.dheeraj.payroll.enums.AttendanceStatus;
import com.dheeraj.payroll.model.Attendance;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AttendanceRepositoryTest {
    @Test
    void shouldAddAttendance(){
        AttendanceRepository attendanceRepository = new AttendanceRepository();
        Attendance attendance = new Attendance(1, AttendanceStatus.ABSENT);
        Attendance attendance1 = new Attendance(2,AttendanceStatus.PRESENT);
        attendanceRepository.add(1,attendance);
        attendanceRepository.add(2,attendance1);
        ArrayList<Attendance> list = attendanceRepository.get(1);
        assertEquals(1,list.size());
    }
    @Test
    void checkAttendance(){
        AttendanceRepository attendanceRepository = new AttendanceRepository();
        Attendance attendance = new Attendance(1, AttendanceStatus.ABSENT);
        attendanceRepository.add(1,attendance);
        assertTrue(attendanceRepository.presentId(1));
        assertFalse(attendanceRepository.presentId(2));
    }
}
