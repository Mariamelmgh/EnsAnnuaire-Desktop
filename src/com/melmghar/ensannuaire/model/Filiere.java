package com.melmghar.ensannuaire.model;


public class Filiere {
	
	private Long id;
	
	private String nom;
	
	private Long departementId;
	
	public Long getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	

	public Long getDepartementId() {
		return departementId;
	}

	public void setDepartementId(Long departementId) {
		this.departementId = departementId;
	}



	public Filiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Filiere(Long id, String nom,Long departementId) {
		super();
		this.id = id;
		this.nom = nom;
		this.departementId = departementId;
	}
	public Filiere(String nom,Long departementId) {
		super();
		
		this.nom = nom;
		this.departementId = departementId;
	}
	
	
	
	

	
}
