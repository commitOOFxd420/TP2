package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modele.Artistes;
import modele.ModeleArtiste;
import modele.ModeleTable;
import vue.CellsRenderer;
import vue.VueGestionArtiste;
import vue.VueTraitement;

public class ControleurArtiste implements ActionListener, MouseListener, ListSelectionListener {

	VueGestionArtiste vueArtiste;
	ModeleArtiste modele;
	ModeleTable modeleTable;

	public ControleurArtiste( VueGestionArtiste artiste ) {

		this.vueArtiste = artiste;
		modele = new ModeleArtiste( artiste );
	}

	public JTable initialiserTableau( JTable table ) {

		modele.connectionBD();
		ArrayList<Artistes> donnees = modele.obtenirContenuTable();
		modeleTable = new ModeleTable( donnees );
		table = new JTable( modeleTable );

		modele.fermerBD();

		return table;

	}

	public void actionPerformed( ActionEvent e ) {

		modele.connectionBD();

		if ( e.getSource() == vueArtiste.btnNouveau ) {

			modele.activerEtVider( modeleTable );
			vueArtiste.btnAjouter.setEnabled( true );

		} else if ( e.getSource() == vueArtiste.btnAjouter ) {
			modeleTable = modele.insererArtiste( modeleTable );
			vueArtiste.getTableau().setModel( modeleTable );
			modeleTable = modele.refreshTable( modeleTable );
			vueArtiste.btnAjouter.setEnabled( false );

		} else if ( e.getSource() == vueArtiste.getBtnModifier() ) {

			modele.modifierArtiste( modeleTable );
			modeleTable = modele.refreshTable( modeleTable );
			vueArtiste.getTableau().setModel( modeleTable );
			vueArtiste.btnModifier.setEnabled( false );

		} else if ( e.getSource() == vueArtiste.getBtnRemplacer() ) {
			if ( vueArtiste.getTableau().getSelectedRow() != -1 ) {

				modele.remplacerImageArtiste( modeleTable );
				modeleTable = modele.refreshTable( modeleTable );
				vueArtiste.getTableau().setModel( modeleTable );

			}

		} else if ( e.getSource() == vueArtiste.getBtnSupprimer() ) {
			if ( vueArtiste.getTableau().getSelectedRow() != -1 ) {
				modeleTable = modele.supprimerArtiste( modeleTable );
				modeleTable = modele.refreshTable( modeleTable );
				vueArtiste.getTableau().setModel( modeleTable );
			}
		} else if ( e.getSource() == vueArtiste.getBtnRecherche() ) {
			modeleTable = modele.rechercherArtiste( modeleTable );
			vueArtiste.getTableau().setModel( modeleTable );
			vueArtiste.getTableau().getColumnModel().getColumn( 0 ).setCellRenderer( new CellsRenderer() );

			vueArtiste.getTableau().getColumnModel().getColumn( 0 ).setMinWidth( 25 );
			vueArtiste.getTableau().getColumnModel().getColumn( 0 ).setMaxWidth( 25 );

			vueArtiste.getTableau().getColumnModel().getColumn( 2 ).setMinWidth( 27 );
			vueArtiste.getTableau().getColumnModel().getColumn( 2 ).setMaxWidth( 50 );

		} else if ( e.getSource() == vueArtiste.btnQuitter ) {

			int n = JOptionPane.showConfirmDialog( vueArtiste.getFrame(),
					"Vous allez revenir � la fen�tre pr�c�dente. Continuez ?", "Retour", JOptionPane.YES_NO_OPTION );

			if ( n == JOptionPane.YES_OPTION ) {
				VueTraitement traitement = new VueTraitement();
				traitement.getFrame().setVisible( true );
				vueArtiste.getFrame().setVisible( false );
			}

		} else if ( e.getSource() == vueArtiste.getMenuItem() ) {

			modele.ouvrirAide();

		}

		modele.fermerBD();

	}

	// @Override
	public void mouseClicked( MouseEvent e ) {

		if ( e.getClickCount() == 1 ) {
			modele.afficherInfoArtiste( modeleTable );
			modele.connectionBD();
			modele.afficherAlbum( modeleTable );
			modele.fermerBD();

		} else if ( e.getClickCount() == 2 ) {
			modele.activerModification();
		}
	}

	// @Override
	public void mouseEntered( MouseEvent e ) {

	}

	// @Override
	public void mouseExited( MouseEvent e ) {

	}

	// @Override
	public void mousePressed( MouseEvent e ) {

	}

	// @Override
	public void mouseReleased( MouseEvent e ) {

	}

	// @Override
	public void valueChanged( ListSelectionEvent arg0 ) {

		modele.afficherImageAlbum();

	}

}
