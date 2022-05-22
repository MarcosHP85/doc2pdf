package ar.nasa.ifs.domain;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

public class IfsRepository {

	private EntityManagerFactory sessionFactory;
	
	public IfsRepository() {
		sessionFactory = Persistence.createEntityManagerFactory("oracle.ifs");
//		sessionFactory = Persistence.createEntityManagerFactory("mysql.ifs");
	}
	
	public LverYPacc findLverYPaccBy(Long numOt) {
		
		EntityManager entityManager = sessionFactory.createEntityManager();
		OtActivaIfs ot = null;
		List<DocObject> docs;

		try {
			ot = entityManager.createQuery("FROM OtActivaIfs o WHERE o.numOt = :n", OtActivaIfs.class)
					.setParameter("n", numOt)
					.getSingleResult();

			if (ot.getNumOtMadre() != null) {
				OtActivaIfs otMadre;
				otMadre = entityManager.createQuery("FROM OtActivaIfs o WHERE o.numOt = :n", OtActivaIfs.class)
						.setParameter("n", ot.getNumOtMadre())
						.getSingleResult();
				ot.setOtMadre(otMadre);
			}
//			docs = entityManager.createQuery("FROM DocObject d WHERE d.keyRef = :o", DocObject.class)
//                    .setParameter("o", "WO_NO=" + numOt + "^")
//                    .getResultList();
//
            entityManager.close();
//
//            File f = new File("D:\\descarga.pdf");
//            FileOutputStream fo = null;
//
//            fo = new FileOutputStream(f);
//
//            InputStream in = null;
//            in = docs.get(0).getFile().getFileData().getBinaryStream();
//
//            byte[] buffer = new byte[1024];
//            while (in.read(buffer) > 0) {
//                fo.write(buffer);
//            }
//
//            fo.close();

		} catch (NoResultException e) {
            e.printStackTrace();
		}
		
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
