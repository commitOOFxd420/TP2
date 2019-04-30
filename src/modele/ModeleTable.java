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
		switch (columnIndex) {
		case 0 :return String.class;
		case 1:return String.class;
		case 2:return Boolean.class;
		default:throw new IllegalArgumentException( "Index de colonne invalide :" + columnIndex );
		}
	}
	
	public Artistes getArtiste(int row) {
		
		return lesDonnees.get( row );
	}
	
	public void setArtisteAt (int row, Artistes artiste) {
		
		lesDonnees.set( row, artiste );
		lesDonnees.remove( row +1 );
	}
	public void setRowCount(int nbDesiree) {

		for (int i = lesDonnees.size() ; nbDesiree < i ; i--) {
			
			lesDonnees.remove( i -1  );
			fireTableRowsDeleted( i, i );
			
		}
		
	}	
	
	public void deleteRow(int row) {
		lesDonnees.remove( row );
		fireTableRowsDeleted( row, row );
	}
	
	public void addRow(Artistes artiste) {
		lesDonnees.add( artiste );
		fireTableRowsInserted( 0, getRowCount() );
	}


}
