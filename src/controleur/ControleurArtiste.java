package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modele.Artistes;
import modele.ModeleArtiste;
import modele.ModeleTable;
import vue.VueGestionArtiste;

public class ControleurArtiste implements ActionListener, MouseListener, ListSelectionListener{

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
		modeleTable = new ModeleTable( donnees );
		table = new JTable(modeleTable);
			
		modele.fermerBD();
		
		return table;

	}
	public void actionPerformed(ActionEvent e) {
		
		modele.connectionBD();

		
		if(e.getSource() == vueArtiste.btnNouveau) {
			
			modele.activerEtVider();
			vueArtiste.btnAjouter.setEnabled(true);
			
		} else if(e.getSource() == vueArtiste.btnAjouter) {
			
			modele.insererArtiste();
			modele.refreshTable(modeleTable);
			vueArtiste.btnAjouter.setEnabled(false);
			modele.desactiverEtVider();
			
		} else if (e.getSource() == vueArtiste.getBtnModifier()) {			
			modele.modifierArtiste( modeleTable );
			modele.refreshTable( modeleTable );
			vueArtiste.btnModifier.setEnabled(false);

			
		}else if (e.getSource() == vueArtiste.getBtnRemplacer()){
		
			
			
		} else if (e.getSource() == vueArtiste.getBtnSupprimer()) {
			
			modele.supprimerArtiste( modeleTable );
			modele.refreshTable( modeleTable );
			
		} 
		
		modele.fermerBD();

		
	}
	


	//@Override
	public void mouseClicked( MouseEvent e ) {
		
		if (e.getClickCount() == 1) {
		modele.afficherInfoArtiste( modeleTable );
		modele.connectionBD();
		modele.afficherAlbum(modeleTable);
		modele.fermerBD();
		
		}else if (e.getClickCount() == 2) {
			modele.activerModification();
		}
	}

	//@Override
	public void mouseEntered( MouseEvent e ) {
		
	}

	//@Override
	public void mouseExited( MouseEvent e ) {
		
	}

	//@Override
	public void mousePressed( MouseEvent e ) {
		
	}

	//@Override
	public void mouseReleased( MouseEvent e ) {
		
		
	}

	//@Override
	public void valueChanged( ListSelectionEvent arg0 ) {
		
		modele.afficherImageAlbum();
		
	}
	
	
	
}
