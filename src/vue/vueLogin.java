package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import java.awt.Insets;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JTextField;

import controleur.ControleurLogin;

public class vueLogin {

	private JFrame frmGestionDesAlbums;
	private JPanel panel;
	private JButton btnQuitter;
	private JButton btnValider;
	private JLabel lblMotDePasse;
	private JLabel lblNewLabel;
	private JLabel lblConnexionLapplication;
	private JTextField textFieldUser;
	private JTextField textFieldMdp;
	private ControleurLogin controleur = new ControleurLogin(this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vueLogin window = new vueLogin();
					window.frmGestionDesAlbums.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public vueLogin() {
		initialize();
	}
	public JFrame getFrame() {
		return this.frmGestionDesAlbums;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDesAlbums = new JFrame();
		frmGestionDesAlbums.setTitle("Gestion des Albums");
		frmGestionDesAlbums.setBounds(100, 100, 346, 253);
		frmGestionDesAlbums.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDesAlbums.getContentPane().add(getPanel(), BorderLayout.CENTER);
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblConnexionLapplication());
			panel.add(getLblNewLabel());
			panel.add(getLblMotDePasse());
			panel.add(getBtnQuitter());
			panel.add(getBtnValider());
			panel.add(getTextFieldUser());
			panel.add(getTextFieldMdp());
			
			
		}
		return panel;
	}
	public JButton getBtnQuitter() {
		if (btnQuitter == null) {
			btnQuitter = new JButton("Quitter");
			btnQuitter.addActionListener(controleur);
			btnQuitter.setBounds(156, 148, 89, 23);
		}
		return btnQuitter;
	}
	public JButton getBtnValider() {
		if (btnValider == null) {
			btnValider = new JButton("Valider");
			btnValider.addActionListener(controleur);
			btnValider.setBounds(57, 148, 89, 23);
		}
		return btnValider;
	}
	private JLabel getLblMotDePasse() {
		if (lblMotDePasse == null) {
			lblMotDePasse = new JLabel("Mot de passe");
			lblMotDePasse.setBounds(56, 106, 64, 14);
		}
		return lblMotDePasse;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Nom d'utilisateur");
			lblNewLabel.setBounds(57, 69, 79, 14);
		}
		return lblNewLabel;
	}
	private JLabel getLblConnexionLapplication() {
		if (lblConnexionLapplication == null) {
			lblConnexionLapplication = new JLabel("Connexion \u00E0 l'application");
			lblConnexionLapplication.setBounds(27, 26, 176, 20);
			lblConnexionLapplication.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblConnexionLapplication;
	}
	public JTextField getTextFieldUser() {
		if (textFieldUser == null) {
			textFieldUser = new JTextField();
			textFieldUser.setBounds(148, 66, 122, 20);
			textFieldUser.setColumns(10);
		}
		return textFieldUser;
	}
	public  JTextField getTextFieldMdp() {
		if (textFieldMdp == null) {
			textFieldMdp = new JTextField();
			textFieldMdp.setColumns(10);
			textFieldMdp.setBounds(148, 103, 122, 20);
		}
		return textFieldMdp;
	}
}
