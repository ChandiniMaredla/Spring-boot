package com.example.insert.delete;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/delete")

public class deletecontroller {
    @Autowired
    deleteservice ds;
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        int result = ds.deleterecord(id);
        return result == 1 ? "Record deleted successfully" : "Error deleting record";
    }
    
}
