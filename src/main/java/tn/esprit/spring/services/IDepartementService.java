package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Departement;

public interface IDepartementService {
	
	public Departement ajouterDepartement(Departement dep);
	public void deleteDepById(int depId);
	public List<Departement> getAlldep();

}