package ar.nasa.ifs.domain;

import ar.nasa.ask.domain.Ask;
import ar.nasa.domain.Documento;
import ar.nasa.hm.domain.HojaDeMedicion;
import ar.nasa.lvl.domain.ListaValoresLimites;
import ar.nasa.mkb.domain.Mkb;
import ar.nasa.pcf.domain.PlanoCodFun;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.images.ClassPathImageProvider;
import fr.opensagres.xdocreport.document.images.IImageProvider;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class LverYPacc extends Documento {
	
	private OtActivaIfs ot;
	private IndexLver index = new IndexLver();
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

            Boolean firma = ot.getComponente().getCriticality() == null ? true
                    : !(ot.getComponente().getCriticality().startsWith("C1")
                    || ot.getComponente().getCriticality().startsWith("C2")
                    || ot.getComponente().getCriticality().startsWith("SPV")
            );

			IContext context_lver = REPORT_LVER.createContext();
			context_lver.put("ot", ot);
			context_lver.put("user", getUser());
			context_lver.put("i", index);
            context_lver.put("firma", firma);

			IContext context_pacc = REPORT_PACC.createContext();
			context_pacc.put("ot", ot);
			context_pacc.put("user", getUser());
            context_pacc.put("firma", firma);
		
			REPORT_LVER.process(context_lver, out_lver);
			REPORT_PACC.process(context_pacc, out_pacc);

			index = new IndexLver();
			
		} catch (XDocReportException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "LVer PAcc: " + ot.getNumOt()
			+ " " + ot.getOrganizacion().getOrgCode()
			+ " " + ot.getTipoTrabajo()
			+ " " + ot.getDirectiva();
	}

	public void extraerInfo(Documento documento) {
	    if (documento instanceof Ask) {
            index.setsMedicion(index.sMedicion + "Ask ");
            index.setMedicion(true);
        }

	    if (documento instanceof HojaDeMedicion) {
            index.setsMedicion(index.sMedicion + "HdM ");
            index.setMedicion(true);
        }

	    if (documento instanceof ListaValoresLimites) {
            index.setsMedicion(index.sMedicion + "LvL ");
            index.setMedicion(true);
        }

	    if (documento instanceof Mkb) {
            index.setsMedicion(index.sMedicion + "Mkb ");
            index.setMedicion(true);
        }

	    if (documento instanceof PlanoCodFun) {
	        index.setsPlanos(index.sPlanos + documento.toString() + "\n");
            index.setPlanos(true);
        }

	    if (documento instanceof Historial)
	        index.setHistorial(true);
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
                case "22156":
                    user.setNombre("Facundo");
                    user.setApellido("Bijan");
                    break;
                case "20709":
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

    public class IndexLver {
	    boolean historial;
	    boolean planos;
	    boolean medicion;
	    String sPlanos = "";
	    String sMedicion = "";

        public String getsPlanos() {
            return sPlanos.equals("") ? "" : sPlanos.substring(0, sPlanos.length() - 1);
        }

        void setsPlanos(String sPlanos) {
            this.sPlanos = sPlanos;
        }

        public String getsMedicion() {
            return sMedicion.equals("") ? "" : sMedicion.substring(0, sMedicion.length() - 1);
        }

        void setsMedicion(String sMedicion) {
            this.sMedicion = sMedicion;
        }

        public boolean isPlanos() {
            return planos;
        }

        void setPlanos(boolean planos) {
            this.planos = planos;
        }

        public boolean isMedicion() {
            return medicion;
        }

        void setMedicion(boolean medicion) {
            this.medicion = medicion;
        }

        public boolean isHistorial() {
            return historial;
        }

        void setHistorial(boolean historial) {
            this.historial = historial;
        }

        IndexLver() {
            this.historial = false;
            this.planos = false;
            this.medicion = false;
        }
    }
}
