package modele;

import java.sql.*;
import java.util.ArrayList;

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
					donnees.add( new Artistes(jeuResultats.getString( "ArtisteID" ), jeuResultats.getString( "nom" ), jeuResultats.getBoolean( "Membre" )) );

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
	
}
