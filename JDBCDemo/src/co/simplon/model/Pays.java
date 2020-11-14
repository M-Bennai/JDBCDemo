package co.simplon.model;

public class Pays {

	 private int id;
	 private String nom;
	
	
	
	public Pays(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	
	public Pays() {
		super();
		
	}


	public String getNom() {
		return this.nom;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setNom( String nom ) {
		this.nom = nom;
	}
	
	public void setId (int id) {
		this.id = id;
	}

	
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	
}

