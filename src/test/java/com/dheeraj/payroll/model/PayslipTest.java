package com.dheeraj.payroll.model;

import com.dheeraj.payroll.enums.Department;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.YearMonth;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PayslipTest {

    @Test
    void shouldCreatePayslipCorrectly(){
        Payslip payslip = new Payslip(1,
                "Dheeraj",
                YearMonth.of(2026,8),
                new BigDecimal("5000"),
                new BigDecimal("10"),
                new BigDecimal("20"),
                new BigDecimal("50000"),
                Department.DEVELOPMENT);
        assertEquals(1,payslip.getEmployeeId());
        assertEquals("Dheeraj",payslip.getEmployeeName());
        assertEquals(YearMonth.of(2026,8),payslip.getPayPeriod());
        assertEquals(new BigDecimal("5000"),payslip.getBasicSalary());
        assertEquals(new BigDecimal("10"),payslip.getBonus());
        assertEquals(new BigDecimal("20"),payslip.getTax());
        assertEquals(new BigDecimal("50000"),payslip.getNetSalary());
        assertEquals(Department.DEVELOPMENT,payslip.getDepartment());
    }
}
