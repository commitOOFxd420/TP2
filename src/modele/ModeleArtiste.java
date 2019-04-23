package modele;

import java.awt.Image;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import vue.VueGestionArtiste;

public class ModeleArtiste {

	private Connection connexion = null;
	private Statement statement = null;
	VueGestionArtiste vue;
	private String chemin = System.getProperty("user.dir");
	
	public ModeleArtiste(VueGestionArtiste vue) {
		
		this.vue = vue;
		
	}
	
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
	
	public void activerEtVider() {
	
		vue.textNom.setEditable(true);
		vue.textNom.setText("");
		//Ajouter le numéro à partir de la BDD
		vue.checkMembre.setSelected(false);
		
		
	}
	
	public void insererArtiste() {
		
		if(vue.textNom.isEditable()) {
			String num = vue.textNom.getText();
			String nom = vue.textNom.getText();
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
	
	public void afficherInfoArtiste ( ModeleTable modeleTable) {		
		int numLigne = vue.getTableau().getSelectedRow();
		Artistes artiste = modeleTable.getArtiste(numLigne);
		vue.textNum.setText( artiste.getNum() );
		vue.textNom.setText( artiste.getNom() );
		vue.checkMembre.setSelected( artiste.getMembre() );
		try {
		ImageIcon imageIcon = new ImageIcon(chemin + "\\images\\" + artiste.getPhoto());
		Image image = imageIcon.getImage();
		Image nouvelleImage = image.getScaledInstance( 100, 100, Image.SCALE_SMOOTH );
		imageIcon = new ImageIcon(nouvelleImage);
		vue.labelImageArtiste.setIcon( imageIcon );

		} catch (Exception e) {
			System.out.println( "Erreur lors du chargement de l'image" );
		}
		
	}
	
	public void modifierInfoArtiste (ModeleTable modelTable) {
		
		
		
	}
	
}
