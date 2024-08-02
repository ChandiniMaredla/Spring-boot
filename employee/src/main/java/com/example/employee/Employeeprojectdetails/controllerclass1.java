package com.example.employee.Employeeprojectdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class controllerclass1 {
@Autowired
serviceclass1 sc;
@PostMapping("/insert")
public String postMethodName(@RequestBody empprodetails e) {
    //TODO: process POST request
    int add=sc.insert(e);
    if(add>0)
    {
        return "success";
    }
    else if(add==-996)
    return "not in the employee table";
    else if(add==-998)
    {
        return "Only HR or PM can add details into the table";
    }
    else if(add==-992)
    return "Not assigned to any project";
    else if(add==-997)
    return "no employee";
    return "failure";
}

}

