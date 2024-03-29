package ar.nasa.hm.domain;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import ar.nasa.domain.Documento;
import io.github.cdimascio.dotenv.Dotenv;

public class HojaDeMedicionRepository {

	public final String HTML_FOLDER;

	public HojaDeMedicionRepository(Dotenv dotenv) {
		HTML_FOLDER = dotenv.get("HDEM_FOLDER", "\\\\oftec.cna1.central.nasa\\htdocs\\documentos\\datoscomponentes\\mediciones\\Hojas Medicion");
	}
	
	public List<Documento> findBy(String c) {
		File dir = new File(HTML_FOLDER);
		final String comp = (c.substring(0, 2) + "0" + c.substring(2))
				.toUpperCase();

        //		File[] htmls = dir.listFiles(new FilenameFilter() {
        //			public boolean accept(File dir, String name) {
        //				return name.startsWith(comp);
        //			}
        //		});
		File[] htmls = dir.listFiles((dir1, name) -> name.startsWith(comp));
		
		List<Documento> hms = new ArrayList<>(); 
		for (File html: htmls)
			hms.add(new HojaDeMedicion(html));
		
		return hms;
	}
}
