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
	private static IXDocReport REPORT_LVER;
	private static IXDocReport REPORT_PACC;
	
	LverYPacc(OtActivaIfs ot) {
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
			context_lver.put("user", getUser());
			IContext context_pacc = REPORT_PACC.createContext();
			context_pacc.put("ot", ot);
			context_pacc.put("user", getUser());
		
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

	private User getUser() {
	    User user = new User();

        if (this.ot.getPlanifica() != null) {
            switch (this.ot.getPlanifica()) {
                case "MAPARODI":
                    user.setNombre("Marcos");
                    user.setApellido("Parodi");
                    break;
                case "MSOTTILE":
                    user.setNombre("Maximiliano");
                    user.setApellido("Sottile");
                    break;
                case "POCARANZA":
                    user.setNombre("Pablo");
                    user.setApellido("Ocaranza");
                    break;
                case "NARDISSON":
                    user.setNombre("Norberto");
                    user.setApellido("Ardisson");
                    break;
                case "FBIJAN":
                    user.setNombre("Facundo");
                    user.setApellido("Bijan");
                    break;
                case "HBRAVO":
                    user.setNombre("Hugo");
                    user.setApellido("Bravo");
                    break;
            }
        } else {
            switch (System.getProperty("user.name")) {
                case "mparodi":
                    user.setNombre("Marcos");
                    user.setApellido("Parodi");
                    break;
                case "msottile":
                    user.setNombre("Maximiliano");
                    user.setApellido("Sottile");
                    break;
                case "pocaranza":
                    user.setNombre("Pablo");
                    user.setApellido("Ocaranza");
                    break;
                case "nardisson":
                    user.setNombre("Norberto");
                    user.setApellido("Ardisson");
                    break;
                case "fbijan":
                    user.setNombre("Facundo");
                    user.setApellido("Bijan");
                    break;
                case "hbravo":
                    user.setNombre("Hugo");
                    user.setApellido("Bravo");
                    break;
                default:
                    user.setNombre("");
                    user.setApellido("");
            }
        }

        return user;
    }

	public OtActivaIfs getOt() {
		return ot;
	}

	public void setOt(OtActivaIfs ot) {
		this.ot = ot;
	}

    public class User {
	    String nombre;
	    String apellido;

        public String getNombre() {
            return nombre;
        }

        void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        void setApellido(String apellido) {
            this.apellido = apellido;
        }

    }
}
