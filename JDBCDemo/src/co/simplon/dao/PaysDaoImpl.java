package co.simplon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import co.simplon.model.Pays;

public class PaysDaoImpl implements PaysDAO{

	private DAOContext daoContext;
	
	//constructeur
	public PaysDaoImpl(DAOContext daoContext) {
		this.daoContext = daoContext;
	}

	@Override 
	public void ajouter(Pays pays) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connexion = DAOContext.getConnection();
			preparedStatement = connexion.prepareStatement("INSERT INTO pays(nom) VALUES(?);");
			preparedStatement.setString(1, pays.getNom());
			preparedStatement.executeUpdate();
			//preparedStatement = connexion.prepareStatement("INSERT INTO pays(id, nom) VALUES(?,?);");
			//preparedStatement.setInt(1, pays.getId());
			//preparedStatement.setString(2, pays.getNom());
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	@Override 
	public List<Pays> lister() {
		
		
		
		List<Pays> Lpays = new ArrayList<Pays>();
		
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		
		
		
		try {
			connexion = DAOContext.getConnection();
			statement = connexion.createStatement();
			
			//Execution de la requête
			resultat = statement.executeQuery("SELECT id,nom FROM testjdbc.pays;");
		
		
		while(resultat.next()) {
			
			int id = resultat.getInt("id");
			String nom = resultat.getString("nom");
			
			Pays pays = new Pays(id,nom);
			pays.setId(id);
			pays.setNom(nom);
			Lpays.add(pays);
			
		}
		
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		
		return Lpays;
	

}
}

