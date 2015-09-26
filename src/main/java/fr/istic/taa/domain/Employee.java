package fr.istic.taa.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	private Long id;

    private String name;

    private Department department;
    
    private Company company;
    
    private List<Material> loMaterial;

    public Employee() {
    }

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public Employee(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    
    /**
	 * @return the company
	 */
    @OneToOne
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}
	
	/**
	 * @return the loMaterial
	 */
	@ManyToMany
	@JoinTable(
		      name="BORROWERS",
		      joinColumns={@JoinColumn(table="EMPLOYEE", referencedColumnName="ID")},
		      inverseJoinColumns={@JoinColumn(table="MATERIAL", referencedColumnName="IDMATERIAL")}
		      )
	public List<Material> getLoMaterial() {
		return loMaterial;
	}

	/**
	 * @param loMaterial the loMaterial to set
	 */
	public void setLoMaterial(List<Material> loMaterial) {
		this.loMaterial = loMaterial;
	}

	@Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", department="
                + department.getName() + "]";
    }
}
