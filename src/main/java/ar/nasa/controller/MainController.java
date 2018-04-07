package ar.nasa.controller;

import java.util.ArrayList;
import java.util.List;

import ar.nasa.domain.Documento;
import ar.nasa.ifs.domain.LverYPacc;
import ar.nasa.service.*;

public class MainController {

	private HojaDeMedicionService hojaDeMedicionService;
	private ListaValoresLimitesService listaValoresLimitesService;
	private PlanoCodFunService planoCodFunService;
	private MkbServise mkbServise;
	private IfsService ifsService;
	private boolean buscarLyp;
	private boolean buscarHisto;
	private boolean buscarHdM;
	private boolean buscarLvL;
	private boolean buscarMkb;
	private boolean buscarPcf;
	
	public MainController() {
		hojaDeMedicionService = new HojaDeMedicionService();
		listaValoresLimitesService = new ListaValoresLimitesService();
		planoCodFunService = new PlanoCodFunService();
		mkbServise = new MkbServise();
		ifsService = new IfsService();
	}
	
	public List<Documento> documentosPara(String c) {
		List<Documento> docs = new ArrayList<>();

		try {
			Long numOt = Long.parseLong(c);

			if (buscarLyp || buscarHisto || buscarHdM || buscarLvL || buscarMkb || buscarPcf) {
				LverYPacc lyp = ifsService.lverYPaccPara(numOt);

				if (lyp != null) {
                    c = lyp.getOt().getComponente().getMchCode();

                    if (buscarLyp)
                        docs.add(lyp);
                }
			}
		} catch(NumberFormatException e) {
		    System.out.println(c + " no es un número de OT");
        }

		if (buscarHisto) {
			Documento histo = ifsService.historialPara(c);
			if (histo != null)
				docs.add(histo);
		}
		
		if (buscarHdM) {
			List<Documento> hm = hojaDeMedicionService.documentoPara(c);
			if (hm != null)
				docs.addAll(hm);
		}
		
		if (buscarLvL) {
			Documento lvl = listaValoresLimitesService.documentoPara(c);
			if (lvl != null)
				docs.add(lvl);
		}

		if (buscarMkb) {
		    Documento mkb = mkbServise.documentoPara(c);
		    if (mkb != null)
		        docs.add(mkb);
        }

        if (buscarPcf) {
		    List<Documento> pcf = planoCodFunService.documentoPara(c);
		    if (pcf != null)
		        docs.addAll(pcf);
        }
		
		return docs;
	}

	public void stop() {
		listaValoresLimitesService.close();
	}

	public boolean isBuscarLyp() {
		return buscarLyp;
	}

	public void setBuscarLyp(boolean buscarLyp) {
		this.buscarLyp = buscarLyp;
	}

	public boolean isBuscarHisto() {
		return buscarHisto;
	}

	public void setBuscarHisto(boolean buscarHisto) {
		this.buscarHisto = buscarHisto;
	}

	public boolean isBuscarHdM() {
		return buscarHdM;
	}

	public void setBuscarHdM(boolean buscarHdM) {
		this.buscarHdM = buscarHdM;
	}

	public boolean isBuscarLvL() {
		return buscarLvL;
	}

	public void setBuscarLvL(boolean buscarLvL) {
		this.buscarLvL = buscarLvL;
	}

	public boolean isBuscarMkb() {
	    return buscarMkb;
    }

    public void setBuscarMkb(boolean buscarMkb) {
	    this.buscarMkb = buscarMkb;
    }

    public boolean isBuscarPcf() {
        return buscarPcf;
    }

    public void setBuscarPcf(boolean buscarPcf) {
        this.buscarPcf = buscarPcf;
    }

    public void setBuscarTodo(boolean value) {
		this.buscarLyp = value;
		this.buscarHdM = value;
		this.buscarHisto = value;
		this.buscarLvL = value;
		this.buscarMkb = value;
		this.buscarPcf = value;

	}

}
