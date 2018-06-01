package dev.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.api.entite.Departement;

public interface DepartementsRepository extends JpaRepository<Departement, Integer> {
	Departement findById(int id);
}
