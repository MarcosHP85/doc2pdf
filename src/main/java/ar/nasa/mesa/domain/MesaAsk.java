package ar.nasa.mesa.domain;

import ar.nasa.domain.Documento;
import ar.nasa.lvl.domain.ListaValoresLimites;
import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.core.document.SyntaxKind;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MesaAsk extends Documento {

    private List<Ask6> ask6s;
    public static IXDocReport REPORT;

    public MesaAsk(List<Ask6> ask6s) {
        this.ask6s = ask6s;

        try {
            REPORT = XDocReportRegistry.getRegistry().loadReport(
                    ListaValoresLimites.class.getResourceAsStream("/ask6.velocity.odt"),
                    TemplateEngineKind.Velocity);

        } catch (IOException | XDocReportException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void pdfEnCarpeta(String carpeta) {
        try {

            String fileName = "ASK MESA " + ask6s.get(0).getKennzeic();

            FileOutputStream out = new FileOutputStream(carpeta + File.separatorChar + fileName + ".pdf");

            FieldsMetadata metadata = REPORT.createFieldsMetadata();

            IContext context = REPORT.createContext();
            context.put("asks", ask6s);

            Options options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.ODFDOM);

            REPORT.convert(context, options, out);

        } catch (XDocReportException | IOException e) {
            e.printStackTrace();
        }
    }

    public List<Ask6> getAsk6s() {
        return ask6s;
    }

    public void setAsk6s(List<Ask6> ask6s) {
        this.ask6s = ask6s;
    }

    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder("ASK MESA ");

        for (Ask6 ap : ask6s) {
            tmp.append(ap.getKennzeic());
            tmp.append(!ap.getFz().equals("") ? "-" + ap.getFz() + " " : " ");
        }

        return tmp.toString();
    }
}
