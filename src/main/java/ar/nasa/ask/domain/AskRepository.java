package ar.nasa.ask.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AskRepository {

    private EntityManagerFactory sessionFactory;

    public AskRepository() {
        sessionFactory = Persistence.createEntityManagerFactory("mysql.ask");
    }

    public Ask findBy(String c) {

        EntityManager entityManager = sessionFactory.createEntityManager();

        List<AskAreaPrincipal> askAreaPrincipals = entityManager
                .createQuery("FROM AskAreaPrincipal a WHERE a.kks = :c ORDER BY a.kks, a.kks2", AskAreaPrincipal.class)
                .setParameter("c", c)
                .getResultList();

        for (AskAreaPrincipal ask: askAreaPrincipals) {
            List<AskAreaVariable> askAreaVariables = entityManager
                    .createQuery("FROM AskAreaVariable v WHERE v.kks = :kks AND (v.kks2 = :kks2 OR (v.kks2 IS NULL AND :kks2 IS NULL)) ORDER BY v.pre1", AskAreaVariable.class)
                    .setParameter("kks", ask.getKks())
                    .setParameter("kks2", ask.getKks2())
                    .getResultList();

            ask.setAreaVariables(askAreaVariables);
        }

        entityManager.close();

        return new Ask(askAreaPrincipals);
    }

    public void close() {
        if (sessionFactory != null)
            sessionFactory.close();
    }
}
