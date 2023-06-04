package tn.enig.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Materiel {
	@Id
	@GeneratedValue
	private Integer id;
    private String titre;
    private String type;
    private int num;
    private int qte;
    private String etat;
    @ManyToOne
    @JoinColumn(name="dep_id")
    private Departement dep;
	public Materiel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public Materiel(Integer id, String titre, String type, int num, int qte, String etat, Departement dep) {
		super();
		this.id = id;
		this.titre = titre;
		this.type = type;
		this.num = num;
		this.qte = qte;
		this.etat = etat;
		this.dep = dep;
	}





	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getTitre() {
		return titre;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	
	public int getQte() {
		return qte;
	}
	
	public void setQte(int qte) {
		this.qte = qte;
	}
	
	
	public String getEtat() {
		return etat;
	}
	
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	
	public Departement getDep() {
		return dep;
	}
	
	public void setDep(Departement dep) {
		this.dep = dep;
	}
	
	
    
    
    
}
