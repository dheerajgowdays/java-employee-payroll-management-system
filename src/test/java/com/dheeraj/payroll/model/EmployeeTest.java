package com.dheeraj.payroll.model;

import com.dheeraj.payroll.enums.Department;
import com.dheeraj.payroll.enums.EmployeeType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeTest {

    @Test
    void shouldCreateEmployeeCorrectly(){
        Employee employee = new Employee(1,"Dheeraj", Department.DEVELOPMENT, EmployeeType.FULL_TIME,new BigDecimal("50000"));
        assertEquals(1,employee.getEmployeeId());
        assertEquals("Dheeraj",employee.getEmployeeName());
        assertEquals(Department.DEVELOPMENT,employee.getDepartment());
        assertEquals(EmployeeType.FULL_TIME,employee.getEmployeeType());
        assertEquals(new BigDecimal("50000"),employee.getSalary());
    }

    @Test
    void updateEmployeeName(){
        Employee employee = new Employee(1,"Dheeraj", Department.DEVELOPMENT, EmployeeType.FULL_TIME,new BigDecimal("50000"));
        employee.setEmployeeName("Gowda");
        assertEquals("Gowda",employee.getEmployeeName());
    }

    @Test
    void updateEmployeeDepartment(){
        Employee employee = new Employee(1,"Dheeraj", Department.DEVELOPMENT, EmployeeType.FULL_TIME,new BigDecimal("50000"));
        employee.setDepartment(Department.HR);
        assertEquals(Department.HR,employee.getDepartment());
    }
    @Test
    void updateEmployeeEmployeeType(){
        Employee employee = new Employee(1,"Dheeraj",Department.DEVELOPMENT,EmployeeType.FULL_TIME,new BigDecimal("50000"));
        employee.setEmployeeType(EmployeeType.INTERN);
        assertEquals(EmployeeType.INTERN,employee.getEmployeeType());
    }
    @Test
    void updateEmployeeSalary(){
        Employee employee = new Employee(1,"Dheeraj",Department.DEVELOPMENT,EmployeeType.FULL_TIME,new BigDecimal("50000"));
        employee.setSalary(new BigDecimal("10000"));
        assertEquals(new BigDecimal("10000"),employee.getSalary());
    }
    @Test
    void rejectNegativeSalary(){
        assertThrows(IllegalArgumentException.class,()-> {
            new Employee(1, "Dheeraj",
                    Department.DEVELOPMENT,
                    EmployeeType.FULL_TIME,
                    new BigDecimal("-500000"));
        });
    }
}
