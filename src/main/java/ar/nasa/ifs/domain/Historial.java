package ar.nasa.ifs.domain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

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

public class Historial extends Documento {

	private List<OtIfsHistorica> ots;
	private String busqueda;
	public static IXDocReport REPORT;
	
	public Historial(String busqueda, List<OtIfsHistorica> ots) {
		try {
			REPORT = XDocReportRegistry.getRegistry().loadReport(
					ListaValoresLimites.class.getResourceAsStream("/historial.freemarker.odt"), 
					TemplateEngineKind.Freemarker);
			
		} catch (IOException | XDocReportException e) {
			e.printStackTrace();
		}
		
		this.setOts(ots);
		this.busqueda = busqueda;
	}

	@Override
	public void pdfEnCarpeta(String carpeta) {
		try {
			
			FileOutputStream out = new FileOutputStream(carpeta + File.separatorChar + "HISTO IFS " + busqueda + ".pdf");

			IContext context = REPORT.createContext();

			// Hardcodeo
			for (OtIfsHistorica ot : ots) {
				if (ot.getTrabajoRealizado() == null)
					ot.setTrabajoRealizado("---");

				if (ot.getTrabajoRealizado().endsWith("\n"))
				    ot.setTrabajoRealizado(ot.getTrabajoRealizado() + "\n");
			}

			context.put("ots", ots);
			context.put("busqueda", busqueda);
			
			Options options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.ODFDOM);
			REPORT.convert(context, options, out);
	      
		} catch (XDocReportException | IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String toString() {
		String tmp = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		for (OtIfsHistorica o: ots) {
			tmp += o.getOtId() + ", ";
		}
		
		return "HISTO " + busqueda + " ( " + sdf.format(ots.get(0).getFechaFin()) + " ): " + tmp.substring(0, tmp.length() - 2);
	}

	public List<OtIfsHistorica> getOts() {
		return ots;
	}

	public void setOts(List<OtIfsHistorica> ots) {
		this.ots = ots;
	}
}
