package ar.nasa.pcf.domain;

import ar.nasa.domain.Documento;

import java.nio.file.Path;


public class PlanoCodFun extends Documento {
    private Path path;

    public PlanoCodFun(Path path) {
        this.path = path;
    }

    @Override
    public void pdfEnCarpeta(String carpeta) {

    }
}
