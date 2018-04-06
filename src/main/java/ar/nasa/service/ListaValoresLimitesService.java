package ar.nasa.service;

import ar.nasa.domain.Documento;
import ar.nasa.lvl.domain.ListaValoresLimites;
import ar.nasa.lvl.domain.ListaValoresLimitesRepository;

public class ListaValoresLimitesService {

	private ListaValoresLimitesRepository listaValoresLimitesRepository;
	
	public Documento documentoPara(String c) {
		ListaValoresLimites lvl = getListaValoresLimitesRepository().findBy(c);
		
		return (lvl.getValores().isEmpty()) ? null : lvl;
	}

	private ListaValoresLimitesRepository getListaValoresLimitesRepository() {
		if (listaValoresLimitesRepository == null)
			listaValoresLimitesRepository = new ListaValoresLimitesRepository();
		
		return listaValoresLimitesRepository;
	}

	public void close() {
		if (listaValoresLimitesRepository != null)
			listaValoresLimitesRepository.close();
	}

}
