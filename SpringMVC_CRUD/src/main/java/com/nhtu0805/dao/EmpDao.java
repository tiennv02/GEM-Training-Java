package com.nhtu0805.dao;

import com.nhtu0805.bean.Emp;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmpDao {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Emp emp){
        String sql = "INSERT INTO Emp(name,salary,designation) " +
                "VALUES ('"+emp.getName()+"',"+emp.getSalary()+",'"+emp.getDesignation()+"')";
        return template.update(sql);
    }

    public int update(Emp emp){
        String sql = "UPDATE emp SET name='"+emp.getName()+"',salary="+emp.getSalary()+", designation='"+emp.getDesignation()+"' WHERE id = "+emp.getId()+"";
        return template.update(sql);
    }

    public int delete(int id){
        String sql = "DELETE FROM emp WHERE id = "+id+"";
        return template.update(sql);
    }

    public Emp getEmpById(int id){
        String sql = "SELECT * FROM emp WHERE id= ?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Emp>(Emp.class));
    }

//    public List<Emp> getEmp() {
//        return template.query("select * from emp", new RowMapper<Emp>() {
//            public Emp mapRow(ResultSet rs, int row) throws SQLException {
//                Emp e = new Emp();
//                e.setId(rs.getInt(1));
//                e.setName(rs.getString(2));
//                e.setSalary(rs.getFloat(3));
//                e.setDesignation(rs.getString(4));
//                return e;
//            }
//        });
//    }

    public List<Emp> getEmployeesByPage(int pageid, int total){
        String sql="select * from emp ORDER BY id limit "+total+" offset "+(pageid-1)+"";
        return template.query(sql,new RowMapper<Emp>(){
            public Emp mapRow(ResultSet rs, int row) throws SQLException {
                Emp e=new Emp();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setSalary(rs.getFloat(3));
                e.setDesignation(rs.getString(4));
                return e;
            }
        });
    }
}
