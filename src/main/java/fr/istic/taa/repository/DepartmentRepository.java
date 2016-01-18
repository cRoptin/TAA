package fr.istic.taa.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.taa.domain.Department;

public class DepartmentRepository {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
    EntityManager manager = factory.createEntityManager();

    public List<Department> findAll() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<Department> departments = new ArrayList<Department>();
        try {
            departments = manager.createQuery("SELECT d from Department d", Department.class).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();
        manager.close();
        factory.close();

        return departments;
    }
    
    public Department findById(long plId) {
    	EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Department department = null;
        try {
            department = manager.createQuery("SELECT d from Department d where d.id="+plId, Department.class).getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();
        manager.close();
        factory.close();

        return department;
    }
}
