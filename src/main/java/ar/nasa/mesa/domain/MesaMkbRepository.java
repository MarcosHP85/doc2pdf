package ar.nasa.mesa.domain;

import ar.nasa.domain.Documento;
import ar.nasa.mkb.domain.Mkb;
import ar.nasa.mkb.domain.MkbAreaPrincipal;
import ar.nasa.mkb.domain.MkbAreaVariable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class MesaMkbRepository {

    private EntityManagerFactory sessionFactory;

    public MesaMkbRepository() {
        sessionFactory = Persistence.createEntityManagerFactory("mysql.mesa");
    }

    public List<Documento> findBy(String c) {

        EntityManager entityManager = sessionFactory.createEntityManager();

        List<Mkb6> mkb6s = entityManager
                .createQuery("FROM Mkb6 a WHERE a.kennzeic LIKE :c ORDER BY a.kennzeic, a.fz", Mkb6.class)
                .setParameter("c", c.toUpperCase() + "%")
                .getResultList();

        List<Mkb6oc> mkb6ocs;
        for (Mkb6 mkb: mkb6s) {
            mkb6ocs = entityManager
                    .createQuery("FROM Mkb6oc v WHERE v.kennzeic = :kennzeic AND v.fz = :fz ORDER BY v.prek1", Mkb6oc.class)
                    .setParameter("kennzeic", mkb.getKennzeic())
                    .setParameter("fz", mkb.getFz())
                    .getResultList();

            mkb.setOcs(mkb6ocs);
        }

        entityManager.close();

        return agrupaPorComponente(mkb6s);
    }

    private List<Documento> agrupaPorComponente(List<Mkb6> mkb6s) {
        // Retorna de Mkb con cada componente ej. JKT12CX821, JKT12CX821A, JKT12CX821B, JKT12CX821C, JKT12CX821D, JKT12CX821E

        List<Documento> mkbs = new ArrayList<>();
        for (int i = 0; i < mkb6s.size(); ) {
            List<Mkb6> tmp = new ArrayList<>();
            do {
                tmp.add(mkb6s.get(i));

            }
            while (++i < mkb6s.size()
                    && mkb6s.get(i - 1).getKennzeic().equals(mkb6s.get(i).getKennzeic()));

            mkbs.add(new MesaMkb(tmp));
        }

        return mkbs;
    }

    public List<Documento> findByComponente(String c) {
        EntityManager entityManager = sessionFactory.createEntityManager();

        List<Mkb6> mkb6s = entityManager
                .createQuery("FROM Mkb6 a WHERE TRIM(a.komp) = :c ORDER BY a.kennzeic, a.fz", Mkb6.class)
                .setParameter("c", c)
                .getResultList();

        List<Mkb6oc> mkb6ocs;
        for (Mkb6 mkb: mkb6s) {
            mkb6ocs = entityManager
                    .createQuery("FROM Mkb6oc v WHERE v.kennzeic = :kennzeic AND (v.fz = :fz OR (v.fz IS NULL AND :fz IS NULL)) ORDER BY v.prek1", Mkb6oc.class)
                    .setParameter("kennzeic", mkb.getKennzeic())
                    .setParameter("fz", mkb.getFz())
                    .getResultList();

            mkb.setOcs(mkb6ocs);
        }

        entityManager.close();

        return agrupaPorComponente(mkb6s);
    }

    public void close() {
        if (sessionFactory != null)
            sessionFactory.close();
    }
}
