package ar.nasa.service;

import ar.nasa.domain.Documento;
import ar.nasa.pcf.domain.PlanoCodFunRepository;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.List;

public class PlanoCodFunService {

    private PlanoCodFunRepository planoCodFunRepository;

    public PlanoCodFunService(Dotenv dotenv) {
        planoCodFunRepository = new PlanoCodFunRepository(dotenv);
    }

    public List<Documento> documentoPara(String c) {
        List<Documento> planos = planoCodFunRepository.findBy(c);

        return (planos.isEmpty()) ? null : planos;
    }
}
