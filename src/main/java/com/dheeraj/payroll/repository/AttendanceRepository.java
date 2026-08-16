package com.dheeraj.payroll.repository;

import com.dheeraj.payroll.model.Attendance;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class AttendanceRepository {
    private final LinkedHashMap<Long,ArrayList<Attendance>> attendances = new LinkedHashMap<>();

    public void add(long employeeId,Attendance attendance){
        attendances.computeIfAbsent(employeeId,k->new ArrayList<>()).add(attendance);
    }
    public boolean presentId(long employeeId){
        return attendances.containsKey(employeeId);
    }
    public ArrayList<Attendance> get(long employeeId){
       return attendances.get(employeeId);
    }
}
