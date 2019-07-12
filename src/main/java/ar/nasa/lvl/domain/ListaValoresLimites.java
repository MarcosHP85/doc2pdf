package ar.nasa.lvl.domain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import ar.nasa.domain.Documento;
import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

public class ListaValoresLimites extends Documento {

	private String busqueda;
	private List<Valor> valores;
	public static IXDocReport REPORT;
	
	public ListaValoresLimites(String busqueda, List<Valor> valores) {
		this.busqueda = busqueda;
		this.valores = valores;
		
		try {
			REPORT = XDocReportRegistry.getRegistry().loadReport(
					ListaValoresLimites.class.getResourceAsStream("/lvl.velocity.odt"), 
					TemplateEngineKind.Velocity);
			
		} catch (IOException | XDocReportException e) {
			e.printStackTrace();
		}
	}
	
	public String getBusqueda() {
		return busqueda;
	}
	public void setBusqueda(String busqueda) {
		this.busqueda = busqueda;
	}
	public List<Valor> getValores() {
		return valores;
	}
	public void setValores(List<Valor> valores) {
		this.valores = valores;
	}

	@Override
	public void pdfEnCarpeta(String carpeta) {
		try {
			
			FileOutputStream out = new FileOutputStream(carpeta + File.separatorChar + "LVL " + busqueda + ".pdf");
			
			IContext context = REPORT.createContext();
			context.put("busqueda", busqueda);
			context.put("valores", valores);

			// Forzando la fecha
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            context.put("hoy", sdf.format(new Date()));
			
			Options options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.ODFDOM);
		
			REPORT.convert(context, options, out);
			
		} catch (XDocReportException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		String tmp = "";
		Date max = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		for (Valor v: valores) {
			tmp += v.getSenal() + " = \"" + v.getCalibracionfisica() + "\", ";
			
			max = (max == null || v.getFechahoramod().after(max)) ? v.getFechahoramod() : max;
		}
		
		return "LVL " + busqueda + " ( " + ((max == null) ? "Sin Fecha" : sdf.format(max)) + " ): " + tmp.substring(0, tmp.length() - 2);
	}
	
}
