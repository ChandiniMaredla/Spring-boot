package com.example.insert.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class updateservice {
@Autowired
JdbcTemplate jdbct;
public int updateStudent(update u)
{
int id=u.getId();
String name=u.getName();
String sql="update Student set name=? where id=?";
int i=jdbct.update(sql,name,id);
        return i;
}
}
