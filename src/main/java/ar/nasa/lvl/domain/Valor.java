package ar.nasa.lvl.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "valores")
public class Valor {

	private Integer idValor;
	private String hoja;
	private String identificacion;
	private String senal;
	private String descripcion;
	private String ubicacion;
	private String componente;
	private String plano;
	private String rangomedicion;
	private String calibracionfisica;
	private String calibracionelectrica;
	private String potenciometro;
	private String histerisis;
	private String modificadapor;
	private String observaciones;
	private Date fechahoramod;
	
	@Id
	public Integer getIdValor() {
		return idValor;
	}
	public void setIdValor(Integer idValor) {
		this.idValor = idValor;
	}
	
	public String getHoja() {
		return hoja;
	}
	public void setHoja(String hoja) {
		this.hoja = hoja;
	}
	
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	
	public String getSenal() {
		return senal;
	}
	public void setSenal(String senal) {
		this.senal = senal;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public String getComponente() {
		return componente;
	}
	public void setComponente(String componente) {
		this.componente = componente;
	}
	
	public String getPlano() {
		return plano;
	}
	public void setPlano(String plano) {
		this.plano = plano;
	}
	
	public String getRangomedicion() {
		return rangomedicion;
	}
	public void setRangomedicion(String rangomedicion) {
		this.rangomedicion = rangomedicion;
	}
	
	public String getCalibracionfisica() {
		return calibracionfisica;
	}
	public void setCalibracionfisica(String calibracionfisica) {
		this.calibracionfisica = calibracionfisica;
	}
	
	public String getCalibracionelectrica() {
		return calibracionelectrica;
	}
	public void setCalibracionelectrica(String calibracionelectrica) {
		this.calibracionelectrica = calibracionelectrica;
	}
	
	public String getPotenciometro() {
		return potenciometro;
	}
	public void setPotenciometro(String potenciometro) {
		this.potenciometro = potenciometro;
	}
	
	public String getHisterisis() {
		return histerisis;
	}
	public void setHisterisis(String histerisis) {
		this.histerisis = histerisis;
	}
	
	public String getModificadapor() {
		return modificadapor;
	}
	public void setModificadapor(String modificadapor) {
		this.modificadapor = modificadapor;
	}
	
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observasiones) {
		this.observaciones = observasiones;
	}
	
	public Date getFechahoramod() {
		return fechahoramod;
	}
	public void setFechahoramod(Date fechahoramod) {
		this.fechahoramod = fechahoramod;
	}
}
