package com.example.employee.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/employee")
public class controllerclass {
@Autowired
Serviceclass sc;
@PostMapping("/i")
public String postMethodName(@RequestBody employee e) {
    //TODO: process POST request
    int add=sc.insert(e);
    if(add>0)
    {
        return "success";
    }
    if(add==-999)
    return "Only admin can add the details of an employee";
    return "failure";
}

@PostMapping("/s")
public List<employee> getMethodName(@RequestBody employee e) {
    return sc.selectrecords(e);
}


}
