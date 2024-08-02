package com.example.insert.update;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/update")
public class updateController {
    @Autowired
    updateservice us;
@PostMapping("/u")
public Map postMethodName(@RequestBody update u) {
    //TODO: process POST request
    HashMap<String,String> hm=new HashMap<>();
    int add=us.updateStudent(u);
    if(add>0)
    {
        hm.put("s", "Data updated");
    }
    else
    {
        hm.put("f", "Data updation failed ");
    }

    return hm;
}

}
