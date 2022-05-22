package ar.nasa.lvl.domain;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ar.nasa.lvl.domain.ListaValoresLimites;
import ar.nasa.lvl.domain.Valor;

public class ListaValoresLimitesRepository {

	private EntityManagerFactory sessionFactory;
	
	public ListaValoresLimitesRepository() {
		sessionFactory = Persistence.createEntityManagerFactory("postgres.valoresLimites");
//		sessionFactory = Persistence.createEntityManagerFactory("mysql.valoresLimites");
	}

	public ListaValoresLimites findBy(String c) {
		
		Pattern p = Pattern.compile("(\\w{2})(\\d{2,3})(\\w?.*)");
		Matcher m = p.matcher(c);
        String identificacion = m.find()
                ? (m.group(1) + ((m.group(2).length() < 3) ? "0" : "") + m.group(2) + " " + m.group(3)).toUpperCase()
                : c;

		EntityManager entityManager = sessionFactory.createEntityManager();
		
		List<Valor> valores = entityManager
				.createQuery("FROM Valor v WHERE v.identificacion LIKE :i", Valor.class)
				.setParameter("i", identificacion + "%")
				.getResultList();
		
		entityManager.close();
		
		return new ListaValoresLimites(identificacion, valores);
	}

	public void close() {
		if (sessionFactory != null)
			sessionFactory.close();
	}

}
