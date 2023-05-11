package jepm.examen.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import jepm.examen.model.Continente;
import jepm.examen.model.Portatil;

public class ContinenteController {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamenFinal");
	private static ContinenteController instance = null;

		
		/**
		 * 
		 * @return
		 */
		public static ContinenteController getInstance() {
			if (instance == null) {
				instance = new ContinenteController();
			}
			return instance;
		}
		
		/**
		 * 
		 * @return
		 */
		public static List<Continente> findAll() {
			EntityManager em = entityManagerFactory.createEntityManager();
		    TypedQuery<Continente> query = em.createNamedQuery("Continente.findAll", Continente.class);
		    return query.getResultList();
		}	

}
