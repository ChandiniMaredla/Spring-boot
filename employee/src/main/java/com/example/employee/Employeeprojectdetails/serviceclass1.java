package com.example.employee.Employeeprojectdetails;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class serviceclass1 {
@Autowired
JdbcTemplate jdbct;
public int insert(empprodetails e)
{
int id=e.getId();
int c2=0;
String q1;
String role;
String q4="select count(*) from Employee where id=?";
c2=jdbct.queryForObject(q4,Integer.class,id);
System.out.println(c2);
if(c2>0)
{
q1="select Role from Employee where id=?";
role=jdbct.queryForObject(q1,String.class,id);
}             
else
return -996;


String pid,adgnby;
if(role.equals("HR"))
{
    String a="select workmail from Employee where Role=? and id=?";
    String workmail=jdbct.queryForObject(a,String.class,role,id);
String q2="select pid from Project where HR=?";
String s=workmail.substring(0,20);
String d1="select count(*) from Project where HR=?";
int d2=jdbct.queryForObject(d1,Integer.class,s);
if(d2==0)
return -992;

pid=jdbct.queryForObject(q2,String.class,s);
adgnby=role;
}
else if(role.equals("PM"))
{ String a="select workmail from Employee where Role=? and id=?";
String workmail=jdbct.queryForObject(a,String.class,role,id);
    String q2="select pid from Project where PM=?";
    String s=workmail.substring(0,20);
    String d1="select count(*) from Project where PM=?";
int d2=jdbct.queryForObject(d1,Integer.class,s);
if(d2==0)
return -992;
pid=jdbct.queryForObject(q2,String.class,s);
adgnby=role;
}
else{
    return -998;
}
int EmpId=e.getEmpId();
System.out.println(EmpId);
int c1=0;
String q3="select count(*) from Employee where id=?";
c1=jdbct.queryForObject(q3,Integer.class,EmpId);
System.out.println(c1);
if(c1==0)
{
return -997;
}
String teamlead=e.getTeamlead();
LocalDate asgndate=LocalDate.now();
if(role.equals("PM") || role.equals("HR"))
{
    String sql="insert into EmployeeProjectDetails values(?,?,?,?,?)";
    int i=jdbct.update(sql,EmpId,pid,asgndate,teamlead,adgnby);
    return i;
}

    return -999;
}
}


