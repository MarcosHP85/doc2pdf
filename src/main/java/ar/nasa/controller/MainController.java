package ar.nasa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ar.nasa.domain.Documento;
import ar.nasa.ifs.domain.LverYPacc;
import ar.nasa.service.*;

public class MainController {

	private HojaDeMedicionService hojaDeMedicionService;
	private ListaValoresLimitesService listaValoresLimitesService;
	private PlanoCodFunService planoCodFunService;
	private MkbService mkbServise;
	private AskService askService;
	private IfsService ifsService;
	private boolean buscarLyp;
	private boolean buscarHisto;
	private boolean buscarHdM;
	private boolean buscarLvL;
    private boolean buscarMkbAsk;
	private boolean buscarPcf;
	
	public MainController() {
		hojaDeMedicionService = new HojaDeMedicionService();
		listaValoresLimitesService = new ListaValoresLimitesService();
		planoCodFunService = new PlanoCodFunService();
		mkbServise = new MkbService();
		askService = new AskService();
		ifsService = new IfsService();
	}
	
	public List<Documento> documentosPara(String c) {
		List<Documento> docs = new ArrayList<>();
		boolean esPlanta2000 = true;

		try {
			Long numOt = Long.parseLong(c);

            if (buscarLyp || buscarHisto || buscarHdM || buscarLvL || buscarMkbAsk || buscarPcf) {
				LverYPacc lyp = ifsService.lverYPaccPara(numOt);

				if (lyp != null) {
                    c = lyp.getOt().getComponente().getMchCode();
                    esPlanta2000 = lyp.getOt().getPlantaOt().equals("2000");

                    if (buscarLyp)
                        docs.add(lyp);
                }
			}
		} catch(NumberFormatException e) {
		    Pattern p = Pattern.compile("[a-zA-Z]{3}\\d{2}.*"); // ("\\w{3}\\d{2}\\w{2}.{3,}");
            Matcher m = p.matcher(c);

            if (m.find())
                esPlanta2000 = false;
        }

		if (buscarHisto) {
			Documento histo = ifsService.historialPara(c);
			if (histo != null)
				docs.add(histo);
		}
		
		if (buscarHdM && esPlanta2000) {
			List<Documento> hm = hojaDeMedicionService.documentoPara(c);
			if (hm != null)
				docs.addAll(hm);
		}
		
		if (buscarLvL && esPlanta2000) {
			Documento lvl = listaValoresLimitesService.documentoPara(c);
			if (lvl != null)
				docs.add(lvl);
		}

        if (buscarMkbAsk && !esPlanta2000) {
		    boolean esValvula = false;
			Pattern p = Pattern.compile("\\w{3}\\d{2}AA\\d{3}\\w?");
			Matcher m = p.matcher(c);
			if (m.find())
			    esValvula = true;

            if (!esValvula) {
                List<Documento> mkbs = mkbServise.documentoPara(c);

                if (mkbs != null)
                    docs.addAll(mkbs);

            } else {
                List<Documento> asks = askService.documentoPara(c);
                if (asks != null)
                    docs.addAll(asks);

                List<Documento> mkb;
                mkb = mkbServise.documentoParaComponente(c);
                if (mkb != null)
                    docs.addAll(mkb);
            }
        }

        if (buscarPcf && !esPlanta2000) {
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

    public boolean isBuscarPcf() {
        return buscarPcf;
    }

    public void setBuscarPcf(boolean buscarPcf) {
        this.buscarPcf = buscarPcf;
    }

    public boolean isBuscarMkbAsk() {
        return buscarMkbAsk;
    }

    public void setBuscarMkbAsk(boolean buscarMkbAsk) {
        this.buscarMkbAsk = buscarMkbAsk;
    }

    public void setBuscarTodo(boolean value) {
		this.buscarLyp = value;
		this.buscarHdM = value;
		this.buscarHisto = value;
		this.buscarLvL = value;
        this.buscarMkbAsk = value;
		this.buscarPcf = value;

	}

}
