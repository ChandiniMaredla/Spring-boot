package com.crud.crud.databaseconnection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
@Service
public class Crudservice {
@Autowired
 JdbcTemplate jdbct;
 public int insertproduct(Crudobj obj){
    int id= obj.getId();
    String name=obj.getName();
    String type=obj.getType();
    double price=obj.getPrice();
    String sql="insert into Product values(?,?,?,?)";
    int i=jdbct.update(sql,id,name,type,price);
    return i;
 }
}
