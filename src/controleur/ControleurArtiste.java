package controleur;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import modele.Artistes;
import modele.ModeleArtiste;
import modele.ModeleTable;
import vue.VueGestionArtiste;

public class ControleurArtiste implements ActionListener, MouseListener{

	VueGestionArtiste vueArtiste;
	ModeleArtiste modele;
	ModeleTable modeleTable;
	
	public ControleurArtiste (VueGestionArtiste artiste) {
		
		this.vueArtiste = artiste;
		modele = new ModeleArtiste(artiste);
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
			modele.activerEtVider();
		} else if(e.getSource() == vueArtiste.btnAjouter) {
			modele.connectionBD();
			modele.insererArtiste();
			modele.fermerBD();
		}
		
		
	}

	@Override
	public void mouseClicked( MouseEvent e ) {
		if (e.getClickCount() == 1)
		modele.afficherInfoArtiste( modeleTable );
		else if (e.getClickCount() == 2)
			modele.modifierInfoArtiste(modeleTable);
	}

	@Override
	public void mouseEntered( MouseEvent e ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited( MouseEvent e ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed( MouseEvent e ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased( MouseEvent e ) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
