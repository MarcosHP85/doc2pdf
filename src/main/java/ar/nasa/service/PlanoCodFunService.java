package ar.nasa.service;

import ar.nasa.domain.Documento;
import ar.nasa.pcf.domain.PlanoCodFunRepository;

import java.util.List;

public class PlanoCodFunService {

    private PlanoCodFunRepository planoCodFunRepository;

    public PlanoCodFunService() {
        planoCodFunRepository = new PlanoCodFunRepository();
    }

    public List<Documento> documentoPara(String c) {
        List<Documento> planos = planoCodFunRepository.findBy(c);

        return (planos.isEmpty()) ? null : planos;
    }
}
