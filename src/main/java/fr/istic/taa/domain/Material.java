package fr.istic.taa.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Material {

	/**
	 * Material Id
	 */
	private long idMaterial;
	/**
	 * Material name
	 */
	private String nameMaterial;
	/**
	 * Material borrowers
	 */
	private List<Employee> loEmprunteur;
	
	public Material() {
		
	}

	/**
	 * @return the idMaterial
	 */
	@Id
	@GeneratedValue
	public long getIdMaterial() {
		return idMaterial;
	}

	/**
	 * @param idMaterial the idMaterial to set
	 */
	public void setIdMaterial(long idMaterial) {
		this.idMaterial = idMaterial;
	}

	/**
	 * @return the nameMaterial
	 */
	public String getNameMaterial() {
		return nameMaterial;
	}

	/**
	 * @param nameMaterial the nameMaterial to set
	 */
	public void setNameMaterial(String nameMaterial) {
		this.nameMaterial = nameMaterial;
	}

	/**
	 * @return the loEmprunteur
	 */
	@ManyToMany(mappedBy = "loMaterial")
	public List<Employee> getLoEmprunteur() {
		return loEmprunteur;
	}

	/**
	 * @param loEmprunteur the loEmprunteur to set
	 */
	public void setLoEmprunteur(List<Employee> loEmprunteur) {
		this.loEmprunteur = loEmprunteur;
	}
}
