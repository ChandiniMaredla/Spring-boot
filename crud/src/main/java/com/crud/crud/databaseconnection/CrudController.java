package com.crud.crud.databaseconnection;

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
@RequestMapping("/databaseconnection")

public class CrudController {
    @Autowired
    Crudservice cs;
@PostMapping("/i")
public Map insertProduct(@RequestBody Crudobj obj)
{
    HashMap<String,String> hm=new HashMap<>();
    int add=cs.insertproduct(obj);
    if(add>0)
    {
        hm.put("s","Data inserted");
    }
    else
    {
        hm.put("f","Insertion failed");
    }
    return hm;
}

}
