package com.dheeraj.payroll.services;

import com.dheeraj.payroll.enums.Department;
import com.dheeraj.payroll.enums.EmployeeType;
import com.dheeraj.payroll.model.Employee;
import com.dheeraj.payroll.repository.EmployeeRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeService {
    EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public boolean addEmployee(long id, Employee employee){
        employeeRepository.addEmployee(id,employee);
        return true;
    }
    public Optional<Employee> searchByEmployeeId(long id){
        if(employeeRepository.contains(id)){
            Employee employee = employeeRepository.findById(id);
            return Optional.ofNullable(employee);
        }
        return Optional.empty();
    }
    public List<Employee> getAllEmployee() {
        return new ArrayList<>(employeeRepository.getAllEmployee());
    }
    public boolean checkID(long id){
        return employeeRepository.contains(id);
    }
    public boolean updateEmployeeName(long id,String name){
        Employee employee = employeeRepository.findById(id);
        employeeRepository.updateEmployeeName(name,employee);
        return true;
    }
    public boolean updateEmployeeDepartment(long id, Department department){
        Employee employee = employeeRepository.findById(id);
        employeeRepository.updateEmployeeDepartment(department,employee);
        return true;
    }
    public boolean updateEmployeeType(long id, EmployeeType employeeType){
        Employee employee = employeeRepository.findById(id);
        employeeRepository.updateEmployeeType(employeeType,employee);
        return true;
    }
    public boolean updateSalary(long id, BigDecimal salary){
        Employee employee = employeeRepository.findById(id);
        employeeRepository.updateSalary(salary,employee);
        return true;
    }
    public boolean deleteEmployee(long id){
        if(!employeeRepository.contains(id)){
            return false;
        }else {
            employeeRepository.deleteEmployee(id);
            return true;
        }
    }
    public List<Employee> employeesByDepartment(Department department){
        return employeeRepository.getEmployeeByDepartment(department);
    }
    public List<Employee> employeesBySalary(BigDecimal salary){
        return  employeeRepository.getEmployeeBySalary(salary);
    }
    public Optional<Employee> highestPaidEmployee(){
        return employeeRepository.highestPaidEmployee();
    }
    public BigDecimal averageSalary(Department department){
        List<Employee> employees = employeeRepository.getEmployeeByDepartment(department);
        if(employees.isEmpty()){
            return BigDecimal.ZERO;
        }
        BigDecimal totalSalary = employees.stream()
                .map(Employee::getSalary)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
        return totalSalary.divide(BigDecimal.valueOf(employees.size()),2, RoundingMode.HALF_UP);

    }
}
