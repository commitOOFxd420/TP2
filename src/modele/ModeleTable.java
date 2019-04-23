package modele;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


public class ModeleTable extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Artistes> lesDonnees;
	
	private final String[] lesTitres = {"No", "Nom", "Membre"};

	public ModeleTable(ArrayList<Artistes> donnees) {
		lesDonnees = donnees;
	}
	
	//@Override
	public int getColumnCount() {
		return lesTitres.length;
	}

	//@Override
	public int getRowCount() {
		return lesDonnees.size();
	}

	//@Override
	public Object getValueAt( int rowIndex, int columnIndex ) {
		
		switch(columnIndex) {
		
		case 0:
			return lesDonnees.get(rowIndex).getNum();
		case 1:
			return lesDonnees.get(rowIndex).getNom();
		case 2:
			return lesDonnees.get(rowIndex).getMembre();

		default:
			return null;
		
		}
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return lesTitres[columnIndex];
	}
	
	@Override
	public Class<?> getColumnClass( int columnIndex ) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		case 0 :return String.class;
		case 1:return String.class;
		case 2:return Boolean.class;
		default:throw new IllegalArgumentException( "Index de colonne invalide :" + columnIndex );
		}
	}

}
