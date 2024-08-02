package com.example.employee.Projectdetails;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class detailscontroller {
@Autowired
detailsservice ds;
@GetMapping("/sel/{pid}")

public List<Map<String,Object>> select(@PathVariable String pid) throws UserException
{
    List<Map<String,Object>> list = ds.selectdetails(pid);
    return list;
}
}
