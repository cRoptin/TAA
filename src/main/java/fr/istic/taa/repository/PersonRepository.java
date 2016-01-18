package fr.istic.taa.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.taa.domain.Material;
import fr.istic.taa.domain.Person;

public class PersonRepository {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
    EntityManager manager = factory.createEntityManager();

    public List<Person> findAll() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<Person> persons = new ArrayList<Person>();
        try {
        	persons = manager.createQuery("SELECT pers from person pers", Person.class).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();
        manager.close();
        factory.close();

        return persons;
    }
}
