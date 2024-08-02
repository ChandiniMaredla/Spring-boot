package com.example.employee.Employee;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class Serviceclass {
    @Autowired
JdbcTemplate jdbct;


public int insert(employee e)
{
    int adminid=e.getAdminid();
    String adminworkmail=e.getAdminworkmail();
    String adminpasswd=e.getAdminpasswd();
    String adminrole=e.getAdminrole();
    int id=e.getId();
    String fname=e.getFname().toLowerCase().trim();
    String lname=e.getLname().toLowerCase().trim();
    String gmail=e.getGmail();
    // String s="select count(*) from Employee where fname= '"+fname+"' and lname= '"+lname+"'";
    //int j=;
    String workmail="";
//     if(j!=0)
//     {
// workmail=fname.charAt(0)+lname+"@miraclesoft.com"+String.valueOf(j);
//     }
    // else
    // {
        workmail=fname.charAt(0)+lname+"@miraclesoft.com";
    // }
    int salary=e.getSalary();
    int pincode=e.getPincode();
    String worklocation=e.getWorklocation();
    String department=e.getDepartment();
    LocalDate joiningdate=java.time.LocalDate.now();
    LocalTime currentime=java.time.LocalTime.now();
    String time=String.valueOf(currentime).substring(0,5);
    int hrs=Integer.parseInt(time.substring(0,2));
    int newtime=0;
    if(hrs>12)
    {
        newtime=hrs-12;
    }
    String presenttime=String.valueOf(newtime)+time.substring(2);


    String pwd = ""+Character.toUpperCase(fname.charAt(fname.length()-2))+ fname.charAt(fname.length()-1)+
    lname.charAt(lname.length()-2)+lname.charAt(lname.length()-1)+"@"+presenttime;
String phno=e.getPhno();
String role=e.getRole();
int asgnby=e.getAsgnby();

if(adminid==1 && "hvardhan@miraclesoft.com".equals(adminworkmail) && 
"Haan@10:29".equals(adminpasswd)&& "admin".equals(adminrole)){
String sql="insert into Employee values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
int i=jdbct.update(sql,id,fname,lname,department,gmail,workmail,
phno,pwd,salary,joiningdate,worklocation,pincode,role,asgnby);

    return i;
}

    else{
        return -999;
    }
}

public List<employee> selectrecords(employee e)
{
    String s="select * from Employee where 1=1";
    if(e.getFname()!=null)
    {
        s=s+" and fname= '"+e.getFname()+"'";

    }
    if(e.getLname()!=null)
    {
        s=s+" and lname='"+e.getLname()+"'";
    }
    if(e.getId()!=0 && e.getFname()!=null)
    {
        s=s+" and id= "+e.getId()+" and fname='"+e.getFname()+"'";
    }
System.out.println(s);


    return jdbct.query(s,new BeanPropertyRowMapper<>(employee.class));
} 
}