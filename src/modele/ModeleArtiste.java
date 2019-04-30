package modele;

import java.awt.Image;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
<<<<<<< Upstream, based on origin/master
=======
import javax.swing.JOptionPane;
>>>>>>> b1781ca Ajustement de fonction et d'affichage.
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import vue.CellsRenderer;
import vue.VueGestionArtiste;

public class ModeleArtiste {

	private Connection connexion = null;
	private Statement statement = null;
	VueGestionArtiste vue;
<<<<<<< Upstream, based on origin/master
	private String chemin = System.getProperty("user.dir");
=======
	private String chemin = System.getProperty( "user.dir" );
>>>>>>> b1781ca Ajustement de fonction et d'affichage.
	private PreparedStatement preSta = null;

	public ModeleArtiste( VueGestionArtiste vue ) {

		this.vue = vue;

	}

	public void connectionBD() {
		try {

			Class.forName( "org.sqlite.JDBC" );
			connexion = DriverManager.getConnection( "jdbc:sqlite:sqlite//db//Ouellette-Valiquette-Albums.db" );

		} catch ( SQLException se ) {
			System.out.println( se.getMessage() );
		} catch ( ClassNotFoundException cnfe ) {
			System.out.println( cnfe.getMessage() );
		}
	}

	public ArrayList<Artistes> obtenirContenuTable() {

		ArrayList<Artistes> donnees = new ArrayList<Artistes>();
		if ( connexion != null ) {
			try {

				statement = connexion.createStatement();

				ResultSet jeuResultats = statement.executeQuery( "SELECT * FROM artistes " );

				while ( jeuResultats.next() ) {
					donnees.add( new Artistes( jeuResultats.getString( "ArtisteID" ), jeuResultats.getString( "nom" ),
							jeuResultats.getBoolean( "Membre" ), jeuResultats.getString( "Photo" ) ) );

				}

				statement.close();
				jeuResultats.close();

<<<<<<< Upstream, based on origin/master
			} catch (SQLException se) {
				System.out.println(se.getMessage());
=======
			} catch ( SQLException se ) {
				System.out.println( se.getMessage() );
>>>>>>> b1781ca Ajustement de fonction et d'affichage.
			}

		}
		return donnees;
	}

