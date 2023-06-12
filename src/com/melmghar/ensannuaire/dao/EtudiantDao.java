package com.melmghar.ensannuaire.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import  com.melmghar.ensannuaire.util.ConnectionHelper;
import  com.melmghar.ensannuaire.util.SqlHelper;
import com.melmghar.ensannuaire.model.Departement;
import com.melmghar.ensannuaire.model.Etudiant;

public class EtudiantDao {
	
	//inserer un etudiant
	public int insererEtudiant(Etudiant etudiant) throws ClassNotFoundException {
		
		int result = 0;
		
		ConnectionHelper.connect();
		

		PreparedStatement preparedStatement;
		try {
			preparedStatement = ConnectionHelper.CONNECTION.prepareStatement(SqlHelper.INSERT_ETUDIANT);
		
			preparedStatement.setString(1, etudiant.getCNE());
			preparedStatement.setString(2, etudiant.getNom());
			preparedStatement.setString(3, etudiant.getPrenom());
			preparedStatement.setLong(4, etudiant.getFiliereId());
			preparedStatement.setString(5,etudiant.getDepartement());
			preparedStatement.setString(6, etudiant.getTelephone());
			preparedStatement.setString(7, etudiant.getNomComplet());
			
			System.out.println(preparedStatement);
			result =  preparedStatement.executeUpdate();
	 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
			
		
		return result;
	}

	// afficher la list des étudiants
		public List<Etudiant> affichereEtudiant(){
			
			
			List<Etudiant> etudiants = new ArrayList<Etudiant>();
			
			ConnectionHelper.connect();
			
			PreparedStatement preparedStatement;
			
			try {
				preparedStatement = ConnectionHelper.CONNECTION.prepareStatement(SqlHelper.GET_ETUDIANT);
			
			
				System.out.println(preparedStatement);
				ResultSet result= preparedStatement.executeQuery();
				while(result.next()) {
					String cne = result.getString("cne");
					String nom = result.getString("nom");
					String prenom = result.getString("prenom");
					Long filiere_id = result.getLong("filiere_id");
					String telephone = result.getString("telephone");
					String departement = result.getString("departement");	 
					etudiants.add(new Etudiant(cne,nom,prenom,filiere_id,departement,telephone));
				}
		 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return etudiants;
		}
		
		//Recherche étudiant
		public Etudiant rechercheEtudiant(String nom){
			Etudiant etudiant = new Etudiant();
			ConnectionHelper.connect();
			
			PreparedStatement preparedStatement;
			
			try {
				preparedStatement = ConnectionHelper.CONNECTION.prepareStatement(SqlHelper.GET_ETUDIANT_BY_NOM_COMPLET);
			
				preparedStatement.setString(1, nom);
				
				System.out.println(preparedStatement);
				
				ResultSet result= preparedStatement.executeQuery();
				result.next();
				
				etudiant.setCNE(result.getString("CNE"));
				etudiant.setNom(result.getString("nom"));
				etudiant.setPrenom(result.getString("prenom"));
				etudiant.setFiliere(result.getLong("filiere_id"));
				etudiant.setTelephone(result.getString("telephone"));
					
		 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return etudiant;
				
		}
		//Modifier département
		public int modifierEtudiant(Etudiant etudiant) throws ClassNotFoundException {
			
			int result = 0;
			
			ConnectionHelper.connect();
			
			PreparedStatement preparedStatement;
			
			try {
				preparedStatement = ConnectionHelper.CONNECTION.prepareStatement(SqlHelper.UPDATE_ETUDIANT);
			
				preparedStatement.setString(1, etudiant.getNom());
				preparedStatement.setString(2,  etudiant.getPrenom());
				preparedStatement.setLong(3,  etudiant.getFiliereId());
				preparedStatement.setString(4,  etudiant.getDepartement());
				preparedStatement.setString(5,  etudiant.getTelephone());
				preparedStatement.setString(6,  etudiant.getCNE());
				System.out.println(preparedStatement);
				
				result =  preparedStatement.executeUpdate();
		 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
			
			return result;
			
		}
		
		//Supprimer département
		public int supprimerFiliere(String cne) {
			int result = 0;
			
			ConnectionHelper.connect();
			
			PreparedStatement preparedStatement;
			
			try {
				preparedStatement = ConnectionHelper.CONNECTION.prepareStatement(SqlHelper.DELETE_ETUDIANT);
			
				
				preparedStatement.setString(1, cne);
				System.out.println(preparedStatement);
				result =  preparedStatement.executeUpdate();
		 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
			
			return result;
			
		}

		public Etudiant rechercheEtudiantParCNE(String cne) {
			// TODO Auto-generated method stub
			Etudiant etudiant = new Etudiant();
			ConnectionHelper.connect();
			
			PreparedStatement preparedStatement;
			
			try {
				preparedStatement = ConnectionHelper.CONNECTION.prepareStatement(SqlHelper.GET_ETUDIANT_BY_CNE);
			
				preparedStatement.setString(1, cne);
				
				System.out.println(preparedStatement);
				
				ResultSet result= preparedStatement.executeQuery();
				result.next();
				
				etudiant.setCNE(result.getString("CNE"));
				etudiant.setNom(result.getString("nom"));
				etudiant.setPrenom(result.getString("prenom"));
				etudiant.setFiliere(result.getLong("filiere_id"));
				etudiant.setTelephone(result.getString("telephone"));
					
		 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return etudiant;
		}

}
