package com.melmghar.ensannuaire.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.melmghar.ensannuaire.model.Filiere;
import com.melmghar.ensannuaire.util.ConnectionHelper;
import com.melmghar.ensannuaire.util.SqlHelper;

public class FiliereDao {
	
	
	
	//inserer une filiére
	public int insererFiliere(Filiere filiere) {
		
		int result = 0;
		
		ConnectionHelper.connect();
		
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = ConnectionHelper.CONNECTION.prepareStatement(SqlHelper.INSERT_FILIERE);
		
			preparedStatement.setString(1, filiere.getNom());
			preparedStatement.setLong(2, filiere.getDepartementId());
			
			System.out.println(preparedStatement);
			
			result =  preparedStatement.executeUpdate();
	 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
			
		
		return result;
		
	}
	
	// afficher la list des filieres
	public List<Filiere> afficherFiliere(){
		
		
		List<Filiere> filieres = new ArrayList<Filiere>();
		
		ConnectionHelper.connect();
		
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = ConnectionHelper.CONNECTION.prepareStatement(SqlHelper.GET_FILIERE);
		
		
			System.out.println(preparedStatement);
			
			ResultSet result= preparedStatement.executeQuery();
			
			while(result.next()) {
				Long id = result.getLong("id");
				String nom = result.getString("nom");
				Long departementId = result.getLong("depatement_id");
				filieres.add(new Filiere(id,nom,departementId));
			}
	 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return filieres;
	}
	
	//Recherche filiére
	public Filiere rechercheFiliere(String nom){
		
		Filiere filiere = new Filiere();
		ConnectionHelper.connect();
		
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = ConnectionHelper.CONNECTION.prepareStatement(SqlHelper.GET_FILIERE_BY_NOM);
		
			preparedStatement.setString(1, nom);
			
			System.out.println(preparedStatement);
			
			ResultSet result= preparedStatement.executeQuery();
			result.next();
				filiere.setId(result.getLong("id"));
				filiere.setNom(result.getString("nom"));
				filiere.setDepartementId(result.getLong("depatement_id"));
	 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filiere;
			
	}
	
	//Recherche filiére par Id
		public Filiere rechercheFiliere(Long id){
			
			Filiere filiere = new Filiere();
			ConnectionHelper.connect();
			
			PreparedStatement preparedStatement;
			
			try {
				preparedStatement = ConnectionHelper.CONNECTION.prepareStatement(SqlHelper.GET_FILIERE_BY_ID);
			
				preparedStatement.setLong(1, id);
				
				System.out.println(preparedStatement);
				
				ResultSet result= preparedStatement.executeQuery();
				result.next();
					filiere.setId(result.getLong("id"));
					filiere.setNom(result.getString("nom"));
					filiere.setDepartementId(result.getLong("depatement_id"));
		 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return filiere;
				
		}
	//Modifier filiére
	public int modifierFiliere(Filiere filiere) {
		
		int result = 0;
		
		ConnectionHelper.connect();
		
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = ConnectionHelper.CONNECTION.prepareStatement(SqlHelper.UPDATE_FILIERE);
		
			preparedStatement.setString(1, filiere.getNom());
			preparedStatement.setLong(2, filiere.getDepartementId());
			preparedStatement.setLong(3, filiere.getId());
			System.out.println(preparedStatement);
			
			result =  preparedStatement.executeUpdate();
	 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		return result;
		
	}
	
	//Supprimer département
	public int supprimerFiliere(Long id) {
		int result = 0;
		
		ConnectionHelper.connect();
		
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = ConnectionHelper.CONNECTION.prepareStatement(SqlHelper.DELETE_FILIERE);
		
			
			preparedStatement.setLong(1, id);
			System.out.println(preparedStatement);
			result =  preparedStatement.executeUpdate();
	 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		return result;
		
	}

	public List<Filiere> afficherFilierParDepartement(Long departementId) {
		// TODO Auto-generated method stub
		List<Filiere> filieres = new ArrayList<Filiere>();
		
		ConnectionHelper.connect();
		
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = ConnectionHelper.CONNECTION.prepareStatement(SqlHelper.GET_FILIERE_BY_DEPARTEMENT);
		
		
			preparedStatement.setLong(1, departementId);
			System.out.println(preparedStatement);
			
			ResultSet result= preparedStatement.executeQuery();
			
			while(result.next()) {
				Long id = result.getLong("id");
				String nom = result.getString("nom");
				filieres.add(new Filiere(id,nom,departementId));
			}
	 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return filieres;
	}



}
