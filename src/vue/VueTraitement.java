package vue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controleur.ControleurTraitement;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class VueTraitement {

	private JFrame frmChoix;
	private JButton btnArtiste;
	private JButton btnAlbums;
	private JButton btnQuitter;
	private ControleurTraitement controleur = new ControleurTraitement(this);

	/**
	 * Create the application.
	 */
	public VueTraitement() {
		initialize();
		ImageIcon img = new ImageIcon(System.getProperty("user.dir") + "\\images\\logo.png");
		frmChoix.setIconImage( img.getImage() );
	}
	
	public JButton getBtnArtiste() {
		return btnArtiste;
	}
	
	public JButton getBtnAlbums() {
		return btnAlbums;
	}
	
	public JButton getBtnQuitter() {
		return btnQuitter;
	}
	
	public JFrame getFrame() {
		return this.frmChoix;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChoix = new JFrame();
		frmChoix.setTitle("Choix des traitements");
		frmChoix.setBounds( 100, 100, 330, 136 );
		frmChoix.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frmChoix.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Veuillez choisir le traitement \u00E0 effectuer");
		lblNewLabel.setBounds(42, 11, 242, 14);
		frmChoix.getContentPane().add(lblNewLabel);
		
		btnArtiste = new JButton("G\u00E9rer artistes");
		btnArtiste.setBounds(25, 36, 120, 23);
		btnArtiste.addActionListener( controleur );
		frmChoix.getContentPane().add(btnArtiste);
		
		
		btnAlbums = new JButton("G\u00E9rer albums");
		btnAlbums.setBounds(169, 36, 120, 23);
		btnAlbums.addActionListener( controleur );
		frmChoix.getContentPane().add(btnAlbums);
		
		btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener( controleur );
		btnQuitter.setBounds(106, 63, 99, 23);
		frmChoix.getContentPane().add(btnQuitter);
	}
}
