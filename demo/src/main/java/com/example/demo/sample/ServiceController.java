package com.example.demo.sample;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController


public class ServiceController {
    @Autowired
    Sampleservice ss;
@GetMapping("/add/{num1}/{num2}")
public String add(@PathVariable int num1,@PathVariable int num2) {
    int add=ss.add(num1,num2);
    return "sum:"+add;
}

@GetMapping("/sub")

public String sub(@RequestParam int num1,@RequestParam int num2) {
    int sub=ss.sub(num1,num2);
    return "Diff: "+sub;
}

@PostMapping("/mul")
public double mul(@RequestBody Serviceobject s) {
    //TODO: process POST request
    
    return ss.mul(s);
}

@PostMapping("/div")
public double div(@RequestBody Serviceobject d) {
    //TODO: process POST request
    
    return ss.div(d);
}



}
