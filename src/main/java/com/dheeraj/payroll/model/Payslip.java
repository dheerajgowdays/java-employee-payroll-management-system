package com.dheeraj.payroll.model;

import com.dheeraj.payroll.enums.Department;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.YearMonth;

public class Payslip {

    private final long employeeId;
    private String employeeName;
    private YearMonth payPeriod;
    private Department department;
    private BigDecimal basicSalary;
    private BigDecimal bonus;
    private BigDecimal tax;
    private BigDecimal netSalary;
    private LocalDateTime generatedAt;

    public Payslip(long employeeId,String employeeName,YearMonth payPeriod,BigDecimal basicSalary,BigDecimal bonus,BigDecimal tax,BigDecimal netSalary,Department department){
        this.employeeId =employeeId;
        this.employeeName = employeeName;
        this.payPeriod = payPeriod;
        this.basicSalary =basicSalary;
        this.bonus = bonus;
        this.tax = tax;
        this.netSalary = netSalary;
        this.generatedAt = LocalDateTime.now();
        this.department = department;
    }
    public long getEmployeeId(){
        return employeeId;
    }
    public String getEmployeeName(){
        return employeeName;
    }
    public Department getDepartment(){
        return department;
    }
    public YearMonth getPayPeriod(){
        return payPeriod;
    }
    public BigDecimal getBasicSalary(){
        return basicSalary;
    }
    public BigDecimal getBonus(){
        return bonus;
    }
    public BigDecimal getTax(){
        return tax;
    }
    public BigDecimal getNetSalary(){
        return netSalary;
    }
    public LocalDateTime getGeneratedAt(){
        return  generatedAt;
    }

}
