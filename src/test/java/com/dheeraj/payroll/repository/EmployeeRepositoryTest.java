package com.dheeraj.payroll.repository;

import com.dheeraj.payroll.enums.Department;
import com.dheeraj.payroll.enums.EmployeeType;
import com.dheeraj.payroll.model.Employee;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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
    @Test
    void shouldReturnNullWhenEmployeeDoesNotExist(){
        EmployeeRepository employeeRepository = new EmployeeRepository();
        assertNull(employeeRepository.findById(123));
    }
    @Test
    void shouldDeleteEmployee(){
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Employee employee = new Employee(1,"Dheeraj", Department.DEVELOPMENT, EmployeeType.FULL_TIME,new BigDecimal("50000"));
        employeeRepository.addEmployee(1,employee);
        employeeRepository.deleteEmployee(1);
        assertNull(employeeRepository.findById(1));
    }
    @Test
    void shouldReturnTrueWhenEmployeeExists(){
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Employee employee = new Employee(1,"Dheeraj", Department.DEVELOPMENT, EmployeeType.FULL_TIME,new BigDecimal("50000"));
        employeeRepository.addEmployee(1,employee);
        assertTrue(employeeRepository.contains(1));
    }
    @Test
    void shouldReturnAllEmployees(){
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Employee employee = new Employee(1,"Dheeraj", Department.DEVELOPMENT, EmployeeType.FULL_TIME,new BigDecimal("50000"));
        Employee employee1 = new Employee(2,"Gowda", Department.DEVELOPMENT, EmployeeType.FULL_TIME,new BigDecimal("500000"));
        employeeRepository.addEmployee(1,employee);
        employeeRepository.addEmployee(2,employee1);
        Collection<Employee> list = employeeRepository.getAllEmployee();
        assertEquals(2,list.size());
    }
    @Test
    void shouldFindEmployeesByDepartment(){
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Employee employee = new Employee(1,"Dheeraj", Department.DEVELOPMENT, EmployeeType.FULL_TIME,new BigDecimal("50000"));
        Employee employee1 = new Employee(2,"Gowda", Department.DEVELOPMENT, EmployeeType.FULL_TIME,new BigDecimal("500000"));
        employeeRepository.addEmployee(1,employee);
        employeeRepository.addEmployee(2,employee1);
        List<Employee> list = employeeRepository.getEmployeeByDepartment(Department.DEVELOPMENT);
        assertEquals(2,list.size());
    }
    @Test
    void shouldFindEmployeeBySalary(){
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Employee employee = new Employee(1,"Dheeraj", Department.DEVELOPMENT, EmployeeType.FULL_TIME,new BigDecimal("50000"));
        Employee employee1 = new Employee(2,"Gowda", Department.DEVELOPMENT, EmployeeType.FULL_TIME,new BigDecimal("500000"));
        Employee employee2 = new Employee(3,"Dheeraj Gowda ", Department.DEVELOPMENT, EmployeeType.FULL_TIME,new BigDecimal("50000"));
        employeeRepository.addEmployee(1,employee);
        employeeRepository.addEmployee(2,employee1);
        employeeRepository.addEmployee(3,employee2);
        List<Employee> list = employeeRepository.getEmployeeBySalary(new BigDecimal("50000"));
        assertEquals(2,list.size());
    }
    @Test
    void shouldGetHighestPaidEmployee(){
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Employee employee = new Employee(1,"Dheeraj", Department.DEVELOPMENT, EmployeeType.FULL_TIME,new BigDecimal("50000"));
        Employee employee1 = new Employee(2,"Gowda", Department.DEVELOPMENT, EmployeeType.FULL_TIME,new BigDecimal("500000"));
        employeeRepository.addEmployee(1,employee);
        employeeRepository.addEmployee(2,employee1);
        Optional<Employee> employee2 = employeeRepository.highestPaidEmployee();
        assertTrue(employee2.isPresent());
        assertEquals("Gowda",employee2.get().getEmployeeName());
    }

}
