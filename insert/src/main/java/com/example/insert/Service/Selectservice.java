package com.example.insert.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class Selectservice {
@Autowired
    JdbcTemplate jdbc;
public int selectall()
{
    String sql="select * from Student";
    int i=jdbc.update(sql);
    return i;
}
}
