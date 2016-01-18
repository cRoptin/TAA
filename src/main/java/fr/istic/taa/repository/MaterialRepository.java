package fr.istic.taa.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.taa.domain.Employee;
import fr.istic.taa.domain.Material;

public class MaterialRepository {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
    EntityManager manager = factory.createEntityManager();

    public List<Material> findAll() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<Material> materials = new ArrayList<Material>();
        try {
        	materials = manager.createQuery("SELECT mat from material mat", Material.class).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();
        manager.close();
        factory.close();

        return materials;
    }
}
