package com.srpingjdbc.jdbcspringprg.repository;

import com.srpingjdbc.jdbcspringprg.model.Department;

public interface DepartmentRepository {

    String addDept(Department department);

    Department getDepartmentId(Integer id);

    //Department getDepartmentName(String deptname);

}
