package fr.istic.taa.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.taa.domain.Employee;

public class EmployeeRepository {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
    EntityManager manager = factory.createEntityManager();

    public List<Employee> findAll() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<Employee> employees = new ArrayList<Employee>();
        try {
        	employees = manager.createQuery("SELECT emp from employee emp", Employee.class).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();
        manager.close();
        factory.close();

        return employees;
    }
}
