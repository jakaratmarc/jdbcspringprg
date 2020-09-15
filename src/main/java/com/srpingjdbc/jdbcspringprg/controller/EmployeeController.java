package com.srpingjdbc.jdbcspringprg.controller;

import com.srpingjdbc.jdbcspringprg.doa.EmployeeDao;
import com.srpingjdbc.jdbcspringprg.model.Employee;
import com.srpingjdbc.jdbcspringprg.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping(value="/getallemp")
    public List<Employee> getAllEmployees() {
        return employeeDao.getEmployeeList();
    }

    @PostMapping(value="/insertemp")
        public String insertEmployeeList(@RequestBody Employee employee) {
        return employeeDao.insertEmployeeList(employee);
    }

    @GetMapping (value="/getemp/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeDao.getEmployeeById(id);
    }

    @DeleteMapping(value="/deleteemp/{id}")
    public String deleteEmployeeById(@PathVariable Integer id) {
        return employeeDao.deleteEmployeeById(id);
    }


  /*  @PutMapping(value="/updateemp/{id}/{city}")
    public String updateEmployeeByID(@PathVariable String city, @PathVariable Integer id) {
        return employeeDao.updateEmployeeById(city, id);
    } */

    @PutMapping(value="/updateemp")
    public String updateEmployee(@RequestBody Employee employee) {
        return employeeDao.updateEmployee(employee);
    }

    @PostMapping(value="/save")
    public String addEmployee(@RequestBody Employee employee){
        return employeeDao.insertEmployeeList(employee);
    }

    @GetMapping(value="/getjoindata")
    public List<Map<String, Object>> getData(){
        return employeeDao.getCombinedData();
    }

    @PostMapping(value ="/insertdeptandemp")
    public String insertIntoMultiTables(@RequestBody Employee employee) {
        return employeeDao.insertIntoMultiTables(employee);
    }
}
