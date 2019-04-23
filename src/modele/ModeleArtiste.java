package modele;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import vue.VueGestionArtiste;

public class ModeleArtiste {

	private Connection connexion = null;
	private Statement statement = null;
	
	public void connectionBD() {
		try {
			
			Class.forName( "org.sqlite.JDBC" );
			connexion = DriverManager.getConnection(  "jdbc:sqlite:sqlite//db//Ouellette-Valiquette-Albums.db"  );
			

		} catch (SQLException se) {
			System.out.println( se.getMessage() );
		}
		catch (ClassNotFoundException cnfe) {
			System.out.println( cnfe.getMessage() );
		}
	}
	
	public ArrayList<Artistes> obtenirContenuTable(){
		
		ArrayList<Artistes> donnees = new ArrayList<Artistes>();
		if ( connexion != null ) {
			try {
				
				statement = connexion.createStatement();

				ResultSet jeuResultats = statement.executeQuery( "SELECT * FROM artistes " );

				while ( jeuResultats.next() ) {
					donnees.add( new Artistes(jeuResultats.getString( "ArtisteID" ), jeuResultats.getString( "nom" ), jeuResultats.getBoolean( "Membre" ), jeuResultats.getString( "Photo" )) );

				}

			} catch ( SQLException se ) {
				System.out.println( se.getMessage() );
			}

		}
		return donnees;
	}
	
	public void fermerBD() {
		try {
			if ( connexion != null ) {

				connexion.close();
			}
		} catch ( SQLException se ) {
			System.out.println( "Erreur lors de la fermeture de la base de donné" );
		}
	}
	
	public void activerEtVider(VueGestionArtiste vue) {
	
		vue.textField_1.setEditable(true);
		vue.textField_1.setText("");
		//Ajouter le numéro à partir de la BDD
		vue.checkMembre.setSelected(false);
		
		
	}
	
	public void insererArtiste(VueGestionArtiste vue) {
		
		if(vue.textField_1.isEditable()) {
			String num = vue.textField.getText();
			String nom = vue.textField_1.getText();
			boolean membre =  vue.checkMembre.isSelected();
			
			if(connexion == null) {
				try {
					statement = connexion.createStatement();
					statement.executeQuery("INSERT INTO artistes VALUES " + num + ", " + nom + ", " + membre);
				} catch(SQLException se) {
					System.out.println(se.getMessage());
				}
			}
		}
		
	}
	
}
