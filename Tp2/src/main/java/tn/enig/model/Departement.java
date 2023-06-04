package tn.enig.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Departement {
	@Id
	@GeneratedValue
	private Integer idd;
	private String titre;
	
	
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Departement(Integer idd, String titre) {
		super();
		this.idd = idd;
		this.titre = titre;
	}
	
	public Integer getIdd() {
		return idd;
	}
	public void setIdd(Integer idd) {
		this.idd = idd;
	}
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	

}
