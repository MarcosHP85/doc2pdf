package ar.nasa.service;

import java.util.List;

import ar.nasa.domain.Documento;
import ar.nasa.hm.domain.HojaDeMedicionRepository;

public class HojaDeMedicionService {
	
	private HojaDeMedicionRepository hojaDeMedicionRepository;
	
	public HojaDeMedicionService() {
		hojaDeMedicionRepository = new HojaDeMedicionRepository();
	}
	
	public List<Documento> documentoPara(String componente) {
		List<Documento> hms = hojaDeMedicionRepository.findBy(componente);
		
		return (hms.isEmpty()) ? null : hms;
	}

}
