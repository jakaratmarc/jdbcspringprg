package com.srpingjdbc.jdbcspringprg.repository;

import com.srpingjdbc.jdbcspringprg.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeRepository {

    List<Employee> getEmployeeList();

    String insertEmployeeList(Employee employee);

    Employee getEmployeeById (Integer id);

    String deleteEmployeeById(Integer id);

   // String updateEmployeeById(String city, Integer id);

    String updateEmployee(Employee employee);

    List<Map<String, Object>> getCombinedData();

    String insertIntoMultiTables(Employee employee);
}
