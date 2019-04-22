package modele;

public class Artistes {

	private String num;
	private String nom;
	boolean membre;
	
	public Artistes() {
		
	}
	
	public Artistes(String pNum, String pNom, boolean pMembre) {
		
		num = pNum;
		nom = pNom;
		membre = pMembre;
	}
	
	public String getNum(){
		return num;
	}
	
	public String getNom(){
		return nom;
	}
	
	public boolean getMembre(){
		return membre;
	}
	
	public void setNum(String pNum) {
		num = pNum;
	}
	
	public void setNom(String pNom) {
		num = pNom;
	}
	
	public void setMembre(String pMembre) {
		num = pMembre;
	}
	
	@Override
	public String toString() {
		return "Numéros : " + num + "\nNom : " + nom + "\nMembre :" + membre;
	}
}
