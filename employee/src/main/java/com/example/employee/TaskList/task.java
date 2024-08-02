package com.example.employee.TaskList;

import java.sql.Date;

public class task {
int id;
String taskname;
int createdby;
int assignedto;
Date taskasgndate;
int duration;
Date startdate;
String taskstatus;
String desc;
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getTaskname() {
    return taskname;
}
public void setTaskname(String taskname) {
    this.taskname = taskname;
}
public int getCreatedby() {
    return createdby;
}
public void setCreatedby(int createdby) {
    this.createdby = createdby;
}
public int getAssignedto() {
    return assignedto;
}
public void setAssignedto(int assignedto) {
    this.assignedto = assignedto;
}
public Date getTaskasgndate() {
    return taskasgndate;
}
public void setTaskasgndate(Date taskasgndate) {
    this.taskasgndate = taskasgndate;
}
public int getDuration() {
    return duration;
}
public void setDuration(int duration) {
    this.duration = duration;
}
public Date getStartdate() {
    return startdate;
}
public void setStartdate(Date startdate) {
    this.startdate = startdate;
}
public String getTaskstatus() {
    return taskstatus;
}
public void setTaskstatus(String taskstatus) {
    this.taskstatus = taskstatus;
}
public String getDesc() {
    return desc;
}
public void setDesc(String desc) {
    this.desc = desc;
}
}
