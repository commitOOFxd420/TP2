package modele;

public class ModeleLogin {

	
	String usernameValide = "bob";
	String mdpValide = "123";
	
	public void validerLogin(String username, String mdp){
		
		if(username.equals(usernameValide) && mdp.equals(mdpValide)){
			// Afficher le frame gestion Artistes.
		}
		
	}

	public void quitter(){
		System.exit(1);
	}
}
