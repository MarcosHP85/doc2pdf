package ar.nasa.service;

import ar.nasa.domain.Documento;
import ar.nasa.mesa.domain.MesaMkb;
import ar.nasa.mesa.domain.MesaMkbRepository;
import ar.nasa.mesa.domain.Mkb6;
import ar.nasa.mkb.domain.Mkb;
import ar.nasa.mkb.domain.MkbAreaPrincipal;
import ar.nasa.mkb.domain.MkbRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MkbService {

    private MkbRepository mkbRepository;
    private MesaMkbRepository mesaMkbRepository;

    public List<Documento> documentoPara(String c) {
        List<Documento> mkbs;
        mkbs = getMkbRepository().findBy(c);
        List<Documento> mesaMkbs;

        mesaMkbs = getMesaMkbRepository().findBy(c);
//        Collections.reverse(mesaMkbs);

        List<Documento> result = new ArrayList<>();
        for (int i=0; i < mkbs.size(); i++) {
            if (i < mesaMkbs.size())
                if (!((Mkb)mkbs.get(i)).equals(mesaMkbs.get(i)))
                    result.add(mesaMkbs.get(i));
            else
                break;
        }
//        for (Documento docMesa: mesaMkbs) {
//            MesaMkb mesa = (MesaMkb)docMesa;
//            for (Documento docMkb: mkbs) {
//                Mkb mkb = (Mkb)docMkb;
//                Mkb6 firstMesa = mesa.getMkb6s().get(0);
//                MkbAreaPrincipal firstMkb = mkb.getMkbAreaPrincipals().get(0);
//                if (firstMesa.getKennzeic().equals(firstMkb.getComponente())
//                    && firstMesa.getFz().equals(firstMkb.getKks2())
//            }
//        }
        mkbs.addAll(result);

        return (mkbs.isEmpty()) ? null : mkbs;
    }

    public List<Documento> documentoParaComponente(String c) {
        List<Documento> mkbs;
        mkbs = getMkbRepository().findByComponente(c);
        List<Documento> mesaMkbs;
        mesaMkbs = getMesaMkbRepository().findByComponente(c);

        List<Documento> result = new ArrayList<>();
        for (int i=0; i < mkbs.size(); i++) {
            if (i < mesaMkbs.size())
                if (!((Mkb)mkbs.get(i)).equals(mesaMkbs.get(i)))
                    result.add(mesaMkbs.get(i));
                else
                    break;
        }
        mkbs.addAll(result);

        return (mkbs.isEmpty()) ? null : mkbs;
    }

    private MkbRepository getMkbRepository() {
        if (mkbRepository == null)
            mkbRepository = new MkbRepository();

        return mkbRepository;
    }

    private MesaMkbRepository getMesaMkbRepository() {
        if (mesaMkbRepository == null)
            mesaMkbRepository = new MesaMkbRepository();

        return mesaMkbRepository;
    }

    public void close() {
        if (mkbRepository != null)
            mkbRepository.close();
    }

}
