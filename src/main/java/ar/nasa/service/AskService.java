package ar.nasa.service;

import ar.nasa.ask.domain.Ask;
import ar.nasa.ask.domain.AskRepository;
import ar.nasa.domain.Documento;

public class AskService {

    private AskRepository askRepository;

    public Documento documentoPara(String c) {
        Ask ask = getMkbRepository().findBy(c);

        return (ask.getAskAreaPrincipals().isEmpty()) ? null : ask;
    }

    private AskRepository getMkbRepository() {
        if (askRepository == null)
            askRepository = new AskRepository();

        return askRepository;
    }

    public void close() {
        if (askRepository != null)
            askRepository.close();
    }

}
