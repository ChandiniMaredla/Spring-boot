
package com.example.demo.Employee_json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Courses {
    public static void main(String[] args) {
        // Create an ArrayList of Employee objects
        List<Employee> courses = new ArrayList<>();
        courses.add(new Employee(1, "chinna", "software", 10));
        courses.add(new Employee(2, "Chandini", "software trainee", 3));

        // Convert the ArrayList to a JSON array and save to file
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonArray = objectMapper.writeValueAsString(courses);
            System.out.println(jsonArray);  // Print to console (optional)
            
            // Write JSON output to a file
            objectMapper.writeValue(new File("employees.json"), courses);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
