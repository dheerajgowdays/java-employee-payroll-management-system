    package com.dheeraj.payroll.repository;

    import com.dheeraj.payroll.model.Employee;

    import java.util.Collection;
    import java.util.LinkedHashMap;

    public class EmployeeRepository {
        LinkedHashMap<Long, Employee> employees = new LinkedHashMap<>();
        public void addEmployee(long id,Employee employee){
            employees.put(id,employee);
        }
        public boolean contains(long id){
            return employees.containsKey(id);
        }
        public Employee ifIdExist(long id){
            if(contains(id)){
                return employees.get(id);
            }
            return null;
        }
        public void deleteEmployee(long id){
            employees.remove(id);
        }
        public Collection<Employee> getAllEmployee(){
            return employees.values().stream().toList();
        }
    }
