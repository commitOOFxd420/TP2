package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modele.ModeleLogin;
import vue.vueLogin;

public class ControleurLogin implements ActionListener {

	vueLogin vue;
	ModeleLogin modele;
	
	public ControleurLogin(vueLogin vue){
		this.vue = vue;
		modele = new ModeleLogin();
	}
	
	

	public void actionPerformed(ActionEvent e) {
		

		if (e.getSource() == vue.getBtnValider()) {
			modele.validerLogin(vue.getTextFieldUser().getText(), vue.getTextFieldMdp().getText(), vue);
		} else if (e.getSource() == vue.getBtnQuitter()) {
			modele.quitter();
		}

	}

}
