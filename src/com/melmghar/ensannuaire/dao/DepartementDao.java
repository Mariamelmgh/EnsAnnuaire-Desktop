package com.melmghar.ensannuaire.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.melmghar.ensannuaire.model.Departement;
import com.melmghar.ensannuaire.model.Etudiant;
import com.melmghar.ensannuaire.util.ConnectionHelper;
import com.melmghar.ensannuaire.util.SqlHelper;
import com.mysql.cj.protocol.Resultset;

public class DepartementDao {
	
	
	//inserer une département
	public int insererDepartement(Departement departement) {
		
		int result = 0;
		
		ConnectionHelper.connect();
		
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = ConnectionHelper.CONNECTION.prepareStatement(SqlHelper.INSERT_DEPARTEMENT);
		
			preparedStatement.setString(1, departement.getNom());
			System.out.println(preparedStatement);
			result =  preparedStatement.executeUpdate();
	 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
			
		
		return result;
		
	}
	
	// afficher la list des département
	public List<Departement> affichereDepartements(){
		
		
		List<Departement> departements = new ArrayList<Departement>();
		
		ConnectionHelper.connect();
		
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = ConnectionHelper.CONNECTION.prepareStatement(SqlHelper.GET_DEPARTEMENT);
		
		
			System.out.println(preparedStatement);
			ResultSet result= preparedStatement.executeQuery();
			while(result.next()) {
				Long id = result.getLong("id");
				String nom = result.getString("nom");
				departements.add(new Departement(id,nom));
			}
	 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return departements;
	}
	
	//Recherche département
	public Departement rechercheDepartement(String nom){
		Departement departement = new Departement();
		ConnectionHelper.connect();
		
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = ConnectionHelper.CONNECTION.prepareStatement(SqlHelper.GET_DEPARTEMENT_BY_NOM);
		
			preparedStatement.setString(1, nom);
			
			System.out.println(preparedStatement);
			
			ResultSet result= preparedStatement.executeQuery();
			result.next();
				departement.setId(result.getLong("id"));
				departement.setNom(result.getString("nom"));
				
	 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return departement;
			
	}
	//Recherche département par id
		public Departement rechercheDepartementParId(Long id){
			Departement departement = new Departement();
			ConnectionHelper.connect();
			
			PreparedStatement preparedStatement;
			
			try {
				preparedStatement = ConnectionHelper.CONNECTION.prepareStatement(SqlHelper.GET_DEPARTEMENT_BY_ID);
			
				preparedStatement.setLong(1, id);
				
				System.out.println(preparedStatement);
				
				ResultSet result= preparedStatement.executeQuery();
				result.next();
					departement.setId(result.getLong("id"));
					departement.setNom(result.getString("nom"));
					
		 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return departement;
				
		}
	//Modifier département
	public int modifierDepartement(Departement departement) {
		
		int result = 0;
		
		ConnectionHelper.connect();
		
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = ConnectionHelper.CONNECTION.prepareStatement(SqlHelper.UPDATE_DEPARTEMENT);
		
			preparedStatement.setString(1, departement.getNom());
			preparedStatement.setLong(2, departement.getId());
			System.out.println(preparedStatement);
			result =  preparedStatement.executeUpdate();
	 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		return result;
		
	}
	
	//Supprimer département
	public int supprimerDepartement(Long id) {
		int result = 0;
		
		ConnectionHelper.connect();
		
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = ConnectionHelper.CONNECTION.prepareStatement(SqlHelper.DELETE_DEPARTEMENT);
		
			
			preparedStatement.setLong(1, id);
			System.out.println(preparedStatement);
			result =  preparedStatement.executeUpdate();
	 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		return result;
		
	}


}
