package com.example.insert.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class selectcontroller {
@Autowired
Selectservice ss;
@GetMapping("/select")
public String getMethodName() {
    int add=ss.selectall();
    if(add>0)
    {
        return "success";
    }
    return "failure";
}

}
