package com.dheeraj.payroll.repository;

import com.dheeraj.payroll.enums.Department;
import com.dheeraj.payroll.enums.EmployeeType;
import com.dheeraj.payroll.model.Employee;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmployeeRepositoryTest {

    @Test
    void testingAddEmployee(){
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Employee employee = new Employee(1,"Dheeraj", Department.DEVELOPMENT, EmployeeType.FULL_TIME,new BigDecimal("50000"));
        employeeRepository.addEmployee(1,employee);
        Employee employee1 = employeeRepository.findById(1);
        assertNotNull(employee1,"The added employee should not be null");
        assertEquals("Dheeraj",employee1.getEmployeeName());
    }
    
}
