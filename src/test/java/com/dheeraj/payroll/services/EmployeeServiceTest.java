package com.dheeraj.payroll.services;

import com.dheeraj.payroll.enums.Department;
import com.dheeraj.payroll.enums.EmployeeType;
import com.dheeraj.payroll.model.Employee;
import com.dheeraj.payroll.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    @Test
    void shouldAddEmployee(){
        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        Employee employee = new Employee(1,"Dheeraj", Department.DEVELOPMENT, EmployeeType.FULL_TIME,new BigDecimal("50000"));
        assertTrue(employeeService.addEmployee(1,employee));
    }
    @Test
    void shouldFindEmployeeById(){
        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        Employee employee = new Employee(1,"Dheeraj", Department.DEVELOPMENT, EmployeeType.FULL_TIME,new BigDecimal("50000"));
        employeeService.addEmployee(1,employee);
        Optional<Employee> employee1 = employeeService.searchByEmployeeId(1);
        assertTrue(employee1.isPresent());
        assertEquals(employee,employee1.get());
    }
    @Test
    void shouldReturnEmptyWhenEmployeeDoesNotExist(){
        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        Optional<Employee> employee1 = employeeService.searchByEmployeeId(1);
        assertFalse(employee1.isPresent());
    }
    @Test
    void shouldGetAllEmployee(){
        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        Employee employee0 = new Employee(1,"Dheeraj", Department.DEVELOPMENT, EmployeeType.FULL_TIME,new BigDecimal("50000"));
        Employee employee1 = new Employee(2,"Dheeraj Gowda ", Department.DEVELOPMENT, EmployeeType.PART_TIME,new BigDecimal("500000"));
        employeeService.addEmployee(1,employee0);
        employeeService.addEmployee(2,employee1);
        List<Employee> list = employeeService.getAllEmployee();
        assertEquals(2,list.size());
    }
    @Test
    void shouldUpdateEmployeeName(){
        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        Employee employee0 = new Employee(1,"Dheeraj", Department.DEVELOPMENT, EmployeeType.FULL_TIME,new BigDecimal("50000"));
        employeeService.addEmployee(1,employee0);
        employeeService.updateEmployeeName(1,"Gowda");
        assertEquals("Gowda",employeeRepository.findById(1).getEmployeeName());
    }
    @Test
    void shouldUpdateDepartment(){
        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        Employee employee0 = new Employee(1,"Dheeraj", Department.DEVELOPMENT, EmployeeType.FULL_TIME,new BigDecimal("50000"));
        employeeService.addEmployee(1,employee0);
        employeeService.updateEmployeeDepartment(1,Department.HR);
        assertEquals(Department.HR,employeeRepository.findById(1).getDepartment());
    }
    @Test
    void shouldUpdateEmployeeType(){
        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        Employee employee0 = new Employee(1,"Dheeraj", Department.DEVELOPMENT, EmployeeType.FULL_TIME,new BigDecimal("50000"));
        employeeService.addEmployee(1,employee0);
        employeeService.updateEmployeeType(1,EmployeeType.INTERN);
        assertEquals(EmployeeType.INTERN,employeeRepository.findById(1).getEmployeeType());
    }
    @Test
    void shouldUpdateSalary(){
        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        Employee employee0 = new Employee(1,"Dheeraj", Department.DEVELOPMENT, EmployeeType.FULL_TIME,new BigDecimal("50000"));
        employeeService.addEmployee(1,employee0);
        employeeService.updateSalary(1,new BigDecimal("50"));
        assertEquals(new BigDecimal("50"),employeeRepository.findById(1).getSalary());
    }
    @Test
    void shouldDeleteEmployee(){
        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        Employee employee0 = new Employee(1,"Dheeraj", Department.DEVELOPMENT, EmployeeType.FULL_TIME,new BigDecimal("50000"));
        employeeService.addEmployee(1,employee0);
        employeeService.deleteEmployee(1);
        assertFalse(employeeService.checkID(1));
    }
    @Test
    void shouldGetEmployeesByDepartment(){
        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        Employee employee0 = new Employee(1,"Dheeraj", Department.DEVELOPMENT, EmployeeType.FULL_TIME,new BigDecimal("50000"));
        Employee employee1 = new Employee(2,"Dheeraj Gowda ", Department.DEVELOPMENT, EmployeeType.PART_TIME,new BigDecimal("500000"));
        employeeService.addEmployee(1,employee0);
        employeeService.addEmployee(2,employee1);
        List<Employee> list = employeeService.employeesByDepartment(Department.DEVELOPMENT);
        assertEquals(2,list.size());
    }
    @Test
    void shouldGetEmployeesBySalary(){
        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        Employee employee0 = new Employee(1,"Dheeraj", Department.DEVELOPMENT, EmployeeType.FULL_TIME,new BigDecimal("50000"));
        Employee employee1 = new Employee(2,"Dheeraj Gowda ", Department.DEVELOPMENT, EmployeeType.PART_TIME,new BigDecimal("500000"));
        employeeService.addEmployee(1,employee0);
        employeeService.addEmployee(2,employee1);
        List<Employee> list = employeeService.employeesBySalary(new BigDecimal("50000"));
        assertEquals(1,list.size());
    }
    @Test
    void shouldGetHighestPaidEmployee(){
        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        Employee employee0 = new Employee(1,"Dheeraj", Department.DEVELOPMENT, EmployeeType.FULL_TIME,new BigDecimal("50000"));
        Employee employee1 = new Employee(2,"Dheeraj Gowda ", Department.DEVELOPMENT, EmployeeType.PART_TIME,new BigDecimal("500000"));
        employeeService.addEmployee(1,employee0);
        employeeService.addEmployee(2,employee1);
        Optional<Employee> employee = employeeService.highestPaidEmployee();
        assertTrue(employee.isPresent());
        assertEquals("Dheeraj Gowda ",employee.get().getEmployeeName());
    }
    @Test
    void shouldGetAverageSalary(){
        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        Employee employee0 = new Employee(1,"Dheeraj", Department.DEVELOPMENT, EmployeeType.FULL_TIME,new BigDecimal("50000"));
        Employee employee1 = new Employee(2,"Dheeraj Gowda ", Department.DEVELOPMENT, EmployeeType.PART_TIME,new BigDecimal("500000"));
        employeeService.addEmployee(1,employee0);
        employeeService.addEmployee(2,employee1);
        BigDecimal average = employeeService.averageSalary(Department.DEVELOPMENT);
        assertEquals(new BigDecimal("275000.00"),average);
    }
}
