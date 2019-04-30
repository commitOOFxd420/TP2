package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modele.ModeleTraitement;
import vue.VueTraitement;
import vue.vueLogin;

public class ControleurTraitement implements ActionListener {

	VueTraitement vue;
	ModeleTraitement modele;

	public ControleurTraitement( VueTraitement vue ) {

		this.vue = vue;
		modele = new ModeleTraitement( vue );
	}

	// @Override
	public void actionPerformed( ActionEvent e ) {
		if ( e.getSource() == vue.getBtnAlbums() ) {
			modele.ouvrirAlbums();
		} else if ( e.getSource() == vue.getBtnArtiste() ) {
			modele.ouvrirArtiste();

		} else if ( e.getSource() == vue.getBtnQuitter() ) {
			int n = JOptionPane.showConfirmDialog( vue.getFrame(),
					"Vous allez revenir à la fenêtre précédente. Continuez ?", "Retour", JOptionPane.YES_NO_OPTION );

			if ( n == JOptionPane.YES_OPTION ) {
				vueLogin login = new vueLogin();
				login.getFrame().setVisible( true );
				vue.getFrame().setVisible( false );
			}
		}
	}

}
