package ar.nasa.service;

import java.util.List;

import ar.nasa.domain.Documento;
import ar.nasa.hm.domain.HojaDeMedicionRepository;
import io.github.cdimascio.dotenv.Dotenv;

public class HojaDeMedicionService {
	
	private HojaDeMedicionRepository hojaDeMedicionRepository;
	
	public HojaDeMedicionService(Dotenv dotenv) {
		hojaDeMedicionRepository = new HojaDeMedicionRepository(dotenv);
	}
	
	public List<Documento> documentoPara(String componente) {
		List<Documento> hms = hojaDeMedicionRepository.findBy(componente);
		
		return (hms.isEmpty()) ? null : hms;
	}

}
