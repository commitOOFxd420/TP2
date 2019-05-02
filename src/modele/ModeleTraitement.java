package modele;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import vue.VueGestionArtiste;
import vue.VueTraitement;

public class ModeleTraitement {
	private VueTraitement vue;
	private String chemin = System.getProperty( "user.dir" );

	public ModeleTraitement( VueTraitement vue ) {
		this.vue = vue;
	}

	public void ouvrirArtiste() {
		VueGestionArtiste vueArtiste = new VueGestionArtiste();
		vue.getFrame().setVisible( false );
		vueArtiste.getFrame().setVisible( true );

	}

	public void ouvrirAlbums() {

	}

	public void quitter() {
		System.exit( 1 );
	}

	public void ouvrirAide() {

		String cheminAide = chemin + "\\aideEnLigne\\index.chm";
		try {
			File fileFichier = new File( cheminAide );
			if ( fileFichier.exists() )
				Desktop.getDesktop().open( fileFichier );
		} catch ( IOException e ) {
			System.out.println( e.getMessage() );
		}

	}

}
