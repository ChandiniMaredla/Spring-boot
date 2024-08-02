// package com.example.employee.Project;

// import java.time.LocalDate;
// import java.time.LocalDateTime;
// import java.time.LocalTime;
// import java.time.format.DateTimeFormatter;
// import java.time.temporal.ChronoUnit;
// import java.time.temporal.Temporal;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.stereotype.Service;

// @Service
// public class projectservice {
// @Autowired
// JdbcTemplate jdbct;
// public int insert(project p)
// {

//     int id=p.getId();
//     String role="select role from Employee where id="+id+";";
    
//     String pname=p.getPname();
//     LocalTime time=LocalTime.now();
//     String t=""+time;
//     String pid= ""+pname+t.substring(0,5);
//     String client=p.getClient();
//     String asgnby=role+""+id;
//     LocalDate date=LocalDate.now();
//     String startdate= ""+date;
//     String enddate=p.getEnddate();
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//         LocalDate endDate = LocalDate.parse(enddate, formatter);

//         // Calculate the number of days between the two dates
//         int duration = (int) ChronoUnit.DAYS.between(date, endDate);
//         int hrid=p.getHrid();
//         int pmid=p.getPmid();
//         int c1 = 0, c2 = 0;
// String hr="";
// String pm="";
//         // Query to count occurrences of hrid in Employee table
//         String query1 = "SELECT COUNT(*) FROM Employee WHERE id = ?";
//         c1 = jdbct.queryForObject(query1, Integer.class, hrid);
        
//         // Query to count occurrences of pmid in Employee table
//         String query2 = "SELECT COUNT(*) FROM Employee WHERE id = ?";
//         c2 = jdbct.queryForObject(query2, Integer.class, pmid);
//         if(c1>0 && c2>0)
//         {
//             hr=""+"select workmail from Employee where id="+id+";";
//             pm=""+"select workmail from Employee where id="+id+";";
//         }
//         else
//         {
//             System.out.println("ENter the details of HR and Project manager in the employee table");
//         }
//         int no_of_emp=p.getNo_of_emp();
//         if("HR".equals(role) || "admin".equals(role)){
//         String sql="insert into Project(?,?,?,?,?,?,?,?,?,?)";
//         int i=jdbct.update(sql,pid,pname,client,asgnby,startdate,enddate,duration,hr,pm,no_of_emp);
//         return i;
//         }
//         else{
// return -999;
//         }
// }
// }


package com.example.employee.Project;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class projectservice {

    @Autowired
    private JdbcTemplate jdbct;

    public int insert(project p) {
        int id = p.getId();
        int MAX_LENGTH=20;
        String pname = p.getPname();
        String client = p.getClient();
        String enddate = p.getEnddate();
        int hrid = p.getHrid();
        int pmid = p.getPmid();
        int no_of_emp = p.getNo_of_emp();

        // Fetch role from Employee table
        String roleQuery = "SELECT Role FROM Employee WHERE id = ?";
        String role = jdbct.queryForObject(roleQuery, String.class, id);
System.out.println(role);
        // Check if HR and PM exist in Employee table
        int c1 = 0, c2 = 0;
        String hr = "", pm = "";

        String countHrQuery = "SELECT COUNT(*) FROM Employee WHERE id = ?";
        c1 = jdbct.queryForObject(countHrQuery, Integer.class, hrid);

        String countPmQuery = "SELECT COUNT(*) FROM Employee WHERE id = ?";
        c2 = jdbct.queryForObject(countPmQuery, Integer.class, pmid);
        System.out.println(c1);
        System.out.println(c2);
        if (c1 > 0 && c2 > 0) {


            String hrQuery = "SELECT workmail FROM Employee WHERE id = ?";
            hr = jdbct.queryForObject(hrQuery, String.class, hrid);

            String pmQuery = "SELECT workmail FROM Employee WHERE id = ?";
            pm = jdbct.queryForObject(pmQuery, String.class, pmid);
           
            if (hr.length() > MAX_LENGTH) {
                hr = hr.substring(0, MAX_LENGTH);
            }
            if (pm.length() > MAX_LENGTH) {
                pm = pm.substring(0, MAX_LENGTH);
            }
int d1=0,d2=0;
String p1="select count(*) from Project where HR=?";
d1=jdbct.queryForObject(p1, Integer.class,hr);
String p2="select count(*) from Project where PM=?";
d2=jdbct.queryForObject(p2,Integer.class,pm);
if(d1>0 || d2 >0)
{
    return -992;
}

        } else {
            System.out.println("Enter the details of HR and Project manager in the employee table");
            return -998;
        }
        String asgnby=role+""+id;
        LocalTime time=LocalTime.now();
        String s=time.toString().substring(0,5);
        String pid=pname+s;
        // Calculate duration between start date and end date
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate endDate = LocalDate.parse(enddate, formatter);
        int duration = (int) ChronoUnit.DAYS.between(date, endDate);

        // Insert into Project table if role is "HR" or "admin"
        if ("HR".equals(role) || "admin".equals(role)) {
            String startdate = formatter.format(date);
            String sql = "INSERT INTO Project values(?,?,?,?,?,?,?,?,?,?)";
            int i = jdbct.update(sql, pname ,pid, client, asgnby,
                    startdate, enddate, duration, hr, pm, no_of_emp);
            return i;
        } else {
            return -999; // Return -999 if user is not authorized (neither "HR" nor "admin")
        }
    }
}
