package com.example.insert.insert;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    JdbcTemplate jdbc;

    public int addStudent(insert p)
    {
        int id=p.getId();
        String name=p.getName();
        String sql="insert into Student values(?,?)";
        int i=jdbc.update(sql,id,name);
        return i;


        
    }

}