package ar.nasa.service;

import ar.nasa.ask.domain.Ask;
import ar.nasa.ask.domain.AskRepository;
import ar.nasa.domain.Documento;
import ar.nasa.mesa.domain.MesaAsk;
import ar.nasa.mesa.domain.MesaAskRepository;

import java.util.ArrayList;
import java.util.List;

public class AskService {

    private AskRepository askRepository;
    private MesaAskRepository mesaAskRepository;

    public List<Documento> documentoPara(String c) {
        Ask ask = getAskRepository().findBy(c);
        MesaAsk mesaAsks = getMesaAskRepository().findBy(c);

        if (!ask.getAskAreaPrincipals().isEmpty()) {
            List<Documento> result = new ArrayList<>();
            result.add(ask);
            if (!(ask.equals(mesaAsks)))
                result.add(mesaAsks);

            return result;
        }
        return null;
    }

    private AskRepository getAskRepository() {
        if (askRepository == null)
            askRepository = new AskRepository();

        return askRepository;
    }

    private MesaAskRepository getMesaAskRepository() {
        if (mesaAskRepository == null)
            mesaAskRepository = new MesaAskRepository();

        return mesaAskRepository;
    }

    public void close() {
        if (askRepository != null)
            askRepository.close();
    }

}
