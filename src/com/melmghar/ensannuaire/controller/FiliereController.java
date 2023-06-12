package com.melmghar.ensannuaire.controller;

import java.util.ArrayList;
import java.util.List;

import com.melmghar.ensannuaire.dao.FiliereDao;
import com.melmghar.ensannuaire.model.Filiere;



public class FiliereController {
	
	FiliereDao filiereDao = new FiliereDao();
	
	public int insererFiliere(Filiere filiere) throws ClassNotFoundException {
		return filiereDao.insererFiliere(filiere);
		
	}
	
	public List<Filiere> afficherFiliere() throws ClassNotFoundException {

		return filiereDao.afficherFiliere();
		
	}
	
	public List<String> afficherFiliereNom() throws ClassNotFoundException {
	
		List<String> filiersNom = new ArrayList<String>();
		for(Filiere filiere:  filiereDao.afficherFiliere() ) {
			filiersNom.add(filiere.getNom());
		}

		return filiersNom;
		
	}

	public int modifierFilier(Filiere filiere) throws ClassNotFoundException {
		return filiereDao.modifierFiliere(filiere);
		
	}
	
	public int supprimerFilier(Long id) throws ClassNotFoundException {
		return filiereDao.supprimerFiliere(id);
		
	}
	
	public Filiere afficherFilierParNom(String nom) throws ClassNotFoundException {
		return filiereDao.rechercheFiliere(nom);
		
	}
	public Filiere afficherFilierParId(Long id) throws ClassNotFoundException {
		return filiereDao.rechercheFiliere(id);
		
	}
	public List<Filiere> afficherFilierParDepartement(Long id) throws ClassNotFoundException {
		return filiereDao.afficherFilierParDepartement(id);
		
	}
}
