package dev.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.api.entite.Banque;
import dev.api.entite.Collaborateur;
import dev.api.repository.BanqueRepository;
import dev.api.repository.CollaborateurRepository;
import dev.api.repository.DepartementsRepository;

@RestController
@RequestMapping("/api/collaborateurs")
public class CollaborateurController {

	@Autowired
	private DepartementsRepository departementsRepository;
	@Autowired
	private CollaborateurRepository collaborateurRepository;
	@Autowired
	private BanqueRepository banqueRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Collaborateur> getCol() {
		return collaborateurRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, params = { "departement" })
	public List<Collaborateur> getCollabbyDep(@RequestParam(value = "departement") int id) {
		return collaborateurRepository.findByDepartement(departementsRepository.findById(id));
	}

	@RequestMapping(value = "/{matricule}", method = RequestMethod.GET)
	public Collaborateur getCollabbyMat(@PathVariable String matricule) {
		return collaborateurRepository.findByMatricule(matricule);
	}

	@RequestMapping(value = "/{matricule}", method = RequestMethod.PUT)
	public void setCollabbyMat(@PathVariable String matricule, @RequestBody Collaborateur c) {
		collaborateurRepository.save(c);
	}

	@RequestMapping(value = "/{matricule}/banque", method = RequestMethod.GET)
	public Banque getbanque(@PathVariable String matricule) {
		return collaborateurRepository.findByMatricule(matricule).getBanque();
	}

	@RequestMapping(value = "/{matricule}/banque", method = RequestMethod.PUT)
	public void setbanqbyMat(@PathVariable String matricule, @RequestBody Banque b) {
		banqueRepository.save(b);
	}
}
