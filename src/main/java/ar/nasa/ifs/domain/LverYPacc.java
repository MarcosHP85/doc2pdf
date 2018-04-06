package ar.nasa.ifs.domain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import ar.nasa.domain.Documento;
import ar.nasa.lvl.domain.ListaValoresLimites;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;


public class LverYPacc extends Documento {
	
	private OtActivaIfs ot;
	public static IXDocReport REPORT_LVER;
	public static IXDocReport REPORT_PACC;
	
	public LverYPacc(OtActivaIfs ot) {
		try {
			REPORT_LVER = XDocReportRegistry.getRegistry().loadReport(
					ListaValoresLimites.class.getResourceAsStream("/lver.velocity.docx"), 
					TemplateEngineKind.Velocity);
			REPORT_PACC = XDocReportRegistry.getRegistry().loadReport(
					ListaValoresLimites.class.getResourceAsStream("/pacc.velocity.docx"), 
					TemplateEngineKind.Velocity);
			
		} catch (IOException | XDocReportException e) {
			e.printStackTrace();
		}
		
		this.ot = ot;
	}

	@Override
	public void pdfEnCarpeta(String carpeta) {
		
		try {
			
			FileOutputStream out_lver = new FileOutputStream(carpeta + File.separatorChar + "" + ot.getNumOt() + " LVer.docx");
			FileOutputStream out_pacc = new FileOutputStream(carpeta + File.separatorChar + "" + ot.getNumOt() + " PAcc.docx");
			
			IContext context_lver = REPORT_LVER.createContext();
			context_lver.put("ot", ot);
			IContext context_pacc = REPORT_PACC.createContext();
			context_pacc.put("ot", ot);
		
			REPORT_LVER.process(context_lver, out_lver);
			REPORT_PACC.process(context_pacc, out_pacc);
			
		} catch (XDocReportException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "LVer/PAcc: " + ot.getNumOt() 
			+ " " + ot.getOrganizacion().getOrgCode()
			+ " " + ot.getTipoTrabajo()
			+ " " + ot.getDirectiva();
	}

	public OtActivaIfs getOt() {
		return ot;
	}

	public void setOt(OtActivaIfs ot) {
		this.ot = ot;
	}

}
