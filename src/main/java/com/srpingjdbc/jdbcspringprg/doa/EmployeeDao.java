package com.srpingjdbc.jdbcspringprg.doa;

import com.srpingjdbc.jdbcspringprg.model.Employee;
import com.srpingjdbc.jdbcspringprg.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Executable;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDao implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Employee> getEmployeeList() {
        String sql ="select * from employee";
        List<Employee> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
        return list;
    }

    public String insertEmployeeList(Employee employee) {
        String sql ="insert into employee values(?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{employee.getId(),employee.getName(),employee.getCity(),
                                                employee.getDepartment().getId()});
        return "New employee added";
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        String sql ="select * from employee where id=?";
        Employee emp = (Employee) jdbcTemplate.queryForObject(sql, new Object[]{id},
                new BeanPropertyRowMapper(Employee.class));
        return emp;
    }

    @Override
    public String deleteEmployeeById(Integer id) {
        String sql ="delete from employee where id=?";
        jdbcTemplate.update(sql, new Object[]{id});
        return "employee deleted";
    }

    @Override
    public String updateEmployee(Employee employee) {
        String sql = "update employee set name=?, city=? where id=? ";
        jdbcTemplate.update(sql, new Object[]{employee.getName(),employee.getCity(), employee.getId()});
        return "Employee updated";
    }

    @Override
    public List<Map<String, Object>> getCombinedData() {
        String sql ="select a.id, a.name, a.city, b.name as deptName from employee a, department b where a.dept_id=b.id";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }

    @Override
    public String insertIntoMultiTables(Employee employee) {

        if (employee.getDepartment().getId() != null) {
            String sql = "insert into employee values(?,?,?,?)";
            jdbcTemplate.update(sql, new Object[]{employee.getId(), employee.getName(),
                    employee.getCity(), employee.getDepartment().getId()});
            return "employee added successfully";

        }
            String sql = "select * from department where name=?";

               RowCountCallbackHandler countCallbackHandler = new RowCountCallbackHandler();

               jdbcTemplate.query(sql, new Object[]{employee.getDepartment().getName()}, countCallbackHandler);
               Integer rowCount = countCallbackHandler.getRowCount();
               System.out.println(rowCount);
               if(rowCount == 0) {
                   String insertSql = "insert into department(name) values(?)";
                   jdbcTemplate.update(insertSql, new Object[]{employee.getDepartment().getName()});

               }
               else{
                   String sql1 = "insert into employee values(?,?,?,?)";
                   jdbcTemplate.update(sql, new Object[]{employee.getId(), employee.getName(),
                                        employee.getCity(), employee.getDepartment().getId()});
               }

             return "department & employee saved successfully";
    }


}
