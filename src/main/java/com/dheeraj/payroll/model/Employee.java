package com.dheeraj.payroll.model;

import com.dheeraj.payroll.enums.Department;
import com.dheeraj.payroll.enums.EmployeeType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {

    private final long employeeId;
    private String employeeName;
    private Department department;
    private EmployeeType employeeType;
    private BigDecimal salary;
    private final LocalDate joiningDate;

    public Employee(long employeeId,String employeeName,Department department,EmployeeType employeeType,BigDecimal salary){
        this.employeeId  = employeeId;
        this.department = department;
        this.employeeName = employeeName;
        this.employeeType = employeeType;
        this.salary = salary;
        this.joiningDate = LocalDate.now();
    }

    public long getEmployeeId(){
        return employeeId;
    }
    public String getEmployeeName(){
        return employeeName;
    }
    public void setEmployeeName(String employeeName){
        this.employeeName = employeeName;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department){
        this.department= department;
    }
    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
    public LocalDate getJoiningDate() {
        return joiningDate;
    }
}
