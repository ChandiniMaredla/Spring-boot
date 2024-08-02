package com.example.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.test.sample.Controllerclass;

@SpringBootTest
class TestApplicationTests {

	@Test
	void contextLoads() {
		Controllerclass obj=new Controllerclass();
		int add=obj.getMethodName(2,3);
		assertEquals(5,add);
	}

}
