package dev.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.api.entite.Departement;
import dev.api.repository.DepartementsRepository;

@RestController
@RequestMapping("/api/departements")
public class DepartementsController {

	@Autowired
	private DepartementsRepository departementsRepository;

	@GetMapping
	public List<Departement> afficherDepartements() {
		return departementsRepository.findAll();
	}
}
