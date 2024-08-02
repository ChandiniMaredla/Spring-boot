package com.example.insert.insert;

// package com.example.demo.product;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/insert")

public class ProductController {
    @Autowired
    ProductService ps;

    @PostMapping("/i")
    public String insertion_product(@RequestBody insert p) {
        //TODO: process POST request
       // HashMap<String,String> hm=new HashMap<>();
        int add=ps.addStudent(p);
        if(add>0)
        {
            return "Data inserted";
        }
        
        return "failed";
    }
    

}
