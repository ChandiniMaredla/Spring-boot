package com.example.employee.Employee;

import java.sql.Date;

public class employee {
    int id;
    String fname;
    String lname;
    String department;
    String gmail;
     String workmail;
     String  phno;
    String password;
    int salary ;
    Date joiningdate ;
    String worklocation;
   
    int pincode;  

     int adminid;
     String adminworkmail;
     String adminpasswd;
     String adminrole;
    
    String role;
     int asgnby;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getGmail() {
        return gmail;
    }
    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
    public String getWorkmail() {
        return workmail;
    }
    public void setWorkmail(String workmail) {
        this.workmail = workmail;
    }
    public String getPhno() {
        return phno;
    }
    public void setPhno(String phno) {
        this.phno = phno;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public Date getJoiningdate() {
        return joiningdate;
    }
    public void setJoiningdate(Date joiningdate) {
        this.joiningdate = joiningdate;
    }
    public String getWorklocation() {
        return worklocation;
    }
    public void setWorklocation(String worklocation) {
        this.worklocation = worklocation;
    }
    public int getPincode() {
        return pincode;
    }
    public void setPincode(int pincode) {
        this.pincode = pincode;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public int getAsgnby() {
        return asgnby;
    }
    public void setAsgnby(int asgnby) {
        this.asgnby = asgnby;
    }
    public int getAdminid() {
        return adminid;
    }
    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }
    public String getAdminworkmail() {
        return adminworkmail;
    }
    public void setAdminworkmail(String adminworkmail) {
        this.adminworkmail = adminworkmail;
    }
    public String getAdminpasswd() {
        return adminpasswd;
    }
    public void setAdminpasswd(String adminpasswd) {
        this.adminpasswd = adminpasswd;
    }
    public String getAdminrole() {
        return adminrole;
    }
    public void setAdminrole(String adminrole) {
        this.adminrole = adminrole;
    }
}
