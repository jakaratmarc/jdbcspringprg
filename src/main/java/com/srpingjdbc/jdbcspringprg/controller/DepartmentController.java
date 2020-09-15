package com.srpingjdbc.jdbcspringprg.controller;

import com.srpingjdbc.jdbcspringprg.doa.DepartmentDao;
import com.srpingjdbc.jdbcspringprg.model.Department;
import com.srpingjdbc.jdbcspringprg.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentDao departmentDao;

    @PostMapping(value="/savedept")
    public String addDepartment(@RequestBody Department department){
        return departmentDao.addDept(department);

    }

    @GetMapping(value="/getdept/{id}")
    public Department getDepartment(@PathVariable Integer id) {
        return departmentDao.getDepartmentId(id);
    }

   /* @GetMapping(value="/getdeptname/{deptname}")
    public Department getDepartment(@PathVariable String deptname){
        return  departmentDao.getDepartmentName(deptname);
    } */

}
