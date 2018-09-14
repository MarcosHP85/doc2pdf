package ar.nasa.mkb.domain;

import ar.nasa.domain.Documento;
import ar.nasa.mesa.domain.MesaMkb;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Mkb extends Documento {

    public List<MkbAreaPrincipal> getMkbAreaPrincipals() {
        return mkbAreaPrincipals;
    }

    private List<MkbAreaPrincipal> mkbAreaPrincipals;

    public Mkb(List<MkbAreaPrincipal> mkbAreaPrincipals) {
        this.mkbAreaPrincipals = mkbAreaPrincipals;
    }

    @Override
    public void pdfEnCarpeta(String carpeta) {

        for (MkbAreaPrincipal ap : mkbAreaPrincipals) {
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
    public boolean equals(Object obj) {
        if (obj instanceof MesaMkb) {
            MesaMkb mesaMkb = (MesaMkb)obj;
            boolean equal = true;

            for (int i=0; i < this.mkbAreaPrincipals.size(); i++) {
                if (!this.mkbAreaPrincipals.get(i).equals(mesaMkb.getMkb6s().get(i))) {
                    equal = false;
                    break;
                }
            }
            return equal;
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder("MKB ");

        for (MkbAreaPrincipal ap : mkbAreaPrincipals) {
            tmp.append(ap.getKks());
            tmp.append((ap.getKks2() != null) ? "-" + ap.getKks2() + " " : " ");
        }

        return tmp.toString();
    }
}
