package ar.nasa.ifs.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class IfsRepository {

	private EntityManagerFactory sessionFactory;
	
	public IfsRepository() {
		sessionFactory = Persistence.createEntityManagerFactory("oracle.ifs");
//		sessionFactory = Persistence.createEntityManagerFactory("mysql.ifs");
	}
	
	public LverYPacc findLverYPaccBy(Long numOt) {
		
		EntityManager entityManager = sessionFactory.createEntityManager();
		
		OtActivaIfs ot = entityManager.createQuery("FROM OtActivaIfs o WHERE o.numOt = :n", OtActivaIfs.class)
				.setParameter("n", numOt)
				.getSingleResult();
		
		entityManager.close();
		
		return new LverYPacc(ot);
	}
	
	public Historial findHistorial(String comp) {
		
		EntityManager entityManager = sessionFactory.createEntityManager();
		
		List<OtIfsHistorica> ots = entityManager.createQuery("FROM OtIfsHistorica o WHERE o.componente LIKE :n AND o.orgMant LIKE 'C%' ORDER BY o.fechaFin DESC", OtIfsHistorica.class)
				.setParameter("n", comp.toUpperCase() + "%")
				.getResultList();
		
		entityManager.close();
		
		return new Historial(comp.toUpperCase(), ots);
	}
	
	public void close() {
		if (sessionFactory != null)
			sessionFactory.close();
	}
}
