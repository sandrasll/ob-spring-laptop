package com.example.laptopsesiones456;

import com.example.laptopsesiones456.entities.Laptop;
import com.example.laptopsesiones456.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class LaptopSesiones456Application {



	public static void main(String[] args) {


		ApplicationContext context = SpringApplication.run(LaptopSesiones456Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		// CRUD
		// crear un laptop

		Laptop laptop1 = new Laptop(null, "HP", "intelcore3", 6, 2.40, 512, LocalDate.of(2021, 12, 1));
		Laptop laptop2 = new Laptop(null, "Lenovo", "intelcore5", 8, 2.40, 512, LocalDate.of(2022, 1, 30));

		// recuperar todos los laptops

		repository.save(laptop1);
		repository.save(laptop2);
		System.out.println("Num laptops en base de datos: " + repository.findAll().size());

	}
}
