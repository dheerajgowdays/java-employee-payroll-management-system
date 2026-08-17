package com.dheeraj.payroll.repository;

import com.dheeraj.payroll.model.Employee;
import com.dheeraj.payroll.model.Payslip;

import java.util.LinkedHashMap;
import java.util.Optional;

public class PayslipRepository {
    private final LinkedHashMap<Long, Payslip> payslips = new LinkedHashMap<>();
    public void add(long employeeId,Payslip payslip){
        payslips.put(employeeId,payslip);
    }
    public Payslip get(long employeeId){
        return payslips.get(employeeId);
    }
    public  boolean present(long employeeId){
        return payslips.containsKey(employeeId);
    }
}
