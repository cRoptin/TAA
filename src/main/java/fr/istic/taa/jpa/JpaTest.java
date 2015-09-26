package fr.istic.taa.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import fr.istic.taa.domain.Company;
import fr.istic.taa.domain.Department;
import fr.istic.taa.domain.Employee;
import fr.istic.taa.domain.Material;

public class JpaTest {
	
	private EntityManager manager;

	private Department createNewDepartment() {
		Department dep = new Department();
		dep.setName("RD");
		manager.persist(dep);
		return dep;
	}
	
	private Company createNewCompany() {
		Company comp = new Company();
		comp.setName("Toto matério");
		comp.setSiren("894738947");
		manager.persist(comp);
		return comp;
	}
	
	private List<Material> createNewMaterial(Employee poBorrower, String matName) {
		Material mat = new Material();
		mat.setNameMaterial(matName);
		List<Employee> loBorrowers = new ArrayList<Employee>();
		loBorrowers.add(poBorrower);
		mat.setLoEmprunteur(loBorrowers);
		manager.persist(mat);
		List<Material> loMaterials = new ArrayList<Material>();
		loMaterials.add(mat);
		return loMaterials;
	}

	private void createNewEmployee() {
		Employee emp = new Employee();
		emp.setName("Durant");
		emp.setDepartment(createNewDepartment());
		emp.setCompany(createNewCompany());
		emp.setLoMaterial(createNewMaterial(emp, "MAT3"));
		manager.persist(emp);
		Employee empD = new Employee();
		empD.setName("Dupond");
		empD.setDepartment(createNewDepartment());
		empD.setCompany(createNewCompany());
		empD.setLoMaterial(createNewMaterial(empD, "MAT2"));
		manager.persist(empD);
	}
	
	private void removeEmployee() {
		List<Employee> existEmployee = manager.createQuery("Select a From Employee a", Employee.class).getResultList();
		if (existEmployee != null && existEmployee.size() > 0) {
			for (Employee emp : existEmployee) {
				if ("Dupond".equals(emp.getName())) {
					manager.remove(emp);
				}
			}
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<Department> listDepByEmployee() {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery query = criteriaBuilder.createQuery(Department.class);
		Root from = query.from(Employee.class);
		query.select(from.get("department")).where(from.get("name").in("Dupond"));
		
		List<Department> critDep = manager.createQuery(query).getResultList(); 
		
		return critDep;
	}
	
	public JpaTest(EntityManager manager) {
        this.manager = manager;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createNewEmployee();
			
			test.removeEmployee();
			
			List<Department> loDep = test.listDepByEmployee();
			if (loDep != null && loDep.size() > 0) {
				for (Department dep : loDep) {
					System.out.println(dep.getName());
				}
			} else {
				System.err.println("No department found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		manager.close();
		factory.close();
	}

}
