package com.dheeraj.payroll.services;

import com.dheeraj.payroll.enums.Department;
import com.dheeraj.payroll.enums.EmployeeType;
import com.dheeraj.payroll.model.Employee;
import com.dheeraj.payroll.model.Payslip;
import com.dheeraj.payroll.repository.EmployeeRepository;
import com.dheeraj.payroll.repository.PayslipRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PayslipServiceTest {

    private EmployeeService employeeService;
    private PayslipRepository payslipRepository;
    private PayslipService payslipService;

    @BeforeEach
    void setUp() {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        employeeService = new EmployeeService(employeeRepository);
        payslipRepository = new PayslipRepository();
        payslipService = new PayslipService(employeeService, payslipRepository);
    }

    @Test
    void shouldCalculateTaxCorrectlyForLowestBracket() {
        BigDecimal taxRate = payslipService.tax(new BigDecimal("350000"));
        assertEquals(0, BigDecimal.ZERO.compareTo(taxRate));
    }

    @Test
    void shouldCalculateSalaryCorrectly() {
        Employee employee = new Employee(1, "Dheeraj", Department.DEVELOPMENT, EmployeeType.FULL_TIME, new BigDecimal("500000"));
        employeeService.addEmployee(1L, employee);

        BigDecimal finalSalary = payslipService.calculateSalary(1L, new BigDecimal("10"));

        assertNotNull(finalSalary);
        assertEquals(-1, new BigDecimal("525000.00").compareTo(finalSalary));
    }

    @Test
    void shouldGeneratePayslipSuccessfully() {
        Employee employee = new Employee(1, "Dheeraj", Department.DEVELOPMENT, EmployeeType.FULL_TIME, new BigDecimal("500000"));
        employeeService.addEmployee(1L, employee);

        YearMonth payPeriod = YearMonth.of(2026, 8);
        BigDecimal bonus = new BigDecimal("10");

        payslipService.generatePayslip(1L, payPeriod, bonus);

        assertTrue(payslipRepository.present(1L));
        Payslip savedPayslip = payslipRepository.get(1L);
        assertEquals("Dheeraj", savedPayslip.getEmployeeName());
        assertEquals(payPeriod, savedPayslip.getPayPeriod());
    }

    @Test
    void shouldViewPayslipWhenPresent() {
        Employee employee = new Employee(1, "Dheeraj", Department.DEVELOPMENT, EmployeeType.FULL_TIME, new BigDecimal("500000"));
        employeeService.addEmployee(1L, employee);
        payslipService.generatePayslip(1L, YearMonth.of(2026, 8), new BigDecimal("10"));

        Optional<Payslip> result = payslipService.viewPayslip(1L);

        assertTrue(result.isPresent());
        assertEquals("Dheeraj", result.get().getEmployeeName());
    }

    @Test
    void shouldReturnEmptyWhenPayslipNotPresent() {
        Optional<Payslip> result = payslipService.viewPayslip(999L);

        assertFalse(result.isPresent());
    }
}