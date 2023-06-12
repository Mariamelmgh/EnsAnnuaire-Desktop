package com.melmghar.ensannuaire.model;

public class Departement {
	
	private Long id;
	
	private String nom;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}



	public Departement(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	

}

