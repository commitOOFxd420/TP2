package modele;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import vue.VueTraitement;
import vue.vueLogin;

public class ModeleLogin {

	private String usernameValide = "bob";
	private String mdpValide = "123";
	private String chemin = System.getProperty( "user.dir" );

	public void validerLogin( String username, String mdp, vueLogin vue ) {

		if ( username.equals( usernameValide ) && mdp.equals( mdpValide ) ) {
			// Afficher le frame gestion Artistes.
			VueTraitement traitement = new VueTraitement();
			vue.getFrame().setVisible( false );
			traitement.getFrame().setVisible( true );
		} else {
			JOptionPane.showMessageDialog( null,
					"Mot de passe incorrecte ! \nPour les biens du test\nL'utilisateur est : " + usernameValide
							+ " \n Le mot de passe est : " + mdpValide );
		}

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
