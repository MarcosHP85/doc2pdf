package ar.nasa.ifs.domain;

import org.hibernate.annotations.JoinFormula;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.IsoFields;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "ACTIVE_WORK_ORDER_TAB", schema = "IFSATA", catalog = "IFSATA")
public class OtActivaIfs {

	private Long numOt;
	private Equipo componente;
	private String tarea;
	private String error;
	private Character prioridad;
	private Organizacion organizacion;
	private String estado;
	private String tipoTrabajo;
	private String comentarioPla;
	private String directiva;
	private Date fechaRegistro;
	private String planifica;
	private String plantaOt;
	private Date inicioProg;
	private Boolean requierePpm;
	private Long numOtMadre;
	private OtActivaIfs otMadre;

	@Id
	@Column(name = "WO_NO")
	public Long getNumOt() {
		return numOt;
	}
	public void setNumOt(Long numOt) {
		this.numOt = numOt;
	}
	
	@ManyToOne
	@JoinColumn(name = "MCH_CODE")
	public Equipo getComponente() {
		return componente;
	}
	public void setComponente(Equipo componente) {
		this.componente = componente;
	}
	
	@Column(name = "WORK_DESCR_LO")
	public String getTarea() {
		return (tarea == null) ? "" : tarea.replaceAll("\r\n\r\n", "\n").trim();
	}
	public void setTarea(String tarea) {
		this.tarea = tarea;
	}
	
	@Column(name = "ERR_DESCR_LO")
	public String getError() {
		return (error == null) ? "" : error.replaceAll("\r\n\r\n", "\n").trim();
	}
	public void setError(String error) {
		this.error = error;
	}
	
	@Column(name = "PRIORITY_ID")
	public Character getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(Character prioridad) {
		this.prioridad = prioridad;
	}
	
	@Column(name = "WO_STATUS_ID")
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Column(name = "WORK_TYPE_ID")
	public String getTipoTrabajo() {
		return tipoTrabajo;
	}
	public void setTipoTrabajo(String tipoTrabajo) {
		this.tipoTrabajo = tipoTrabajo;
	}
	
	@Column(name = "COM_INT_PLA")
	public String getComentarioPla() {
		return comentarioPla;
	}
	public void setComentarioPla(String comentarioPla) {
		this.comentarioPla = comentarioPla;
	}
	
	@Column(name = "ERR_DESCR")
	public String getDirectiva() {
		return directiva;
	}
	public void setDirectiva(String directiva) {
		this.directiva = directiva;
	}
	
	@Column(name = "REG_DATE")
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	@Column(name = "PREPARED_BY_ID")
	public String getPlanifica() {
		return planifica;
	}
	public void setPlanifica(String planifica) {
		this.planifica = planifica;
	}
	
	@Column(name = "CONTRACT")
	public String getPlantaOt() {
		return plantaOt;
	}
	public void setPlantaOt(String plantaOt) {
		this.plantaOt = plantaOt;
	}

    @Column(name = "REQUIERE_PPM")
    public Boolean getRequierePpm() {
        return requierePpm;
    }
    public void setRequierePpm(Boolean requierePpm) {
        this.requierePpm = requierePpm;
    }

    @ManyToOne
	@JoinColumn(name = "ORG_CODE")
	public Organizacion getOrganizacion() {
		return organizacion;
	}
	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
	}
	
	@Transient
	public Integer getSemana() {
		ZonedDateTime now = ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
		if (inicioProg == null)
			return ((now.getYear()-2000) * 100) + now.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR) + 1;
		
		ZonedDateTime prog = ZonedDateTime.ofInstant(inicioProg.toInstant(), ZoneId.systemDefault());
		return ((prog.getYear()-2000) * 100) + prog.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
	}
	
	@Column(name = "PLAN_S_DATE")
	public Date getInicioProg() {
		return inicioProg;
	}
	public void setInicioProg(Date inicioProg) {
		this.inicioProg = inicioProg;
	}

	@Column(name = "WO_NO_MADRE")
	public Long getNumOtMadre() {
		return numOtMadre;
	}
	public void setNumOtMadre(Long numOtMadre) {
		this.numOtMadre = numOtMadre;
	}

	@Transient
	public OtActivaIfs getOtMadre() {
		return otMadre;
	}
	public void setOtMadre(OtActivaIfs otMadre) {
		this.otMadre = otMadre;
	}
}
