package com.melmghar.ensannuaire.util;

public final class SqlHelper {
	
	//SQL queries for étudiant;
	
	public static String GET_ETUDIANT = "SELECT * FROM Etudiant";
	public static String INSERT_ETUDIANT = "INSERT INTO Etudiant(CNE, nom,prenom,filiere_id,departement,telephone,nom_complet)VALUES (?,?,?,?,?,?,?)";
	public static String UPDATE_ETUDIANT = "UPDATE Etudiant SET nom = ?, prenom = ?, filiere_id=?,departement=?, telephone=? WHERE CNE= ?";
	public static String DELETE_ETUDIANT = "DELETE FROM Etudiant WHERE CNE = ?";
	public static String GET_ETUDIANT_BY_NOM = "SELECT * FROM Etudiant WHERE nom=?";
	public static String GET_ETUDIANT_BY_CNE = "SELECT * FROM Etudiant WHERE CNE=?";
	public static String GET_ETUDIANT_BY_NOM_COMPLET = "SELECT * FROM Etudiant WHERE nom_complet = ?";

	//SQL queries for filiére
	
	public static String GET_FILIERE = "SELECT * FROM Filiere";
	public static String INSERT_FILIERE = "INSERT INTO Filiere(nom,depatement_id)VALUES (?,?)";
	public static String UPDATE_FILIERE = "UPDATE Filiere SET nom = ?, depatement_id = ? WHERE id= ?";
	public static String DELETE_FILIERE = "DELETE FROM Filiere WHERE id = ?";
	public static String GET_FILIERE_BY_NOM = "SELECT * FROM Filiere WHERE nom=?";
	public static String GET_FILIERE_BY_ID = "SELECT * FROM Filiere WHERE id=?";
	public static String GET_FILIERE_BY_DEPARTEMENT = "SELECT * FROM Filiere WHERE depatement_id= ?";
		


	//SQL queries for département;
		
	public static String GET_DEPARTEMENT = "SELECT * FROM Departement";
	public static String INSERT_DEPARTEMENT = "INSERT INTO Departement(nom)VALUES (?)";
	public static String UPDATE_DEPARTEMENT = "UPDATE Departement SET nom = ?  WHERE id= ?";
	public static String DELETE_DEPARTEMENT = "DELETE FROM Departement WHERE id = ?";
	public static String GET_DEPARTEMENT_BY_NOM = "SELECT * FROM Departement WHERE nom=?";
	public static String GET_DEPARTEMENT_BY_ID = "SELECT * FROM Departement WHERE id=?";
		
	
}
