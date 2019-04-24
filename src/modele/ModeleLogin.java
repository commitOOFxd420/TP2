package modele;

import javax.swing.JOptionPane;

import vue.VueTraitement;
import vue.vueLogin;

public class ModeleLogin {

	
	String usernameValide = "bob";
	String mdpValide = "123";
	
	public void validerLogin(String username, String mdp, vueLogin vue){
		
		if(username.equals(usernameValide) && mdp.equals(mdpValide)){
			// Afficher le frame gestion Artistes.
			VueTraitement traitement = new VueTraitement();
			vue.getFrame().setVisible( false );
			traitement.getFrame().setVisible( true );
		} else {
			JOptionPane.showMessageDialog( null, "Mot de passe incorrecte ! \nPour les biens du test\nL'utilisateur est : " 
					+ usernameValide + " \n Le mot de passe est : " + mdpValide );
		}
		
	}

	public void quitter(){
		System.exit( 1 );
	}
}
