package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.ModeleTraitement;
import vue.VueTraitement;

public class ControleurTraitement implements ActionListener{
	
	VueTraitement vue;
	ModeleTraitement modele;
	
	public ControleurTraitement(VueTraitement vue) {

		this.vue = vue;
		modele = new ModeleTraitement(vue);
		System.out.println( "ok?" );
	}
	
	@Override
	public void actionPerformed( ActionEvent e ) {
		if (e.getSource() ==vue.getBtnAlbums()) {
			modele.ouvrirAlbums();
		} else if (e.getSource() == vue.getBtnArtiste()) {
			modele.ouvrirArtiste();

		} else if (e.getSource() == vue.getBtnQuitter()) {
			modele.quitter();

		}
	}

}
