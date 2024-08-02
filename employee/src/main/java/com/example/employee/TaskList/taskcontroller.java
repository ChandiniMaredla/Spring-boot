package com.example.employee.TaskList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class taskcontroller {
@Autowired
taskservice ts;
@PostMapping("/addtask")
public String postMethodName(@RequestBody task t) {
    //TODO: process POST request
    int add=ts.inserttask(t);
    if(add>0)
    return "success";
    else if(add==-999)
    {
        return "no emp";
    }
    else if(add==-998)
    return "no emp in projectdetails";
    else if(add==-997)
    {
        return "incorrect lead of emp";
    }
    return "failure";
}

}
