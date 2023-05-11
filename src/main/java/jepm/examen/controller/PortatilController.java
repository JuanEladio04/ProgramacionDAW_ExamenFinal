package jepm.examen.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JPanel;

import jepm.examen.model.Marca;
import jepm.examen.model.Portatil;



public class PortatilController {
	
	private static PortatilController instance = null;
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamenFinal");

	
	/**
	 * 
	 * @return
	 */
	public static PortatilController getInstance() {
		if (instance == null) {
			instance = new PortatilController();
		}
		return instance;
	}
	
	/**
	 * 
	 * @return
	 */
	public static List<Portatil> findAll() {
		EntityManager em = entityManagerFactory.createEntityManager();
	    TypedQuery<Portatil> query = em.createNamedQuery("Portatil.findAll", Portatil.class);
	    return query.getResultList();
	}
	
	
	/**
	 * 
	 * @param p
	 */
	public static void realizeDelete (Portatil p) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		p = em.merge(p);	
		em.remove(p);
		em.getTransaction().commit();
	}
	
	
	/**
	 * 
	 * @param p
	 */
	public static void realizeInsert (Portatil p) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	
	
	/**
	 * 
	 */
	public static void realizeUpdate (Portatil p) {

		EntityManager em = entityManagerFactory.createEntityManager();		
		
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		em.close();
	}
	
	
}
