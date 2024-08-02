// 
package com.example.employee.Project;

import java.sql.Date;

public class project {

    private int id;
    private String pname;
    private String client;
    private String enddate;
    private int hrid;
    private int pmid;
    private int no_of_emp;
    
    // Getters and setters for all fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public int getHrid() {
        return hrid;
    }

    public void setHrid(int hrid) {
        this.hrid = hrid;
    }

    public int getPmid() {
        return pmid;
    }

    public void setPmid(int pmid) {
        this.pmid = pmid;
    }

    public int getNo_of_emp() {
        return no_of_emp;
    }

    public void setNo_of_emp(int no_of_emp) {
        this.no_of_emp = no_of_emp;
    }
}
