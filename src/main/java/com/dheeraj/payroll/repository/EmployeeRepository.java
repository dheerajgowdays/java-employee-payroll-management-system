    package com.dheeraj.payroll.repository;

    import com.dheeraj.payroll.enums.Department;
    import com.dheeraj.payroll.enums.EmployeeType;
    import com.dheeraj.payroll.model.Employee;

    import java.math.BigDecimal;
    import java.util.Collection;
    import java.util.LinkedHashMap;

    public class EmployeeRepository {
        private final LinkedHashMap<Long, Employee> employees = new LinkedHashMap<>();
        public void addEmployee(long id,Employee employee){
            employees.put(id,employee);
        }
        public boolean contains(long id){
            return employees.containsKey(id);
        }
        public Employee findById(long id){
            if(contains(id)){
                return employees.get(id);
            }
            return null;
        }
        public void deleteEmployee(long id){
            employees.remove(id);
        }
        public void updateEmployeeName(String name,Employee employee){
            employee.setEmployeeName(name);
        }
        public void updateEmployeeDepartment(Department department,Employee employee){
            employee.setDepartment(department);
        }
        public void updateEmployeeType(EmployeeType employeeType , Employee employee){
            employee.setEmployeeType(employeeType);
        }
        public void updateSalary(BigDecimal salary,Employee employee){
            employee.setSalary(salary);
        }
        public Collection<Employee> getAllEmployee(){
            return employees.values().stream().toList();
        }
    }
