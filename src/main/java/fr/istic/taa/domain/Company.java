package fr.istic.taa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Company
 */
@Entity
public class Company {

	
	/**
	 * Company Id
	 */
	private long id;
	
	/**
	 * Company name
	 */
	private String name;
	
	/**
	 * Company SIREN
	 */
	private String siren;

	/**
	 * Default constructor
	 */
	public Company() {
		
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the siren
	 */
	public String getSiren() {
		return siren;
	}

	/**
	 * @param siren the siren to set
	 */
	public void setSiren(String siren) {
		this.siren = siren;
	}

	/**
	 * @return company name and compay SIREN
	 * @see java.lang.String#toString()
	 */
	public String toString() {
		return new StringBuffer(this.name).append(this.siren).toString();
	}
	
}
