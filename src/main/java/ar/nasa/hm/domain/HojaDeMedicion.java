package ar.nasa.hm.domain;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import ar.nasa.domain.Documento;

public class HojaDeMedicion extends Documento {

	public static final String HTML_FOLDER = "\\\\oftec.cna1.central.nasa\\htdocs\\documentos\\datoscomponentes\\mediciones\\Hojas Medicion";
//	public static final String HTML_FOLDER = "/Volumes/GIT/Hojas Medicion";
	private File html;

	public HojaDeMedicion(File html) {
		this.html = html;
	}
	
	@Override
	public void pdfEnCarpeta(String carpeta) {
		Document document = new Document();
        PdfWriter writer;
		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(carpeta + File.separatorChar + "HM " + html.getName().substring(0, html.getName().length() - 5) + ".pdf"));

	        document.setPageSize(PageSize.A4);
	        document.open();

			XMLWorkerHelper.getInstance().parseXHtml(writer, document, normalizarHtml(html));
		
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		}
        document.close();
	}
	
	private ByteArrayInputStream normalizarHtml(File html) {
		String texto = null;
    	try {
			texto = FileUtils.readFileToString(html);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	texto = normalizarTags(texto);
    	texto = ampliarAltoDeFilas(texto);
    	
    	texto = unirTablaReceptores(texto);
    	texto = unirTablaObservaciones(texto);
    	texto = ajusteManual(texto);

    	return new ByteArrayInputStream(texto.toString().getBytes());
	}
	
	private String normalizarTags(String texto) {
		texto = texto.replaceFirst("charset=windows-1252\">", "charset=windows-1252\"/>");
		texto = texto.replaceAll(" WIDTH=695 ", "");
		texto = texto.replaceAll("</B></I>", "</I></B>");
		texto = texto.replaceAll("</TD><TD", "</TD>\r\n<TD");
		texto = texto.replaceAll("<BR>", "<BR/>");
		texto = texto.replaceAll("#000000",	"\"#000000\"");
		texto = texto.replaceAll("#000080",	"\"#000080\"");
		
		return texto;
	}
	
	private String ampliarAltoDeFilas(String texto) {
		texto = texto.replaceAll("<TR HEIGHT=9 >",	"<TR HEIGHT=17 >");
		texto = texto.replaceAll("<TR HEIGHT=12 >",	"<TR HEIGHT=14 >");
		texto = texto.replaceAll("<TR HEIGHT=15 >",	"<TR HEIGHT=17 >");
		texto = texto.replaceAll("<TR HEIGHT=19 >",	"<TR HEIGHT=21 >");
		texto = texto.replaceAll("<TR HEIGHT=20 >",	"<TR HEIGHT=22 >");
		
		return texto;
	}
	
	private String unirTablaReceptores(String texto) {
		return unirTablaEntre(texto,
				"<TD WIDTH=94  ALIGN=CENTER ><B><I><FONT style=FONT-SIZE:9pt FACE=\"Times New Roman\" COLOR=\"#000000\">Descripci&oacute;n",
				"<TD WIDTH=692  ALIGN=LEFT ><B><I><FONT style=FONT-SIZE:9pt FACE=\"Times New Roman\" COLOR=\"#000080\">Computadora");
	}
	
	private String unirTablaObservaciones(String texto) {
		return unirTablaEntre(texto,
				"<TD WIDTH=75  ALIGN=LEFT ><B><I><FONT style=FONT-SIZE:9pt FACE=\"Times New Roman\" COLOR=\"#000000\">Observaciones",
				"<TD WIDTH=28  ALIGN=CENTER ><B><I><FONT style=FONT-SIZE:9pt FACE=\"Times New Roman\" COLOR=\"#000080\">Rev.:");
	}
	
	private String unirTablaEntre(String texto, String inicio, String fin) {
		String tmp = "";
		String piePagina = "<TD WIDTH=28  ALIGN=CENTER ><B><I><FONT style=FONT-SIZE:9pt FACE=\"Times New Roman\" COLOR=\"#000080\">Rev.:";
		
		String[] aTexto = texto.split("\r\n");
		int i = 0;
		int j = 0;
		for (; !aTexto[i].startsWith(inicio); i++) {
			if (i == aTexto.length - 1)
				return texto;
		}
		for (j = i - 2; !(aTexto[j + 3].startsWith(fin) || aTexto[j + 3].startsWith(piePagina)); j++) {
			tmp = tmp + aTexto[j] + "\r\n";
		}

		tmp = tmp.replaceAll("</TABLE>\r\n<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0 >", "");
		
		String out = "";
		for (int x = 0; x < (i - 2); x++) {
			out = out + aTexto[x] + "\r\n";
		}
		out = out + ajusteColSpan(tmp);
		for (int y = j; y < aTexto.length; y++) {
			out = out + aTexto[y] + "\r\n";
		}
		
		return out;
	}
	
	private String ajusteColSpan(String texto) {
		Pattern p = Pattern.compile("WIDTH=(\\d+)");
    	
    	Set<Integer> columnas = new TreeSet<Integer>();
    	Integer sum = 0;
    	for (String linea: texto.split("\r\n")) {
    		if (linea.startsWith("<TD")) {
    			Matcher m = p.matcher(linea);
    			if (m.find()) {
    				sum += Integer.parseInt(m.group(1));
    				columnas.add(sum);
    			}
    		} else if (linea.startsWith("</TR>")) {
    			sum = 0;
    		}
    	}
    	
    	String sCol = "<thead>\r\n<tr>\r\n";
    	Integer colAnt = 0;
    	for (Integer col: columnas) {
    		int span = (col - colAnt);
    		sCol = sCol + "<td width=" + span + " />\r\n";
    		colAnt = col;
    	}
    	sCol = sCol + "</tr>\r\n</thead>";
		texto = texto.replaceAll("<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0 >", 
				"<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0 >\r\n" + sCol + "\r\n");
    	
    	Integer sumWidth = 0;
    	Integer sumSpan = 0;
    	Integer spanAnt = 0;
    	String tmp = "";
    	for (String linea: texto.split("\r\n")) {
    		if (linea.startsWith("<TD")) {
    			Matcher m = p.matcher(linea);
    			if (m.find()) {
    				sumWidth += Integer.parseInt(m.group(1));
    				for (Integer col: columnas) {
    					++sumSpan;
    					if (col.intValue() == sumWidth) {
							linea = linea.replaceFirst("WIDTH=" + m.group(1), "colspan=" + (sumSpan - spanAnt));
    						spanAnt = sumSpan;
    						sumSpan = 0;
    						break;
    					}
    				}
    			}
    		} else if (linea.startsWith("</TR>")) {
    			sumWidth = 0;
    			spanAnt = 0;
    		}
    		tmp = tmp.concat(linea + "\r\n");
    	}
    	return tmp;
	}
	
	private String ajusteManual(String texto) {
		Pattern p = Pattern.compile("WIDTH=(\\d+)[^>]*>.*<FONT.*?>(.*?)<\\/");
    	Matcher m = p.matcher(texto);
    	
    	StringBuffer result = new StringBuffer();
		while (m.find()) {
			Integer width = Integer.parseInt(m.group(1));
			String valor = m.group(2);

			switch (valor) {
			case "Lugar ":
				width = (width < 72) ? 72 : width;
				break;
			case "Perd.Presi&oacute;n Adm.:":
				width = (width < 114) ? 114 : width;
				break;
			case "Velocidad:":
				width = (width < 68) ? 68 : width;
				break;
			case "Denom.:":
				width = (width < 50) ? 50 : width;
				break;
			case "Transductor:":
				width = (width < 76) ? 76 : width;
				break;
			case "Cat&aacute;logo:":
				width = (width < 56) ? 56 : width;
				break;
			case "T.Amb.Adm.:":
				width = (width < 75) ? 75 : width;
				break;
			case "Lista Medic.:":
				width = (width < 84) ? 84 : width;
				break;
			case "Plano Cableado:":
				width = (width < 96) ? 96 : width;
				break;
			case "Limitador":
				width = (width < 83) ? 83 : width;
				break;
			case "V. Op. Max:":
				width = (width < 72) ? 72 : width;
				break;
			case "Val.Op.:":
				width = (width < 51) ? 51 : width;
				break;
			case "Rango:":
				width = (width < 42) ? 42 : width;
				break;
			case "Medio:":
				width = (width < 45) ? 45 : width;
				break;
			case "Accesorios:":
				width = (width < 65) ? 65 : width;
				break;
			}
    		
    		m.appendReplacement(result, m.group(0).replaceFirst(m.group(1),	width.toString()));
    	}
    	m.appendTail(result);

    	String tmp = result.toString();
    	// Observaciones
    	tmp = tmp.replaceFirst("<td width=75 />", "<td width=87 />");
    	// Recept.
    	tmp = tmp.replaceFirst("<td width=34 />", "<td width=40 />");
    	
    	return tmp;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		return "HM ( " + sdf.format(html.lastModified()) + " ): " + html.getName();
	}

	public File getHtml() {
		return html;
	}

	public void setHtml(File html) {
		this.html = html;
	}

}
