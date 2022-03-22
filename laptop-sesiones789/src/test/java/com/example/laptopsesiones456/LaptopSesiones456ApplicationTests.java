package com.example.laptopsesiones456;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LaptopSesiones456ApplicationTests {

	@Test
	void contextLoads() {
		System.getenv().forEach(
			(key,value)-> System.out.println(key+" "+value)
		);
	}

}
