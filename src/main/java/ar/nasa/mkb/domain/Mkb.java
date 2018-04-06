package ar.nasa.mkb.domain;

import ar.nasa.domain.Documento;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Mkb extends Documento {

    public List<AreaPrincipal> getAreaPrincipals() {
        return areaPrincipals;
    }

    private List<AreaPrincipal> areaPrincipals;

    public Mkb(List<AreaPrincipal> areaPrincipals) {
        this.areaPrincipals = areaPrincipals;
    }

    @Override
    public void pdfEnCarpeta(String carpeta) {

        for (AreaPrincipal ap : areaPrincipals) {
            String fileName = "MKB " + ap.getKks();
            fileName += (ap.getKks2() != null) ? "-" + ap.getKks2() : "";

            try {
                FileUtils.copyURLToFile(
                        new URL("http://doccnaii.cna1.central.nasa/mkb/pdf/visual/" + ap.getId()),
                        new File(carpeta + File.separatorChar + fileName + ".pdf"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public String toString() {
        String tmp = "MKB ";

        for (AreaPrincipal ap : areaPrincipals) {
            tmp += ap.getKks();
            tmp += (ap.getKks2() != null) ? "-" + ap.getKks2() + " " : " ";
        }

        return tmp;
    }
}
