package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class VueTraitement {

	private JFrame frmChoix;

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {
		EventQueue.invokeLater( new Runnable() {
			public void run() {
				try {
					VueTraitement window = new VueTraitement();
					window.frmChoix.setVisible( true );
				} catch ( Exception e ) {
					e.printStackTrace();
				}
			}
		} );
	}

	/**
	 * Create the application.
	 */
	public VueTraitement() {
		initialize();
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
		
		JButton btnArtiste = new JButton("G\u00E9rer artistes");
		btnArtiste.setBounds(25, 36, 120, 23);
		frmChoix.getContentPane().add(btnArtiste);
		
		JButton btnAlbums = new JButton("G\u00E9rer albums");
		btnAlbums.setBounds(169, 36, 120, 23);
		frmChoix.getContentPane().add(btnAlbums);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(106, 63, 99, 23);
		frmChoix.getContentPane().add(btnQuitter);
	}
}