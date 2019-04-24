package modele;

public class Albums {

	int albumID;
	String titre;
	String genre;
	String anneeSortie;
	String imageCouverture;
	int artisteID;
	
	public Albums (	int albumID,String Titre,String Genre,String AnneeSortie,String ImageCouverture,int artisteID) {
		
		this.albumID = albumID;
		this.titre = Titre;
		this.genre = Genre;
		this.anneeSortie = AnneeSortie;
		this.imageCouverture = ImageCouverture;
		this.artisteID = artisteID;
	}
	
	public int getAlbumID() {
		return albumID;
	}
	
	public int getArtisteID() {
		return artisteID;
	}
	
	public String getTitre() {
		return titre;
	}
	
	public String getGenre() {
		return genre;
	}
	public String getAnneeSortie() {
		return anneeSortie;
	}
	public String getImageCouverture() {
		return imageCouverture;
	}
	
	public void setArtisteID(int artisteID) {
		this.artisteID = artisteID;
	}
	
	public void setTitre(String titre) {
		
		this.titre = titre;
	}
	
	public void setGenre(String genre) {
		
		this.genre = genre;
	}

	public void setAnneeSortie(String anneeSortie) {
		
		this.anneeSortie = anneeSortie;
	}
	
	public void setImageCouverture(String imageCouverture) {
		
		this.imageCouverture = imageCouverture;
	}

	@Override
	public String toString() {
		return anneeSortie + " - " + titre;
	}
}
