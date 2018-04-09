package ar.nasa.ask.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AskRepository {

    private EntityManagerFactory sessionFactory;

    public AskRepository() {
        sessionFactory = Persistence.createEntityManagerFactory("mysql.mkb");
    }

    public Ask findBy(String c) {

        EntityManager entityManager = sessionFactory.createEntityManager();

        List<AskAreaPrincipal> askAreaPrincipals = entityManager
                .createQuery("FROM AskAreaPrincipal a WHERE a.kks = :c", AskAreaPrincipal.class)
                .setParameter("c", c)
                .getResultList();

        entityManager.close();

        return new Ask(askAreaPrincipals);
    }

    public void close() {
        if (sessionFactory != null)
            sessionFactory.close();
    }
}
