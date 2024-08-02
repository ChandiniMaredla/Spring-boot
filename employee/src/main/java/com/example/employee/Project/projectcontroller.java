package com.example.employee.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class projectcontroller {
@Autowired
projectservice ps;
@PostMapping("/ins")
public String postMethodName(@RequestBody project p) {
    //TODO: process POST request
    int add=ps.insert(p);
    if(add>0)
    return "success";
    else if(add==-998)
    return "Enter the details of HR and Project manager in the employee table";
    else if(add==-999)
    {
        return "Only admin or HR can add detils";
    }
    else if(add==-992)
    {
        return "HR OR PM are already assigned to another project";
    }
    return "failure";
}

}
