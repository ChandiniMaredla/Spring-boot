package com.example.employee.TaskList;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class taskservice {
@Autowired
JdbcTemplate jdbct;
public int inserttask(task t)
{
int id=t.getId();
String taskname=t.getTaskname();
int createdby=t.getCreatedby();
int assignedto=t.getAssignedto();
LocalDate taskasgndate=LocalDate.now();
int duration=t.getDuration();
LocalDate startdate=t.getStartdate().toLocalDate();

//calculating end date
int q=duration/8;
LocalDate enddate= startdate.plusDays(q);

String taskstatus=t.getTaskstatus();
String desc=t.getDesc();

// cheeck if createdby is in emp table or not
String q1="select count(*) from Employee where id=?";
int c1=jdbct.queryForObject(q1,Integer.class,createdby);
System.out.println(c1);
if(c1==0)
{
return -999;//no emp
}
String q2="select count(*) from EmployeeProjectDetails where EmpID=?";
int c2=jdbct.queryForObject(q2,Integer.class,assignedto);
if(c2==0)
return -998;//no emp in projectdetails
String q3= "select teamlead from EmployeeProjectDetails where EmpID=?";
String tl=jdbct.queryForObject(q3,String.class,assignedto);
String q4="select id from Employee where workmail=?";
int tlid=jdbct.queryForObject(q4,Integer.class,tl);
if(tlid==createdby)
{
    String q5="select EmpID from EmployeeProjectDetails where teamlead=?";
    List<Map<String, Object>> eidList = jdbct.queryForList(q5, tl);

    List<Integer> employeeIds = new ArrayList<>();

    for (Map<String, Object> map : eidList) {
            employeeIds.add((Integer)(map.get("EmpID")));
    }
    if(employeeIds.contains(assignedto))
    {
        String sql="insert into tasklist values(?,?,?,?,?,?,?,?,?,?)";
int i=jdbct.update(sql,id,taskname,createdby,assignedto,
taskasgndate,duration,startdate,enddate,taskstatus,desc);
return i;
    }
    else
    return 0;
}

        

return -997;// incorrect lead of emp

}
}
