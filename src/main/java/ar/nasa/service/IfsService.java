package ar.nasa.service;

import ar.nasa.ifs.domain.LverYPacc;

import ar.nasa.ifs.domain.Historial;
import ar.nasa.ifs.domain.IfsRepository;

public class IfsService {

	private IfsRepository ifsRepository;
	
	public LverYPacc lverYPaccPara(Long n) {
		LverYPacc lyp = getIfsRepository().findLverYPaccBy(n);
		
		return (lyp.getOt() == null) ? null : lyp;
	}

	public Historial historialPara(String comp) {
		Historial histo = getIfsRepository().findHistorial(comp);
		
		return (histo.getOts().isEmpty()) ? null : histo;
	}
	
	private IfsRepository getIfsRepository() {
		if (ifsRepository == null)
			ifsRepository = new IfsRepository();
		
		return ifsRepository;
	}

	public void close() {
		if (ifsRepository != null)
			ifsRepository.close();
	}
}
