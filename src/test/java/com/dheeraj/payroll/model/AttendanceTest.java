package com.dheeraj.payroll.model;

import com.dheeraj.payroll.enums.AttendanceStatus;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AttendanceTest {
    @Test
    void shouldCreateAttendanceCorrectly(){
        Attendance attendance = new Attendance(1, AttendanceStatus.ABSENT);
        assertEquals(1,attendance.getEmployeeId());
        assertEquals(LocalDate.now(),attendance.getDate());
        assertEquals(AttendanceStatus.ABSENT,attendance.getAttendanceStatus());
    }
}
