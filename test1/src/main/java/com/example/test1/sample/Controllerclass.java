package com.example.test1.sample;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController


public class Controllerclass {
@Autowired
Serviceclass ss;
@GetMapping("/add/{a}/{b}")

public int getMethodName(@PathVariable int a,@PathVariable int b) {
int add=ss.add(a,b);
    return add;
}

}