	public void fermerBD() {
		try {
			if ( connexion != null ) {

				connexion.close();

			}

<<<<<<< Upstream, based on origin/master
		} catch (SQLException se) {
			System.out.println("Erreur lors de la fermeture de la base de donné");
=======
		} catch ( SQLException se ) {
			System.out.println( "Erreur lors de la fermeture de la base de donné" );
>>>>>>> b1781ca Ajustement de fonction et d'affichage.
		}
	}

<<<<<<< Upstream, based on origin/master
	public void activerEtVider(ModeleTable modele) {
=======
	public void activerEtVider( ModeleTable modele ) {
>>>>>>> b1781ca Ajustement de fonction et d'affichage.

		try {
			if ( connexion != null ) {

				statement = connexion.createStatement();

<<<<<<< Upstream, based on origin/master
				ResultSet result = statement.executeQuery("SELECT artisteId from artistes");
=======
				ResultSet result = statement.executeQuery( "SELECT artisteId from artistes" );
>>>>>>> b1781ca Ajustement de fonction et d'affichage.

<<<<<<< Upstream, based on origin/master
				vue.textRechercheArtiste.setText("");
				rechercherArtiste(modele);
				vue.textNom.setEditable(true);
				vue.textNom.setText("");
				vue.checkMembre.setSelected(false);

				vue.textNum.setText(Integer.parseInt(modele.getArtiste(modele.getRowCount() - 1).getNum()) + 1 + "");
=======
				vue.textRechercheArtiste.setText( "" );
				rechercherArtiste( modele );
				vue.textNom.setEditable( true );
				vue.textNom.setText( "" );
				vue.checkMembre.setSelected( false );

				vue.textNum.setText(
						Integer.parseInt( modele.getArtiste( modele.getRowCount() - 1 ).getNum() ) + 1 + "" );
>>>>>>> b1781ca Ajustement de fonction et d'affichage.

				result.close();
			}
		} catch ( SQLException e ) {
			e.printStackTrace();
		}

	}

	public void desactiverEtVider() {

<<<<<<< Upstream, based on origin/master
		vue.textNom.setEditable(false);
		vue.textNom.setText("");
		vue.checkMembre.setSelected(false);
		vue.textNum.setText("");
=======
		vue.textNom.setEditable( false );
		vue.textNom.setText( "" );
		vue.checkMembre.setSelected( false );
		vue.textNum.setText( "" );
>>>>>>> b1781ca Ajustement de fonction et d'affichage.
	}

<<<<<<< Upstream, based on origin/master
	public ModeleTable insererArtiste(ModeleTable modele) {
=======
	public ModeleTable insererArtiste( ModeleTable modele ) {
>>>>>>> b1781ca Ajustement de fonction et d'affichage.

		if ( vue.textNom.isEditable() ) {
			String nom = vue.textNom.getText();
			boolean membre = vue.checkMembre.isSelected();

			if ( connexion != null ) {
				try {
<<<<<<< Upstream, based on origin/master
					String sql = ("INSERT INTO artistes (nom, Membre, Photo) VALUES (?, ?, ?)");

					preSta = connexion.prepareStatement(sql);
					preSta.setString(1, nom);
					preSta.setBoolean(2, membre);
					preSta.setString(3, "defaut.png");
					preSta.executeUpdate();
					preSta.closeOnCompletion();
					modele.addRow(new Artistes(vue.textNum.getText(), nom, membre, "defaut.png"));

				} catch (SQLException se) {
					System.out.println(se.getMessage());
=======
					String sql = ( "INSERT INTO artistes (nom, Membre, Photo) VALUES (?, ?, ?)" );

					preSta = connexion.prepareStatement( sql );
					preSta.setString( 1, nom );
					preSta.setBoolean( 2, membre );
					preSta.setString( 3, "defaut.png" );
					preSta.executeUpdate();
					preSta.closeOnCompletion();
					modele.addRow( new Artistes( vue.textNum.getText(), nom, membre, "defaut.png" ) );

				} catch ( SQLException se ) {
					System.out.println( se.getMessage() );
>>>>>>> b1781ca Ajustement de fonction et d'affichage.
				}
			}
		}

		return modele;
<<<<<<< Upstream, based on origin/master

	}

	public ArrayList<Albums> obtenirAlbums(int artisteID) {
		ArrayList<Albums> albums = new ArrayList<Albums>();

		if (connexion != null) {
			try {

				statement = connexion.createStatement();

				ResultSet jeuResultats = statement
						.executeQuery("SELECT * FROM albums where artisteID = '" + artisteID + "';");

				while (jeuResultats.next()) {
					albums.add(new Albums(jeuResultats.getInt("albumID"), jeuResultats.getString("Titre"),
							jeuResultats.getString("Genre"), jeuResultats.getString("AnneeSortie"),
							jeuResultats.getString("ImageCouverture"), jeuResultats.getInt("artisteID")));
				}

				jeuResultats.close();

				statement.closeOnCompletion();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}

		}
		return albums;

	}

	public void afficherAlbum(ModeleTable modeleTable) {

		vue.dataModel.clear();

		int numLigne = vue.getTableau().getSelectedRow();
		Artistes artisteTemp = modeleTable.getArtiste(numLigne);
		ArrayList<Albums> albums = obtenirAlbums(Integer.parseInt(artisteTemp.getNum()));

		for (Albums album : albums) {
			vue.dataModel.addElement(album);
		}
	}

	public void activerModification() {

		vue.textNom.setEditable(true);
		vue.btnModifier.setEnabled(true);

	}

	public ModeleTable refreshTable(ModeleTable modeleTable) {
		ArrayList<Artistes> donnees = this.obtenirContenuTable();

		modeleTable = new ModeleTable(donnees);

		vue.getTableau().setModel(modeleTable);
		vue.getTableau().getColumnModel().getColumn(0).setMinWidth(25);
		vue.getTableau().getColumnModel().getColumn(0).setMaxWidth(25);

		vue.getTableau().getColumnModel().getColumn(2).setMinWidth(27);
		vue.getTableau().getColumnModel().getColumn(2).setMaxWidth(50);

		vue.textNom.setEditable(false);
		vue.labelImageArtiste.setIcon(null);
		desactiverEtVider();
		return modeleTable;

	}

	public void modifierArtiste(ModeleTable modeleTable) {
		int numLigne = vue.getTableau().getSelectedRow();
		Artistes artiste = modeleTable.getArtiste(numLigne);
		if (connexion != null) {

			try {
				preSta = connexion.prepareStatement("UPDATE artistes SET nom = ?," + " Membre = ? WHERE ArtisteID = ?");

				preSta.setString(1, vue.textNom.getText());
				preSta.setBoolean(2, vue.checkMembre.isSelected());
				preSta.setInt(3, Integer.parseInt(artiste.getNum()));

				preSta.executeUpdate();

				preSta.closeOnCompletion();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}

		}

	}

	public ModeleTable supprimerArtiste(ModeleTable modeleTable) {
		int numLigne = vue.getTableau().getSelectedRow();
		Artistes artiste = modeleTable.getArtiste(numLigne);

		if (connexion != null) {
			// Supprimer les albums reliés.
			try {

				preSta = connexion.prepareStatement("DELETE FROM albums WHERE artisteID = ?");
				preSta.setInt(1, Integer.parseInt(artiste.getNum()));
				preSta.executeUpdate();

				preSta.closeOnCompletion();

			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}

			// Supprimer l'artiste
			try {
				preSta = connexion.prepareStatement("DELETE FROM artistes WHERE artisteID = ?");
				preSta.setInt(1, Integer.parseInt(artiste.getNum()));
				preSta.executeUpdate();
				preSta.closeOnCompletion();

				modeleTable.deleteRow(numLigne);

			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}

		}

		return modeleTable;
	}

	public void remplacerImageArtiste(ModeleTable modeleTable) {

		int numLigne = vue.getTableau().getSelectedRow();
		Artistes artiste = modeleTable.getArtiste(numLigne);

		JFileChooser fichier = new JFileChooser(chemin + "\\images\\artistes");
		FileFilter filtre = new FileNameExtensionFilter("Fichier image", ImageIO.getReaderFileSuffixes());
		fichier.addChoosableFileFilter(filtre);
		fichier.setAcceptAllFileFilterUsed(false);
		fichier.showOpenDialog(vue.getFrame().getContentPane());
		if (fichier.getSelectedFile() != null) {
			File photo = fichier.getSelectedFile();
			String nomPhoto = photo.getName();

			try {
				preSta = connexion.prepareStatement("UPDATE artistes SET Photo = ?" + "WHERE ArtisteID = ?");

				preSta.setString(1, nomPhoto);
				preSta.setInt(2, Integer.parseInt(artiste.getNum()));

				preSta.executeUpdate();

				ImageIcon imageIcon = new ImageIcon(photo.getAbsolutePath());
				Image image = imageIcon.getImage();
				Image nouvelleImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
				imageIcon = new ImageIcon(nouvelleImage);

				vue.labelImageArtiste.setIcon(imageIcon);
				preSta.closeOnCompletion();

			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}

		}

	}

	public void afficherInfoArtiste(ModeleTable modeleTable) {
		int numLigne = vue.getTableau().getSelectedRow();
		Artistes artiste = modeleTable.getArtiste(numLigne);
		vue.textNum.setText(artiste.getNum());
		vue.textNom.setText(artiste.getNom());
		vue.checkMembre.setSelected(artiste.getMembre());

		ImageIcon imageIcon;
		Image image;
		Image nouvelleImage;
		try {
			imageIcon = new ImageIcon(chemin + "\\images\\artistes\\" + artiste.getPhoto());
			image = imageIcon.getImage();
			nouvelleImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(nouvelleImage);
			vue.labelImageArtiste.setIcon(imageIcon);

		} catch (Exception e) {
			imageIcon = new ImageIcon(chemin + "\\images\\artistes\\defaut.png");
			image = imageIcon.getImage();
			nouvelleImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(nouvelleImage);
			vue.labelImageArtiste.setIcon(imageIcon);
		}
=======
>>>>>>> b1781ca Ajustement de fonction et d'affichage.

		vue.textNom.setEditable(false);
		vue.btnModifier.setEnabled(false);

<<<<<<< Upstream, based on origin/master
=======
	public ArrayList<Albums> obtenirAlbums( int artisteID ) {
		ArrayList<Albums> albums = new ArrayList<Albums>();

		if ( connexion != null ) {
			try {

				statement = connexion.createStatement();

				ResultSet jeuResultats = statement
						.executeQuery( "SELECT * FROM albums where artisteID = '" + artisteID + "';" );

				while ( jeuResultats.next() ) {
					albums.add( new Albums( jeuResultats.getInt( "albumID" ), jeuResultats.getString( "Titre" ),
							jeuResultats.getString( "Genre" ), jeuResultats.getString( "AnneeSortie" ),
							jeuResultats.getString( "ImageCouverture" ), jeuResultats.getInt( "artisteID" ) ) );
				}

				jeuResultats.close();

				statement.closeOnCompletion();
			} catch ( SQLException se ) {
				System.out.println( se.getMessage() );
			}

		}
		return albums;

	}

	public void afficherAlbum( ModeleTable modeleTable ) {

		vue.dataModel.clear();

		int numLigne = vue.getTableau().getSelectedRow();
		Artistes artisteTemp = modeleTable.getArtiste( numLigne );
		ArrayList<Albums> albums = obtenirAlbums( Integer.parseInt( artisteTemp.getNum() ) );

		for ( Albums album : albums ) {
			vue.dataModel.addElement( album );
		}
>>>>>>> b1781ca Ajustement de fonction et d'affichage.
	}

	public void activerModification() {

		vue.textNom.setEditable( true );
		vue.btnModifier.setEnabled( true );

	}

	public ModeleTable refreshTable( ModeleTable modeleTable ) {
		ArrayList<Artistes> donnees = this.obtenirContenuTable();

		modeleTable = new ModeleTable( donnees );

		vue.getTableau().setModel( modeleTable );
		vue.getTableau().getColumnModel().getColumn( 0 ).setCellRenderer( new CellsRenderer() );

		vue.getTableau().getColumnModel().getColumn( 0 ).setMinWidth( 25 );
		vue.getTableau().getColumnModel().getColumn( 0 ).setMaxWidth( 25 );

		vue.getTableau().getColumnModel().getColumn( 2 ).setMinWidth( 27 );
		vue.getTableau().getColumnModel().getColumn( 2 ).setMaxWidth( 50 );

		vue.textNom.setEditable( false );
		vue.labelImageArtiste.setIcon( null );
		desactiverEtVider();
		return modeleTable;

	}

	public void modifierArtiste( ModeleTable modeleTable ) {
		int numLigne = vue.getTableau().getSelectedRow();
		Artistes artiste = modeleTable.getArtiste( numLigne );
		if ( connexion != null ) {

			try {
				preSta = connexion
						.prepareStatement( "UPDATE artistes SET nom = ?," + " Membre = ? WHERE ArtisteID = ?" );

				preSta.setString( 1, vue.textNom.getText() );
				preSta.setBoolean( 2, vue.checkMembre.isSelected() );
				preSta.setInt( 3, Integer.parseInt( artiste.getNum() ) );

				preSta.executeUpdate();

				preSta.closeOnCompletion();
			} catch ( SQLException se ) {
				System.out.println( se.getMessage() );
			}

		}

	}

	public ModeleTable supprimerArtiste( ModeleTable modeleTable ) {

		int numLigne = vue.getTableau().getSelectedRow();
		Artistes artiste = modeleTable.getArtiste( numLigne );

		int n = JOptionPane.showConfirmDialog( vue.getFrame(),
				"Voulez vous vraiment supprimer l'artiste " + artiste.getNom() + " ?", "Confirmation suppresion",
				JOptionPane.YES_NO_OPTION );

		if ( n == JOptionPane.YES_OPTION ) {
			if ( connexion != null ) {
				// Supprimer les albums reliés.
				try {
					
					preSta = connexion.prepareStatement( "DELETE FROM albums WHERE artisteID = ?" );
					preSta.setInt( 1, Integer.parseInt( artiste.getNum() ) );
					preSta.executeUpdate();

					preSta.closeOnCompletion();

				} catch ( SQLException se ) {
					System.out.println( se.getMessage() );
				}

				// Supprimer l'artiste
				try {
					preSta = connexion.prepareStatement( "DELETE FROM artistes WHERE artisteID = ?" );
					preSta.setInt( 1, Integer.parseInt( artiste.getNum() ) );
					preSta.executeUpdate();
					preSta.closeOnCompletion();

					modeleTable.deleteRow( numLigne );

				} catch ( SQLException se ) {
					System.out.println( se.getMessage() );
				}

			}
		}

		return modeleTable;
	}

	public void remplacerImageArtiste( ModeleTable modeleTable ) {

		int numLigne = vue.getTableau().getSelectedRow();
		Artistes artiste = modeleTable.getArtiste( numLigne );

		JFileChooser fichier = new JFileChooser( chemin + "\\images\\artistes" );
		FileFilter filtre = new FileNameExtensionFilter( "Fichier image", ImageIO.getReaderFileSuffixes() );
		fichier.addChoosableFileFilter( filtre );
		fichier.setAcceptAllFileFilterUsed( false );
		fichier.showOpenDialog( vue.getFrame().getContentPane() );
		if ( fichier.getSelectedFile() != null ) {
			File photo = fichier.getSelectedFile();
			String nomPhoto = photo.getName();

			try {
				preSta = connexion.prepareStatement( "UPDATE artistes SET Photo = ?" + "WHERE ArtisteID = ?" );

				preSta.setString( 1, nomPhoto );
				preSta.setInt( 2, Integer.parseInt( artiste.getNum() ) );

				preSta.executeUpdate();

				ImageIcon imageIcon = new ImageIcon( photo.getAbsolutePath() );
				Image image = imageIcon.getImage();
				Image nouvelleImage = image.getScaledInstance( 100, 100, Image.SCALE_SMOOTH );
				imageIcon = new ImageIcon( nouvelleImage );

				vue.labelImageArtiste.setIcon( imageIcon );
				preSta.closeOnCompletion();

			} catch ( SQLException se ) {
				System.out.println( se.getMessage() );
			}

		}

	}

	public void afficherInfoArtiste( ModeleTable modeleTable ) {
		int numLigne = vue.getTableau().getSelectedRow();
		Artistes artiste = modeleTable.getArtiste( numLigne );
		vue.textNum.setText( artiste.getNum() );
		vue.textNom.setText( artiste.getNom() );
		vue.checkMembre.setSelected( artiste.getMembre() );

		ImageIcon imageIcon;
		Image image;
		Image nouvelleImage;
		try {
			imageIcon = new ImageIcon( chemin + "\\images\\artistes\\" + artiste.getPhoto() );
			image = imageIcon.getImage();
			nouvelleImage = image.getScaledInstance( 100, 100, Image.SCALE_SMOOTH );
			imageIcon = new ImageIcon( nouvelleImage );
			vue.labelImageArtiste.setIcon( imageIcon );

		} catch ( Exception e ) {
			imageIcon = new ImageIcon( chemin + "\\images\\artistes\\defaut.png" );
			image = imageIcon.getImage();
			nouvelleImage = image.getScaledInstance( 100, 100, Image.SCALE_SMOOTH );
			imageIcon = new ImageIcon( nouvelleImage );
			vue.labelImageArtiste.setIcon( imageIcon );
		}

		vue.textNom.setEditable( false );
		vue.btnModifier.setEnabled( false );

	}

	public void afficherImageAlbum() {
		if ( !vue.listAlbums.isSelectionEmpty() ) {
			Albums albumTemp = vue.dataModel.get( vue.listAlbums.getSelectedIndex() );

			ImageIcon imageIcon;
			Image image, nouvelleImage;

			try {
				imageIcon = new ImageIcon( chemin + "\\images\\albums\\" + albumTemp.getImageCouverture() );
				image = imageIcon.getImage();
				nouvelleImage = image.getScaledInstance( 140, 140, Image.SCALE_SMOOTH );
				imageIcon = new ImageIcon( nouvelleImage );
				vue.labelImageAlbum.setIcon( imageIcon );

			} catch ( Exception e ) {
				imageIcon = new ImageIcon( chemin + "\\images\\albums\\defaut.png" );
				image = imageIcon.getImage();
				nouvelleImage = image.getScaledInstance( 140, 140, Image.SCALE_SMOOTH );
				imageIcon = new ImageIcon( nouvelleImage );
				vue.labelImageAlbum.setIcon( imageIcon );
			}
		} else {
			vue.labelImageAlbum.setIcon( null );
		}
	}

<<<<<<< Upstream, based on origin/master
	public ModeleTable rechercherArtiste(ModeleTable modele) {
=======
	public ModeleTable rechercherArtiste( ModeleTable modele ) {
>>>>>>> b1781ca Ajustement de fonction et d'affichage.

		String nom = vue.textRechercheArtiste.getText();

<<<<<<< Upstream, based on origin/master
		modele.setRowCount(0);
=======
		modele.setRowCount( 0 );
>>>>>>> b1781ca Ajustement de fonction et d'affichage.
		modele.fireTableDataChanged();

<<<<<<< Upstream, based on origin/master
		if (connexion != null) {

			try {

				statement = connexion.createStatement();

				ResultSet rs = statement.executeQuery("SELECT * FROM artistes ");

				while (rs.next()) {
					if (rs.getString("nom").contains(nom)) {

						modele.addRow(new Artistes(rs.getString("ArtisteID"), rs.getString("nom"),
								rs.getBoolean("Membre"), rs.getString("Photo")));

					}
				}

				rs.close();
				statement.close();

			} catch (SQLException se) {
				System.out.println(se.getMessage());
=======
		if ( connexion != null ) {

			try {

				statement = connexion.createStatement();

				ResultSet rs = statement.executeQuery( "SELECT * FROM artistes " );

				while ( rs.next() ) {
					if ( rs.getString( "nom" ).contains( nom ) ) {

						modele.addRow( new Artistes( rs.getString( "ArtisteID" ), rs.getString( "nom" ),
								rs.getBoolean( "Membre" ), rs.getString( "Photo" ) ) );

					}
				}

				rs.close();
				statement.close();

			} catch ( SQLException se ) {
				System.out.println( se.getMessage() );
>>>>>>> b1781ca Ajustement de fonction et d'affichage.

			}
		}

		return modele;

	}

}
