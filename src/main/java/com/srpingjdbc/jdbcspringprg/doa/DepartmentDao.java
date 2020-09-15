package com.srpingjdbc.jdbcspringprg.doa;

import com.srpingjdbc.jdbcspringprg.model.Department;
import com.srpingjdbc.jdbcspringprg.model.Employee;
import com.srpingjdbc.jdbcspringprg.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public class DepartmentDao implements DepartmentRepository  {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String addDept(Department department) {
        String sql="insert into department values(?,?)";
        jdbcTemplate.update(sql, new Object[]{department.getId(),department.getName()});
        return "Department added successfully";
    }

    @Override
    public Department getDepartmentId(Integer id) {
        String sql="select id,name from department where id=?";
        Department dept = (Department) jdbcTemplate.queryForObject(sql, new Object[]{id},
                new BeanPropertyRowMapper(Department.class));
        return dept;

    }

  /*  @Override
    public Department getDepartmentName(String deptname) {
        String sql="select id,name from department where name=?";
        Department dept_name = (Department) jdbcTemplate.queryForObject(sql, new Object[]{deptname},
                new BeanPropertyRowMapper(Department.class));
        return dept_name;
        //found the dept
        if(dept_name.equals(deptname)){
            //save the return ID from dept table
            //call the insert insert into the employee table using method from EmployeeDao and pass the value
            insertEmployeeList();
        }

        else{
            //not found in the department
            //insert the department into the department table
            //get the ID of the new dept
            //insert into employee using that id^
        }

    } */
}
