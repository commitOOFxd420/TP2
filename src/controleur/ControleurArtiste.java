package controleur;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import modele.Artistes;
import modele.ModeleArtiste;
import modele.ModeleTable;
import vue.VueGestionArtiste;

public class ControleurArtiste implements ActionListener{

	VueGestionArtiste vueArtiste;
	ModeleArtiste modele;
	ModeleTable modeleTable;
	
	public ControleurArtiste (VueGestionArtiste artiste) {
		
		this.vueArtiste = artiste;
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
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == vueArtiste.btnNouveau) {
			modele.activerEtVider(vueArtiste);
		} else if(e.getSource() == vueArtiste.btnAjouter) {
			modele.insererArtiste(vueArtiste);
		}
		
		
	}
	
	
	
}
