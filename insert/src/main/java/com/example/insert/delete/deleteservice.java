package com.example.insert.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class deleteservice {
@Autowired
JdbcTemplate jdbct;
public int deleterecord(int id)
{
    String sql="delete from Student where id=?";
    int i=jdbct.update(sql,id);
    return i;
}
}
