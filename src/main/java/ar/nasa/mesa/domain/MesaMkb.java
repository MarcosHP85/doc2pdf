package ar.nasa.mesa.domain;

import ar.nasa.domain.Documento;
import ar.nasa.lvl.domain.ListaValoresLimites;
import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class MesaMkb extends Documento {

    private List<Mkb6> mkb6s;
    public static IXDocReport REPORT;

    public MesaMkb(List<Mkb6> mkb6s) {
        this.mkb6s = mkb6s;

        try {
            REPORT = XDocReportRegistry.getRegistry().loadReport(
                    ListaValoresLimites.class.getResourceAsStream("/mkb6.velocity.odt"),
                    TemplateEngineKind.Velocity);

        } catch (IOException | XDocReportException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void pdfEnCarpeta(String carpeta) {
        try {

            String fileName = "MKB MESA " + mkb6s.get(0).getKennzeic();

            FileOutputStream out = new FileOutputStream(carpeta + File.separatorChar + fileName + ".pdf");

            IContext context = REPORT.createContext();
            context.put("mkbs", mkb6s);

            Options options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.ODFDOM);

            REPORT.convert(context, options, out);

        } catch (XDocReportException | IOException e) {
            e.printStackTrace();
        }
    }

    public List<Mkb6> getMkb6s() {
        return mkb6s;
    }

    public void setMkb6s(List<Mkb6> mkb6s) {
        this.mkb6s = mkb6s;
    }

    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder("MKB MESA ");

        for (Mkb6 ap : mkb6s) {
            tmp.append(ap.getKennzeic());
            tmp.append(!ap.getFz().equals("") ? "-" + ap.getFz() + " " : " ");
        }

        return tmp.toString();
    }
}
