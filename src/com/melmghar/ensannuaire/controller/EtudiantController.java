package com.melmghar.ensannuaire.controller;

import java.util.List;

import com.melmghar.ensannuaire.dao.EtudiantDao;
import com.melmghar.ensannuaire.model.Etudiant;

public class EtudiantController {
	
	EtudiantDao etudiantDao = new EtudiantDao();
	
	public int insererEtudiant(Etudiant etudiant) throws ClassNotFoundException {
		return etudiantDao.insererEtudiant(etudiant);
		
	}
	
	public List<Etudiant> afficherEtudiant() throws ClassNotFoundException {
		return etudiantDao.affichereEtudiant();
		
	}

	public int modifierEtudiant(Etudiant etudiant) throws ClassNotFoundException {
		return etudiantDao.modifierEtudiant(etudiant);
		
	}
	
	public int supprimerEtudiant(String cne) throws ClassNotFoundException {
		return etudiantDao.supprimerFiliere(cne);
		
	}
	
	public Etudiant afficherEtudiantParNom(String nom) throws ClassNotFoundException {
		return etudiantDao.rechercheEtudiant(nom);
		
	}

	public Etudiant afficherEtudiantParCNE(String cne) {
		// TODO Auto-generated method stub
		return etudiantDao.rechercheEtudiantParCNE(cne);
	}
}
