package fr.istic.taa.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.taa.domain.Company;

public class CompanyRepository {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
    EntityManager manager = factory.createEntityManager();

    public List<Company> findAll() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<Company> companies = new ArrayList<Company>();
        try {
        	companies = manager.createQuery("SELECT comp from company comp", Company.class).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();
        manager.close();
        factory.close();

        return companies;
    }
}
