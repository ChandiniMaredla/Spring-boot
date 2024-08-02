package com.example.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.employee.Employee.Serviceclass;
import com.example.employee.Employee.controllerclass;
import com.example.employee.Employee.employee;

// @SpringBootTest
// class EmployeeApplicationTests {

	// @Test
	// void contextLoads() {
	// 	controllerclass obj=new controllerclass();
	// 	List list=new ArrayList<>();
	// 	list.add(1);
	// 	list.add("hvardhan@miraclesoft.com");
	// 	list.add("Haan@10:29");
	// 	list.add("admin");
	// 	list.add(12);
	// 	list.add("vardhan");
	// 	list.add("gulla");
	// 	list.add("Eagle batch");
	// 	list.add("vardhan@gmail.com");
	// 	list.add("9988776655");
	// 	list.add(500000);
	// 	list.add("MCITY");
	// 	list.add(532216);
	// 	list.add("developer");
	// 	list.add(1);

	// 	String ans=obj.postMethodName((employee) list);
	// 	assertEquals(list, ans);
	// }


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ControllerclassTests {

    private Serviceclass service;
    private controllerclass controller;

    @BeforeEach
    void setUp() {
        service = new Serviceclass(); // Instantiate Serviceclass directly
        controller = new controllerclass(); // Inject Serviceclass into Controllerclass
    }

    @Test
    void testPostMethodName_Success() {
        employee e = new employee();
        e.setAdminid(5);
        e.setAdminworkmail("hvardhan@miraclesoft.com");
        e.setAdminpasswd("Haan@10:29");
        e.setAdminrole("admin");

        String result = controller.postMethodName(e);

        assertEquals("success", result);
    }

    @Test
    void testPostMethodName_AdminOnly() {
        employee e = new employee();
        e.setAdminid(1); // Setting admin id to 1 to simulate non-admin user

        String result = controller.postMethodName(e);

        assertEquals("Only admin can add the details of an employee", result);
    }

    @Test
    void testPostMethodName_Failure() {
        employee e = new employee();
        e.setAdminid(5);
        e.setAdminworkmail("hvardhan@miraclesoft.com");
        e.setAdminpasswd("Haan@10:29");
        e.setAdminrole("admin");

        String result = controller.postMethodName(e);

        assertEquals("failure", result);
    }

    @Test
    void testGetMethodName() {
        employee e = new employee();
        e.setFname("John");

        List<employee> result = controller.getMethodName(e);

        assertEquals(new ArrayList<>(), result); // Assuming Serviceclass returns an empty list in this example
    }
}


