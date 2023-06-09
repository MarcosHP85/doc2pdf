package ar.nasa.ask.domain;

import ar.nasa.domain.Documento;
import ar.nasa.mesa.domain.MesaAsk;
import ar.nasa.mesa.domain.MesaMkb;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Ask extends Documento {

    public List<AskAreaPrincipal> getAskAreaPrincipals() {
        return askAreaPrincipals;
    }

    private List<AskAreaPrincipal> askAreaPrincipals;

    public Ask(List<AskAreaPrincipal> askAreaPrincipals) {
        this.askAreaPrincipals = askAreaPrincipals;
    }

    @Override
    public void pdfEnCarpeta(String carpeta) {

        for (AskAreaPrincipal ap : askAreaPrincipals) {
            String fileName = "ASK " + ap.getKks();
            fileName += (!ap.getKks2().equals("")) ? "-" + ap.getKks2() : "";

            try {
                FileUtils.copyURLToFile(
                        new URL("http://doccna.cna1.central.nasa/ask/pdf/visual/" + ap.getId()),
                        new File(carpeta + File.separatorChar + fileName + ".pdf"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MesaAsk) {
            MesaAsk mesaAsk = (MesaAsk) obj;
            boolean equal = true;

            if (mesaAsk.getAsk6s().size() > this.getAskAreaPrincipals().size()) {
                equal = false;
            } else {
                for (int i = 0; i < mesaAsk.getAsk6s().size(); i++) {
                    if (!this.askAreaPrincipals.get(i).equals(mesaAsk.getAsk6s().get(i))) {
                        equal = false;
                        break;
                    }
                }
            }
            return equal;
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder("ASK ");

        for (AskAreaPrincipal ap : askAreaPrincipals) {
            tmp.append(ap.getKks());
            tmp.append((!ap.getKks2().equals("")) ? "-" + ap.getKks2() + " " : " ");
        }

        return tmp.toString();
    }
}
