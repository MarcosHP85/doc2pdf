package ar.nasa.mesa.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class MesaAskRepository {

    private EntityManagerFactory sessionFactory;

    public MesaAskRepository() {
        sessionFactory = Persistence.createEntityManagerFactory("mysql.mesa");
    }

    public MesaAsk findBy(String c) {

        EntityManager entityManager = sessionFactory.createEntityManager();

        List<Ask6> ask6s = entityManager
                .createQuery("FROM Ask6 a WHERE a.kennzeic = :c ORDER BY a.kennzeic, a.fz", Ask6.class)
                .setParameter("c", c)
                .getResultList();

        for (Ask6 ask: ask6s) {
            List<Ask6c> ask6cs = entityManager
                    .createQuery("FROM Ask6c v WHERE v.kennzeic = :kennzeic AND (v.fz = :fz OR (v.fz IS NULL AND :fz IS NULL)) ORDER BY v.pre1", Ask6c.class)
                    .setParameter("kennzeic", ask.getKennzeic())
                    .setParameter("fz", ask.getFz())
                    .getResultList();

            ask.setCs(ask6cs);
        }

        entityManager.close();

        return new MesaAsk(ask6s);
    }

    public void close() {
        if (sessionFactory != null)
            sessionFactory.close();
    }
}
