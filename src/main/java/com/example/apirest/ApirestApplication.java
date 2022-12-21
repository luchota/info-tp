package com.example.apirest;

import com.example.apirest.models.Norecurrentes;
import com.example.apirest.models.Recurrentes;
import com.example.apirest.repositories.NoRecurrenteRepo;
import com.example.apirest.repositories.OrganizacionRepo;
import com.example.apirest.repositories.RecurrentesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.apirest.models.Personas;
import com.example.apirest.repositories.PersonasRepo;

import java.sql.Date;

@SpringBootApplication
public class ApirestApplication implements CommandLineRunner{

	@Autowired PersonasRepo personasRepo;
	@Autowired
	OrganizacionRepo orgRepo;

	@Autowired
	RecurrentesRepo recurrentesRepo;

	@Autowired
	NoRecurrenteRepo noRecurrenteRepo;

	public static void main(String[] args) {
		SpringApplication.run(ApirestApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
//		Personas personas = new Personas(1L, "Luciano", "Torre", 39614789L, "ASDGASDE34343");
//		personasRepo.save(personas);
		Recurrentes recurrentes = new Recurrentes(1L, new Date(2023, 5, 15));
		recurrentesRepo.save(recurrentes);

		Norecurrentes norecurrentes = new Norecurrentes(1L, "A33J*", "pepe",new Date(2022, 10, 5), true);
		noRecurrenteRepo.save(norecurrentes);
		
	}
}
	

	


