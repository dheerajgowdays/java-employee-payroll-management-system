package com.dheeraj.payroll.repository;

import com.dheeraj.payroll.enums.Department;
import com.dheeraj.payroll.model.Payslip;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.YearMonth;

import static org.junit.jupiter.api.Assertions.*;

public class PayslipRepositoryTest {
    @Test
    void shouldAddPayslip(){
        PayslipRepository payslipRepository = new PayslipRepository();
        Payslip payslip = new Payslip(1,
                "Dheeraj",
                YearMonth.of(2026,8),
                new BigDecimal("5000"),
                new BigDecimal("10"),
                new BigDecimal("20"),
                new BigDecimal("50000"),
                Department.DEVELOPMENT);
        payslipRepository.add(1,payslip);
        assertTrue(payslipRepository.present(1));
        assertFalse(payslipRepository.present(2));
    }
    @Test
    void shouldGetPayslip(){
        PayslipRepository payslipRepository = new PayslipRepository();
        Payslip payslip = new Payslip(1,
                "Dheeraj",
                YearMonth.of(2026,8),
                new BigDecimal("5000"),
                new BigDecimal("10"),
                new BigDecimal("20"),
                new BigDecimal("50000"),
                Department.DEVELOPMENT);
        payslipRepository.add(1,payslip);
        Payslip payslip1 = payslipRepository.get(1);
        assertEquals("Dheeraj",payslip1.getEmployeeName());
    }
}
