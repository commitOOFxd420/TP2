package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modele.ModeleLogin;
import vue.vueLogin;

public class ControleurLogin implements ActionListener {

	vueLogin vue;
	
	public ControleurLogin(vueLogin vue){
		this.vue = vue;
	}
	
	

	public void actionPerformed(ActionEvent e) {
		
		ModeleLogin modele = new ModeleLogin();

		if (e.getSource() == vue.getBtnValider()) {
			modele.validerLogin(vue.getTextFieldUser().getText(), vue.getTextFieldMdp().getText());
		} else if (e.getSource() == vue.getBtnQuitter()) {
			modele.quitter();
		}

	}

}
