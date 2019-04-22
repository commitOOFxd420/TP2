package controleur;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import modele.Artistes;
import modele.ModeleArtiste;
import modele.ModeleTable;
import vue.VueGestionArtiste;

public class ControleurArtiste {

	VueGestionArtiste artiste;
	ModeleArtiste modele;
	ModeleTable modeleTable;
	
	public ControleurArtiste (VueGestionArtiste artiste) {
		
		this.artiste = artiste;
		modele = new ModeleArtiste();
	}
	
	public JTable initialiserTableau(JTable table) {
		
		modele.connectionBD();
		ArrayList<Artistes> donnees = modele.obtenirContenuTable();
		for ( Artistes artiste : donnees ) {
			artiste.toString();
		}
		modeleTable = new ModeleTable( donnees );
		table = new JTable(modeleTable);
		table.setFont(new Font("Verdana", Font.PLAIN, 12));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


		
		
		modele.fermerBD();
		
		return table;

	}
	
}
