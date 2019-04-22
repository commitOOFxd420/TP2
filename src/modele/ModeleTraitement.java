package modele;

import vue.VueGestionArtiste;
import vue.VueTraitement;

public class ModeleTraitement {
VueTraitement vue;
	
	public ModeleTraitement (VueTraitement vue) {
		this.vue = vue;
	}
	public void ouvrirArtiste() {
		VueGestionArtiste vueArtiste = new VueGestionArtiste();
		vue.getFrame().setVisible( false );
		vueArtiste.getFrame().setVisible( true );
		
	}
	
	public void ouvrirAlbums(){
		
	}
	
	public void quitter() {
		System.exit( 1 );
	}
	

	
}
