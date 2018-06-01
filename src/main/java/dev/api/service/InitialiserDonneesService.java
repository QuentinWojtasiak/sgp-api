package dev.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.api.entite.Banque;
import dev.api.entite.Collaborateur;
import dev.api.entite.Departement;
import dev.api.repository.BanqueRepository;
import dev.api.repository.CollaborateurRepository;
import dev.api.repository.DepartementsRepository;

@Service
public class InitialiserDonneesService {

	@Autowired
	private DepartementsRepository departementsRepository;

	@Autowired
	private CollaborateurRepository collaborateurRepository;

	@Autowired
	private BanqueRepository banqueRepository;

	public void init() {
		departementsRepository.save(new Departement(1, "info"));
		departementsRepository.save(new Departement(2, "compta"));
		departementsRepository.save(new Departement(3, "DRH"));
		banqueRepository.save(new Banque(1, "nom", "123456789", "a75frz"));
		collaborateurRepository.save(new Collaborateur(1, "mat1", "Jean", new Departement(1, "info"),
				new Banque(1, "nom", "123456789", "a75frz")));
		collaborateurRepository.save(new Collaborateur(2, "mat2", "Eudes", new Departement(2, "compta"),
				new Banque(1, "nom", "123456789", "a75frz")));
		collaborateurRepository.save(new Collaborateur(3, "mat3", "Augustin", new Departement(3, "DHR"),
				new Banque(1, "nom", "123456789", "a75frz")));

	}

}
