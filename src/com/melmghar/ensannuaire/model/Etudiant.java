package com.melmghar.ensannuaire.model;

import com.melmghar.ensannuaire.dao.DepartementDao;
import com.melmghar.ensannuaire.dao.FiliereDao;

//import com.melmghar.ensannuaire.dao.DepartementDao;
//import com.melmghar.ensannuaire.dao.FiliereDao;

public class Etudiant {
	//CNE, nom, prénom, filière,
	//département et téléphone 
	
	private String CNE;
	private String nom;
	private String prenom;
	private Long filiereId;
	private String departement;
	private String filiere;
	private String telephone;
	private String nomComplet;
	
	
	//Getter & Setters
	
	public String getCNE() {
		return CNE;
	}
	
	public void setCNE(String cNE) {
		CNE = cNE;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public Long getFiliereId() {
		return this.filiereId;
	}
	
	public void setFiliere(Long filiereId) {
		this.filiereId = filiereId;
	}
	
	
	  public String getDepartement() throws ClassNotFoundException { FiliereDao
	  filiereDao = new FiliereDao(); Filiere filiere =
	  filiereDao.rechercheFiliere(this.getFiliereId());
	  
	  DepartementDao departementDao = new DepartementDao();
	  
	  this.departement =
	  departementDao.rechercheDepartementParId(filiere.getDepartementId()).getNom();
	  
	  return departement; }
	  
	  public String getFiliere() throws ClassNotFoundException { FiliereDao
	  filiereDao = new FiliereDao(); Filiere filiere_ =
	  filiereDao.rechercheFiliere(this.getFiliereId()); this.filiere =
	  filiere_.getNom(); return filiere; }
	 

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	public void setDepartement(String departement) {
	
		this.departement = departement;
	}
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getNomComplet() {
		return this.prenom + " " + this.nom;
	}

	public Etudiant(String cNE, String nom, String prenom, Long filiereId, String departement, String telephone) {
		super();
		CNE = cNE;
		this.nom = nom;
		this.prenom = prenom;
		this.filiereId = filiereId;
		this.departement = departement;
		this.telephone = telephone;
	}

	public Etudiant() {
		super();
	}

	
}
