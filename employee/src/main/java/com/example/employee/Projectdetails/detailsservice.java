package com.example.employee.Projectdetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class detailsservice {
    @Autowired
JdbcTemplate jdbct;
public List<Map<String,Object>> selectdetails(String pid) throws UserException
 {
   
String q1="select * from Project where pid=?";
List<Map<String,Object>> ans=jdbct.queryForList(q1,pid);
if(ans.size()==0)
{System.out.println("no project");
throw new UserException("no project in the project table with this id");
 }

String q2="select * from EmployeeProjectDetails where pid=?";
List<Map<String,Object>> ids= jdbct.queryForList(q2,pid);
List<Object> list=new ArrayList<>();
for(Map<String,Object> m: ids)
{
    for(Map.Entry<String,Object> entry: m.entrySet())
    {
       // System.out.println(entry.getValue());
        list.add(entry.getValue());
    }
}
if(list.size()==0){
System.out.println("no project is assigned to emp");
throw new UserException("no project is assigned to emp");
}
//System.out.println(ans.get(0));
   ans.get(0).put("Employee",list);
   //System.out.println(list);
return ans;
}

}

class UserException extends Exception
{

public UserException(String s)
{
super(s);
}
}