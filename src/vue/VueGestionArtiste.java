package vue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;

import controleur.ControleurArtiste;
import modele.Albums;

import javax.swing.JScrollPane;

public class VueGestionArtiste {

	private JFrame frmGestionsDesArtistes;
	private JTextField textRechercheArtiste;
	public JTextField textNum;
	public JTextField textNom;
	private JTable table;
	private ControleurArtiste controleur;
	private JScrollPane scrollPane;
	public JButton btnAjouter;
	public JButton btnNouveau;
	public JCheckBox checkMembre = new JCheckBox("");
	public JLabel labelImageArtiste;
	public DefaultListModel<Albums> dataModel = new DefaultListModel<Albums>(); 
	public JList<Albums> listAlbums;
	public JLabel labelImageAlbum;
	

	/**
	 * Create the application.
	 */
	public VueGestionArtiste() {

		initialize();

	}
	
	public JFrame getFrame() {
		return this.frmGestionsDesArtistes;
	}
	
	public JTable getTableau() {
		return this.table;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		controleur = new ControleurArtiste(this);
		table = controleur.initialiserTableau(table);
		
		frmGestionsDesArtistes = new JFrame();
		frmGestionsDesArtistes.setTitle("Gestions des artistes");
		frmGestionsDesArtistes.setBounds( 100, 100, 550, 440 );
		frmGestionsDesArtistes.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		JPanel panel = new JPanel();
		frmGestionsDesArtistes.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblRechercherUnArtiste = new JLabel("Rechercher un artiste");
		lblRechercherUnArtiste.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblRechercherUnArtiste.setBounds(10, 11, 148, 14);
		panel.add(lblRechercherUnArtiste);
		
		textRechercheArtiste = new JTextField();
		textRechercheArtiste.setFont(new Font("Verdana", Font.PLAIN, 12));
		textRechercheArtiste.setBounds(10, 36, 265, 20);
		panel.add(textRechercheArtiste);
		textRechercheArtiste.setColumns(10);
		
		JButton btnRecherche = new JButton("Recherche");
		btnRecherche.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnRecherche.setBounds(285, 35, 102, 23);
		panel.add(btnRecherche);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnQuitter.setBounds(435, 35, 89, 23);
		panel.add(btnQuitter);
		
		JLabel lblArtistes = new JLabel("Artistes");
		lblArtistes.setFont(new Font("Verdana", Font.BOLD, 14));
		lblArtistes.setBounds(10, 84, 81, 14);
		panel.add(lblArtistes);
		
		JLabel lblInformations = new JLabel("Informations");
		lblInformations.setFont(new Font("Verdana", Font.BOLD, 14));
		lblInformations.setBounds(10, 273, 102, 14);
		panel.add(lblInformations);
		
		JLabel lblNumro = new JLabel("Num\u00E9ro");
		lblNumro.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNumro.setBounds(10, 298, 74, 14);
		panel.add(lblNumro);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNom.setBounds(10, 329, 74, 14);
		panel.add(lblNom);
		
		JLabel lblMembre = new JLabel("Membre");
		lblMembre.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblMembre.setBounds(10, 359, 74, 14);
		panel.add(lblMembre);
		
		textNum = new JTextField();
		textNum.setEditable(false);
		textNum.setFont(new Font("Verdana", Font.PLAIN, 12));
		textNum.setBounds(75, 296, 148, 20);
		panel.add(textNum);
		textNum.setColumns(10);
		
		textNom = new JTextField();
		textNom.setEditable(false);
		textNom.setFont(new Font("Verdana", Font.PLAIN, 12));
		textNom.setColumns(10);
		textNom.setBounds(75, 323, 148, 20);
		panel.add(textNom);
		
		
		checkMembre.setFocusable(false);
		checkMembre.setFont(new Font("Verdana", Font.PLAIN, 12));
		checkMembre.setBounds(75, 350, 97, 23);
		panel.add(checkMembre);
		
		listAlbums = new JList<Albums>(dataModel);
		listAlbums.addListSelectionListener( controleur );
		listAlbums.setFont(new Font("Verdana", Font.PLAIN, 12));
		listAlbums.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAlbums.setBounds(233, 298, 137, 79);
		panel.add(listAlbums);
		
		JButton btnRemplacer = new JButton("Remplacer");
		btnRemplacer.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnRemplacer.setBounds(2, 205, 110, 23);
		panel.add(btnRemplacer);
		
		btnNouveau = new JButton("Nouveau");
		btnNouveau.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnNouveau.setBounds(427, 105, 107, 23);
		btnNouveau.addActionListener(controleur);
		panel.add(btnNouveau);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnAjouter.setBounds(427, 139, 107, 23);
		btnAjouter.addActionListener(controleur);
		panel.add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnModifier.setBounds(427, 173, 107, 23);
		panel.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnSupprimer.setBounds(427, 207, 107, 23);
		panel.add(btnSupprimer);
		
		labelImageArtiste = new JLabel();
		labelImageArtiste.setFont(new Font("Verdana", Font.PLAIN, 12));
		labelImageArtiste.setBounds(5, 100, 110, 110);
		panel.add(labelImageArtiste);
		
		labelImageAlbum = new JLabel();
		labelImageAlbum.setFont(new Font("Verdana", Font.PLAIN, 12));
		labelImageAlbum.setBounds(385, 190, 300, 300);
		panel.add(labelImageAlbum);
		
		table.getColumnModel().getColumn(0).setMinWidth(25);
		table.getColumnModel().getColumn(0).setMaxWidth(25);

		table.getColumnModel().getColumn(2).setMinWidth(27);
		table.getColumnModel().getColumn(2).setMaxWidth(50);
		
		table.addMouseListener( controleur );
		scrollPane = new JScrollPane();
		scrollPane.setBounds(122, 69, 295, 202);

		panel.add(scrollPane);
		
		scrollPane.setViewportView(table);

	}
	
	public JButton getBtnNouveau() {
		return btnNouveau;
	}
	
	public JTextField getTextFieldNumero() {
		return textNum;
	}
	
	public JTextField getTextFieldNom() {
		return textNom;
	}
	
	public JCheckBox getcheckMembre() {
		return checkMembre;
	}
}
