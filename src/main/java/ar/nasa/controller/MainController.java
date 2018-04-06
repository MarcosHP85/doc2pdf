package ar.nasa.controller;

import java.util.ArrayList;
import java.util.List;

import ar.nasa.domain.Documento;
import ar.nasa.ifs.domain.LverYPacc;
import ar.nasa.service.HojaDeMedicionService;
import ar.nasa.service.ListaValoresLimitesService;
import ar.nasa.service.IfsService;
import ar.nasa.service.MkbServise;

public class MainController {

	private HojaDeMedicionService hojaDeMedicionService;
	private ListaValoresLimitesService listaValoresLimitesService;
	private MkbServise mkbServise;
	private IfsService ifsService;
	private boolean buscarLyp;
	private boolean buscarHisto;
	private boolean buscarHdM;
	private boolean buscarLvL;
	private boolean buscarMkb;
	
	public MainController() {
		hojaDeMedicionService = new HojaDeMedicionService();
		listaValoresLimitesService = new ListaValoresLimitesService();
		mkbServise = new MkbServise();
		ifsService = new IfsService();
	}
	
	public List<Documento> documentosPara(String c) {
		List<Documento> docs = new ArrayList<>();
		
		try {
			Long numOt = Long.parseLong(c);
			
			if (buscarLyp || buscarHisto || buscarHdM || buscarLvL || buscarMkb) {
				LverYPacc lyp = ifsService.lverYPaccPara(numOt);
				
				if (lyp != null && buscarLyp)
					docs.add(lyp);
				
				c = lyp.getOt().getComponente().getMchCode();
			}
			
		} catch(NumberFormatException e) {}
		
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

	public void setBuscarTodo(boolean value) {
		this.buscarLyp = value;
		this.buscarHdM = value;
		this.buscarHisto = value;
		this.buscarLvL = value;
		this.buscarMkb = value;
	}

}
