package jepm.examen.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import jepm.examen.model.Continente;
import jepm.examen.model.Marca;
import jepm.examen.model.Pais;

public class PaisController {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamenFinal");
	private static PaisController instance = null;
	
		
		/**
		 * 
		 * @return
		 */
		public static PaisController getInstance() {
			if (instance == null) {
				instance = new PaisController();
			}
			return instance;
		}
		
		/**
		 * 
		 * @param string
		 */
		public static List<Pais> findbyId(int idContinente) {
			EntityManager em = entityManagerFactory.createEntityManager();
			List<Pais> paises = new ArrayList<Pais>();
					
			Query q = em.createNativeQuery("SELECT * FROM pais where idContinente = ?", Pais.class);
	
			q.setParameter(1, idContinente);
	
			
			try {
				paises = (List<Pais>) q.getResultList();
			} catch (Exception e) {
				paises = null;
			}
			em.close();		
			return paises;
			
		}


}
