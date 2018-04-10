package ar.nasa.mkb.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class MkbRepository {

    private EntityManagerFactory sessionFactory;

    public MkbRepository() {
        sessionFactory = Persistence.createEntityManagerFactory("mysql.mkb");
    }

    public Mkb findBy(String c) {

        EntityManager entityManager = sessionFactory.createEntityManager();

        List<MkbAreaPrincipal> mkbAreaPrincipals = entityManager
                .createQuery("FROM MkbAreaPrincipal a WHERE a.kks = :c", MkbAreaPrincipal.class)
                .setParameter("c", c)
                .getResultList();

        entityManager.close();

        return new Mkb(mkbAreaPrincipals);
    }

    public void close() {
        if (sessionFactory != null)
            sessionFactory.close();
    }
}
