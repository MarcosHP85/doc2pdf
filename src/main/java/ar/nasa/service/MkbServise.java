package ar.nasa.service;

import ar.nasa.domain.Documento;
import ar.nasa.mkb.domain.Mkb;
import ar.nasa.mkb.domain.MkbRepository;

public class MkbServise {

    private MkbRepository mkbRepository;

    public Documento documentoPara(String c) {
        Mkb mkb = getMkbRepository().findBy(c);

        return (mkb.getMkbAreaPrincipals().isEmpty()) ? null : mkb;
    }

    public Documento documentoParaComponente(String c) {
        Mkb mkb = getMkbRepository().findByComponente(c);

        return (mkb.getMkbAreaPrincipals().isEmpty()) ? null : mkb;
    }

    private MkbRepository getMkbRepository() {
        if (mkbRepository == null)
            mkbRepository = new MkbRepository();

        return mkbRepository;
    }

    public void close() {
        if (mkbRepository != null)
            mkbRepository.close();
    }

}
