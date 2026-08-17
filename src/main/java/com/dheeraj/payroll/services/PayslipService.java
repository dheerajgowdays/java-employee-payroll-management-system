package com.dheeraj.payroll.services;

import com.dheeraj.payroll.model.Employee;
import com.dheeraj.payroll.model.Payslip;
import com.dheeraj.payroll.repository.PayslipRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.YearMonth;
import java.util.Optional;

public class PayslipService {
    EmployeeService employeeService;
    PayslipRepository payslipRepository;
    public PayslipService(EmployeeService employeeService,PayslipRepository payslipRepository){
        this.employeeService = employeeService;
        this.payslipRepository = payslipRepository;
    }
    public BigDecimal tax(BigDecimal salary){
        if(salary.compareTo(BigDecimal.ZERO)>=0 && salary.compareTo(BigDecimal.valueOf(4000000))<=0){
            return BigDecimal.valueOf(0);
        }else if (salary.compareTo(BigDecimal.valueOf(400001))>=0 && salary.compareTo(BigDecimal.valueOf(800000))<=0){
            return BigDecimal.valueOf(5);
        }else if (salary.compareTo(BigDecimal.valueOf(800001))>=0 && salary.compareTo(BigDecimal.valueOf(1200000))<=0){
            return BigDecimal.valueOf(10);
        }else if(salary.compareTo(BigDecimal.valueOf(1200001))>=0 && salary.compareTo(BigDecimal.valueOf(1600000))<=0){
            return BigDecimal.valueOf(15);
        }else if(salary.compareTo(BigDecimal.valueOf(1600001))>=0 && salary.compareTo(BigDecimal.valueOf(2000000))<=0){
            return BigDecimal.valueOf(20);
        }else if(salary.compareTo(BigDecimal.valueOf(2000001))>=0 && salary.compareTo(BigDecimal.valueOf(2400000))<=0){
            return BigDecimal.valueOf(25);
        }else{
        return BigDecimal.valueOf(30);
        }
    }

    public BigDecimal calculateSalary(long employeeId, BigDecimal bonus ){
        Optional<Employee> employee = employeeService.searchByEmployeeId(employeeId);
        BigDecimal salary = employee.map(Employee::getSalary).orElse(BigDecimal.ZERO);
        BigDecimal tax =tax(salary);
        BigDecimal taxAmount = salary.multiply(tax)
                .divide(BigDecimal.valueOf(100),2, RoundingMode.HALF_UP);
        return salary.subtract(taxAmount)
                .add(salary.divide(bonus,2,RoundingMode.HALF_UP));
    }
    public void generatePayslip(long employeeId, YearMonth payPeriod,BigDecimal bonus){
        Optional<Employee> employee = employeeService.searchByEmployeeId(employeeId);
        BigDecimal salary = employee.map(Employee::getSalary).orElse(BigDecimal.ZERO);
        Payslip payslip = new Payslip(employeeId,employee.map(Employee::getEmployeeName).orElse(""),payPeriod,salary,bonus,tax(salary),calculateSalary(employeeId,bonus),employee.map(Employee::getDepartment).orElse(null));
        payslipRepository.add(employeeId,payslip);
    }
    public Optional<Payslip> viewPayslip(long employeeId){
        if(payslipRepository.present(employeeId)){
            return Optional.ofNullable(payslipRepository.get(employeeId));
        }
        return Optional.empty();
    }
}