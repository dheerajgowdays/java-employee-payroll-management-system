package com.dheeraj.payroll.util;

public class Generator {
    long id = 1;
    public long employeeIdGenerator(){
        return id++;
    }
}
