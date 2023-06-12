package com.melmghar.ensannuaire.controller;

import java.util.ArrayList;
import java.util.List;

import com.melmghar.ensannuaire.dao.DepartementDao;
import com.melmghar.ensannuaire.model.Departement;
import com.melmghar.ensannuaire.model.Etudiant;


public class DepartementController {
	
DepartementDao departementDao = new DepartementDao();
	
	public int insererDepartement(Departement departement) throws ClassNotFoundException {
		return departementDao.insererDepartement(departement);
		
	}
	
	public List<Departement> afficherDepartement() throws ClassNotFoundException {
		return departementDao.affichereDepartements();
		
	}
	
	public List<String> afficherDepartementNom() throws ClassNotFoundException {
		List<String> departements = new ArrayList<String>();
		for(Departement dep :  afficherDepartement()) {
			departements.add(dep.getNom());
		}
		return departements;
		
	}

	public int modifierDepartement(Departement departement) throws ClassNotFoundException {
		return departementDao.modifierDepartement(departement);
		
	}
	
	public int supprimerDepartement(Long id) throws ClassNotFoundException {
		return departementDao.supprimerDepartement(id);
		
	}
	
	public Departement afficherDepartementParNom(String nom) throws ClassNotFoundException {
		return departementDao.rechercheDepartement(nom);
		
	}

	public Departement afficherDepartementParId(Long id) {
		// TODO Auto-generated method stub
		return departementDao.rechercheDepartementParId(id);
	}

}
