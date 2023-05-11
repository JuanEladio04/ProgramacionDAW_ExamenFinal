package jepm.examen.controller;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import jepm.examen.model.Marca;

public class MarcaController {
	
	private static MarcaController instance = null;
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamenFinal");	


	
	/**
	 * 
	 * @return
	 */
	public static MarcaController getInstance() {
		if (instance == null) {
			instance = new MarcaController();
		}
		return instance;
	}
	
	/**
	 * 
	 * @return
	 */
	public static List<Marca> findAll() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamenFinal");	
		EntityManager em = entityManagerFactory.createEntityManager();
	    TypedQuery<Marca> query = em.createNamedQuery("Marca.findAll", Marca.class);
	    return query.getResultList();
	}
	
	
	/**
	 * 
	 * @param string
	 */
	public static List<Marca> findbyId(int idMarca) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamenFinal");	
		EntityManager em = entityManagerFactory.createEntityManager();
		List<Marca> m = new ArrayList<Marca>();
				
		Query q = em.createNativeQuery("SELECT * FROM marca where id = ?", Marca.class);

		q.setParameter(1, idMarca);

		
		try {
			m = (List<Marca>) q.getResultList();
		} catch (Exception e) {
			m = null;
		}
		em.close();		
		return m;
		
	}
	
	
	/**
	 * 
	 */
	public static void realizeUpdate (Marca m) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamenFinal");

		EntityManager em = entityManagerFactory.createEntityManager();		
		
		em.getTransaction().begin();
		em.merge(m);
		em.getTransaction().commit();
		em.close();
	}

}
