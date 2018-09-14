package ar.nasa.mkb.domain;

import ar.nasa.domain.Documento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class MkbRepository {

    private EntityManagerFactory sessionFactory;

    public MkbRepository() {
        sessionFactory = Persistence.createEntityManagerFactory("mysql.mkb");
    }

    public List<Documento> findBy(String c) {

        EntityManager entityManager = sessionFactory.createEntityManager();

        List<MkbAreaPrincipal> mkbAreaPrincipals = entityManager
                .createQuery("FROM MkbAreaPrincipal a WHERE a.kks LIKE :c ORDER BY a.kks, a.kks2", MkbAreaPrincipal.class)
                .setParameter("c", c.toUpperCase() + "%")
                .getResultList();

        for (MkbAreaPrincipal mkb: mkbAreaPrincipals) {
            List<MkbAreaVariable> mkbAreaVariables = entityManager
                    .createQuery("FROM MkbAreaVariable v WHERE v.kks = :kks AND (v.kks2 = :kks2 OR (v.kks2 IS NULL AND :kks2 IS NULL)) ORDER BY v.in", MkbAreaVariable.class)
                    .setParameter("kks", mkb.getKks())
                    .setParameter("kks2", mkb.getKks2())
                    .getResultList();

            mkb.setAreaVariables(mkbAreaVariables);
        }

        entityManager.close();

        return agrupaPorComponente(mkbAreaPrincipals);
    }

    private List<Documento> agrupaPorComponente(List<MkbAreaPrincipal> mkbAreaPrincipals) {
        // Retorna de Mkb con cada componente ej. JKT12CX821, JKT12CX821A, JKT12CX821B, JKT12CX821C, JKT12CX821D, JKT12CX821E

        List<Documento> mkbs = new ArrayList<>();
        for (int i = 0; i < mkbAreaPrincipals.size(); ) {
            List<MkbAreaPrincipal> tmp = new ArrayList<>();
            do {
                tmp.add(mkbAreaPrincipals.get(i));

            }
            while (++i < mkbAreaPrincipals.size() - 2
                    && mkbAreaPrincipals.get(i - 1).getKks().equals(mkbAreaPrincipals.get(i).getKks()));

            mkbs.add(new Mkb(tmp));
        }

        return mkbs;
    }

    // Busca por componente por ej. los CG de un accionamiento
    public List<Documento> findByComponente(String c) {
        EntityManager entityManager = sessionFactory.createEntityManager();

        List<MkbAreaPrincipal> mkbAreaPrincipals = entityManager
                .createQuery("FROM MkbAreaPrincipal a WHERE a.componente LIKE :c ORDER BY a.kks, a.kks2", MkbAreaPrincipal.class)
                .setParameter("c", c.toUpperCase() + "%")
                .getResultList();

        for (MkbAreaPrincipal mkb: mkbAreaPrincipals) {
            List<MkbAreaVariable> mkbAreaVariables = entityManager
                    .createQuery("FROM MkbAreaVariable v WHERE v.kks = :kks AND (v.kks2 = :kks2 OR (v.kks2 IS NULL AND :kks2 IS NULL)) ORDER BY v.in", MkbAreaVariable.class)
                    .setParameter("kks", mkb.getKks())
                    .setParameter("kks2", mkb.getKks2())
                    .getResultList();

            mkb.setAreaVariables(mkbAreaVariables);
        }

        entityManager.close();

        return agrupaPorComponente(mkbAreaPrincipals);
    }

    public void close() {
        if (sessionFactory != null)
            sessionFactory.close();
    }
}
