package ar.nasa.domain;

public class Grupo extends Documento {

	private String titulo;
	
	public Grupo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return titulo;
	}

	@Override
	public void pdfEnCarpeta(String carpeta) {
	}
}
