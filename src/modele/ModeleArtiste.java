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

			Class.forName("org.sqlite.JDBC");
			connexion = DriverManager.getConnection("jdbc:sqlite:sqlite//db//Ouellette-Valiquette-Albums.db");

		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}
	}

	public ArrayList<Artistes> obtenirContenuTable() {

		ArrayList<Artistes> donnees = new ArrayList<Artistes>();
		if (connexion != null) {
			try {

				statement = connexion.createStatement();

				ResultSet jeuResultats = statement.executeQuery("SELECT * FROM artistes ");

				while (jeuResultats.next()) {
					donnees.add(new Artistes(jeuResultats.getString("ArtisteID"), jeuResultats.getString("nom"),
							jeuResultats.getBoolean("Membre"), jeuResultats.getString("Photo")));

				}

			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}

		}
		return donnees;
	}

	public void fermerBD() {
		try {
			if (connexion != null) {

				connexion.close();
			}
		} catch (SQLException se) {
			System.out.println("Erreur lors de la fermeture de la base de donné");
		}
	}

	public void activerEtVider() {

		int rc = 0;
		
		try {
			if (connexion != null) {

				statement = connexion.createStatement();

				ResultSet result = statement.executeQuery("SELECT artisteId from artistes");
				
				while(result.next()) {
					rc++;
				}

				vue.textNom.setEditable(true);
				vue.textNom.setText("");
				vue.checkMembre.setSelected(false);
				vue.textNum.setText("" +(rc+1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void desactiverEtVider() {
		
		vue.textNom.setEditable(false);
		vue.textNom.setText("");
		vue.checkMembre.setSelected(false);
		vue.textNum.setText("");
	}

	public void insererArtiste() {

		if (vue.textNom.isEditable()) {
			String nom = vue.textNom.getText();
			boolean membre = vue.checkMembre.isSelected();

			if (connexion != null) {
				try {
					String sql = ("INSERT INTO artistes (nom, Membre, Photo) VALUES (?, ?, ?)");
					System.out.println("INSERT INTO artistes (nom, Membre, Photo) VALUES (?, ?, ?)");
					
					PreparedStatement prt = connexion.prepareStatement(sql);
					prt.setString(1, nom);
					System.out.println("1");
					prt.setBoolean(2, membre);
					prt.setString(3, "defaut.png");
					prt.executeUpdate();
					
					
				} catch (SQLException se) {
					System.out.println(se.getMessage());
				}
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

	public void afficherImageAlbum() {
		if (!vue.listAlbums.isSelectionEmpty()) {
			Albums albumTemp = vue.dataModel.get(vue.listAlbums.getSelectedIndex());

			ImageIcon imageIcon;
			Image image, nouvelleImage;

			try {
				imageIcon = new ImageIcon(chemin + "\\images\\albums\\" + albumTemp.getImageCouverture());
				image = imageIcon.getImage();
				nouvelleImage = image.getScaledInstance(140, 140, Image.SCALE_SMOOTH);
				imageIcon = new ImageIcon(nouvelleImage);
				vue.labelImageAlbum.setIcon(imageIcon);

			} catch (Exception e) {
				imageIcon = new ImageIcon(chemin + "\\images\\albums\\defaut.png");
				image = imageIcon.getImage();
				nouvelleImage = image.getScaledInstance(140, 140, Image.SCALE_SMOOTH);
				imageIcon = new ImageIcon(nouvelleImage);
				vue.labelImageAlbum.setIcon(imageIcon);
			}
		} else {
			vue.labelImageAlbum.setIcon(null);
		}
	}

	public void modifierInfoArtiste(ModeleTable modelTable) {

	}
	
	public void refreshTable(ModeleTable modeleTable) {
		ArrayList<Artistes> donnees = this.obtenirContenuTable();

		modeleTable = new ModeleTable( donnees );
		
		vue.getTableau().setModel(modeleTable);
		vue.getTableau().getColumnModel().getColumn(0).setMinWidth(25);
		vue.getTableau().getColumnModel().getColumn(0).setMaxWidth(25);

		vue.getTableau().getColumnModel().getColumn(2).setMinWidth(27);
		vue.getTableau().getColumnModel().getColumn(2).setMaxWidth(50);
	}

}
