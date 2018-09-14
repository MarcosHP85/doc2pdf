package ar.nasa.ask.domain;

import ar.nasa.mesa.domain.Ask6;
import ar.nasa.mesa.domain.Ask6c;
import ar.nasa.mesa.domain.Mkb6oc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Table(name = "area_principal")
public class AskAreaPrincipal {

    private Integer id;
    private String kks;
    private String kks2;
    private String revision;
    private String denominacion;
    private String redundancia;
    private String tren_electrica;
    private String codigo_bzkz;
    private String corridas_objeto;
    private String tipo_modulo;
    private String aplicacion;
    private String responsabilidad1;
    private String pzs;
    private String control_formulario;
    private String modo_medicion;
    private String grupo_funcional;
    private String complejo_funcional;
    private String armario;
    private String seccion_ingenieria;
    private String redundancia_adicional;
    private String alimentacion_ic;
    private String responsabilidades;
    private String funcional_analogico;
    private String tipo_mando1;
    private String lugar_mando1;
    private String tipo_mando2;
    private String lugar_mando2;
    private String codigo_conexion;
    private String porcentaje;
    private String temperatura;
    private String instrumentacion_perturbaciones;
    private String diagrama_flujo;
    private String responsabilidad2;
    private String recinto_toma;
    private String plan_group;
    private String cajas_empalme;
    private String codigo_montaje;
    private String lugar_montaje;
    private String tipo_salida;
    private String tipo_bornera;
    private String tipo_red;
    private String tension_voltaje;
    private String tension_tipo;
    private String nivel_conmutacion;
    private String tiempo_conmutacion;
    private String modulo_u11;
    private String modulo_us12;
    private String protocolo_tiempo_bt;
    private String tiempo_maximo;
    private String rele_dold;
    private String grupo_reconexion;
    private String nivel_etapa_carga_diesel;
    private String tiempo_etapa_carga_diesel;
    private String nivel_carga_diesel;
    private String tiempo_carga_diesel;
    private String tiempo_maximo_desconexion;
    private String conmutacion_automatica;
    private String funcional_us11_us12;
    private String aplicacion_adicional;
    private String info_adicional_aplicacion;
    private String observaciones1;
    private String observaciones2;
    private String vigente;
    private List<AskAreaVariable> areaVariables;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKks() {
        return kks == null ? "" : kks;
    }

    public void setKks(String kks) {
        this.kks = kks;
    }

    public String getKks2() {
        return kks2 == null ? "" : kks2;
    }

    public void setKks2(String kks2) {
        this.kks2 = kks2;
    }

    public String getRevision() {
        return revision == null ? "" : revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getDenominacion() {
        return denominacion == null ? "" : denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getRedundancia() {
        return redundancia == null ? "" : redundancia;
    }

    public void setRedundancia(String redundancia) {
        this.redundancia = redundancia;
    }

    public String getTren_electrica() {
        return tren_electrica == null ? "" : tren_electrica;
    }

    public void setTren_electrica(String tren_electrica) {
        this.tren_electrica = tren_electrica;
    }

    public String getCodigo_bzkz() {
        return codigo_bzkz == null ? "" : codigo_bzkz;
    }

    public void setCodigo_bzkz(String codigo_bzkz) {
        this.codigo_bzkz = codigo_bzkz;
    }

    public String getCorridas_objeto() {
        return corridas_objeto == null ? "" : corridas_objeto;
    }

    public void setCorridas_objeto(String corridas_objeto) {
        this.corridas_objeto = corridas_objeto;
    }

    public String getTipo_modulo() {
        return tipo_modulo == null ? "" : tipo_modulo;
    }

    public void setTipo_modulo(String tipo_modulo) {
        this.tipo_modulo = tipo_modulo;
    }

    public String getAplicacion() {
        return aplicacion == null ? "" : aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    public String getResponsabilidad1() {
        return responsabilidad1 == null ? "" : responsabilidad1;
    }

    public void setResponsabilidad1(String responsabilidad1) {
        this.responsabilidad1 = responsabilidad1;
    }

    public String getPzs() {
        return pzs == null ? "" : pzs;
    }

    public void setPzs(String pzs) {
        this.pzs = pzs;
    }

    public String getControl_formulario() {
        return control_formulario == null ? "" : control_formulario;
    }

    public void setControl_formulario(String control_formulario) {
        this.control_formulario = control_formulario;
    }

    public String getModo_medicion() {
        return modo_medicion == null ? "" : modo_medicion;
    }

    public void setModo_medicion(String modo_medicion) {
        this.modo_medicion = modo_medicion;
    }

    public String getGrupo_funcional() {
        return grupo_funcional == null ? "" : grupo_funcional;
    }

    public void setGrupo_funcional(String grupo_funcional) {
        this.grupo_funcional = grupo_funcional;
    }

    public String getComplejo_funcional() {
        return complejo_funcional == null ? "" : complejo_funcional;
    }

    public void setComplejo_funcional(String complejo_funcional) {
        this.complejo_funcional = complejo_funcional;
    }

    public String getArmario() {
        return armario == null ? "" : armario;
    }

    public void setArmario(String armario) {
        this.armario = armario;
    }

    public String getSeccion_ingenieria() {
        return seccion_ingenieria == null ? "" : seccion_ingenieria;
    }

    public void setSeccion_ingenieria(String seccion_ingenieria) {
        this.seccion_ingenieria = seccion_ingenieria;
    }

    public String getRedundancia_adicional() {
        return redundancia_adicional == null ? "" : redundancia_adicional;
    }

    public void setRedundancia_adicional(String redundancia_adicional) {
        this.redundancia_adicional = redundancia_adicional;
    }

    public String getAlimentacion_ic() {
        return alimentacion_ic == null ? "" : alimentacion_ic;
    }

    public void setAlimentacion_ic(String alimentacion_ic) {
        this.alimentacion_ic = alimentacion_ic;
    }

    public String getResponsabilidades() {
        return responsabilidades == null ? "" : responsabilidades;
    }

    public void setResponsabilidades(String responsabilidades) {
        this.responsabilidades = responsabilidades;
    }

    public String getFuncional_analogico() {
        return funcional_analogico == null ? "" : funcional_analogico;
    }

    public void setFuncional_analogico(String funcional_analogico) {
        this.funcional_analogico = funcional_analogico;
    }

    public String getTipo_mando1() {
        return tipo_mando1 == null ? "" : tipo_mando1;
    }

    public void setTipo_mando1(String tipo_mando1) {
        this.tipo_mando1 = tipo_mando1;
    }

    public String getLugar_mando1() {
        return lugar_mando1 == null ? "" : lugar_mando1;
    }

    public void setLugar_mando1(String lugar_mando1) {
        this.lugar_mando1 = lugar_mando1;
    }

    public String getTipo_mando2() {
        return tipo_mando2 == null ? "" : tipo_mando2;
    }

    public void setTipo_mando2(String tipo_mando2) {
        this.tipo_mando2 = tipo_mando2;
    }

    public String getLugar_mando2() {
        return lugar_mando2 == null ? "" : lugar_mando2;
    }

    public void setLugar_mando2(String lugar_mando2) {
        this.lugar_mando2 = lugar_mando2;
    }

    public String getCodigo_conexion() {
        return codigo_conexion == null ? "" : codigo_conexion;
    }

    public void setCodigo_conexion(String codigo_conexion) {
        this.codigo_conexion = codigo_conexion;
    }

    public String getPorcentaje() {
        return porcentaje == null ? "" : porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getTemperatura() {
        return temperatura == null ? "" : temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getInstrumentacion_perturbaciones() {
        return instrumentacion_perturbaciones == null ? "" : instrumentacion_perturbaciones;
    }

    public void setInstrumentacion_perturbaciones(String instrumentacion_perturbaciones) {
        this.instrumentacion_perturbaciones = instrumentacion_perturbaciones;
    }

    public String getDiagrama_flujo() {
        return diagrama_flujo == null ? "" : diagrama_flujo;
    }

    public void setDiagrama_flujo(String diagrama_flujo) {
        this.diagrama_flujo = diagrama_flujo;
    }

    public String getResponsabilidad2() {
        return responsabilidad2 == null ? "" : responsabilidad2;
    }

    public void setResponsabilidad2(String responsabilidad2) {
        this.responsabilidad2 = responsabilidad2;
    }

    public String getRecinto_toma() {
        return recinto_toma == null ? "" : recinto_toma;
    }

    public void setRecinto_toma(String recinto_toma) {
        this.recinto_toma = recinto_toma;
    }

    public String getPlan_group() {
        return plan_group == null ? "" : plan_group;
    }

    public void setPlan_group(String plan_group) {
        this.plan_group = plan_group;
    }

    public String getCajas_empalme() {
        return cajas_empalme == null ? "" : cajas_empalme;
    }

    public void setCajas_empalme(String cajas_empalme) {
        this.cajas_empalme = cajas_empalme;
    }

    public String getCodigo_montaje() {
        return codigo_montaje == null ? "" : codigo_montaje;
    }

    public void setCodigo_montaje(String codigo_montaje) {
        this.codigo_montaje = codigo_montaje;
    }

    public String getLugar_montaje() {
        return lugar_montaje == null ? "" : lugar_montaje;
    }

    public void setLugar_montaje(String lugar_montaje) {
        this.lugar_montaje = lugar_montaje;
    }

    public String getTipo_salida() {
        return tipo_salida == null ? "" : tipo_salida;
    }

    public void setTipo_salida(String tipo_salida) {
        this.tipo_salida = tipo_salida;
    }

    public String getTipo_bornera() {
        return tipo_bornera == null ? "" : tipo_bornera;
    }

    public void setTipo_bornera(String tipo_bornera) {
        this.tipo_bornera = tipo_bornera;
    }

    public String getTipo_red() {
        return tipo_red == null ? "" : tipo_red;
    }

    public void setTipo_red(String tipo_red) {
        this.tipo_red = tipo_red;
    }

    public String getTension_voltaje() {
        return tension_voltaje == null ? "" : tension_voltaje;
    }

    public void setTension_voltaje(String tension_voltaje) {
        this.tension_voltaje = tension_voltaje;
    }

    public String getTension_tipo() {
        return tension_tipo == null ? "" : tension_tipo;
    }

    public void setTension_tipo(String tension_tipo) {
        this.tension_tipo = tension_tipo;
    }

    public String getNivel_conmutacion() {
        return nivel_conmutacion == null ? "" : nivel_conmutacion;
    }

    public void setNivel_conmutacion(String nivel_conmutacion) {
        this.nivel_conmutacion = nivel_conmutacion;
    }

    public String getTiempo_conmutacion() {
        return tiempo_conmutacion == null ? "" : tiempo_conmutacion;
    }

    public void setTiempo_conmutacion(String tiempo_conmutacion) {
        this.tiempo_conmutacion = tiempo_conmutacion;
    }

    public String getModulo_u11() {
        return modulo_u11 == null ? "" : modulo_u11;
    }

    public void setModulo_u11(String modulo_u11) {
        this.modulo_u11 = modulo_u11;
    }

    public String getModulo_us12() {
        return modulo_us12 == null ? "" : modulo_us12;
    }

    public void setModulo_us12(String modulo_us12) {
        this.modulo_us12 = modulo_us12;
    }

    public String getProtocolo_tiempo_bt() {
        return protocolo_tiempo_bt == null ? "" : protocolo_tiempo_bt;
    }

    public void setProtocolo_tiempo_bt(String protocolo_tiempo_bt) {
        this.protocolo_tiempo_bt = protocolo_tiempo_bt;
    }

    public String getTiempo_maximo() {
        return tiempo_maximo == null ? "" : tiempo_maximo;
    }

    public void setTiempo_maximo(String tiempo_maximo) {
        this.tiempo_maximo = tiempo_maximo;
    }

    public String getRele_dold() {
        return rele_dold == null ? "" : rele_dold;
    }

    public void setRele_dold(String rele_dold) {
        this.rele_dold = rele_dold;
    }

    public String getGrupo_reconexion() {
        return grupo_reconexion == null ? "" : grupo_reconexion;
    }

    public void setGrupo_reconexion(String grupo_reconexion) {
        this.grupo_reconexion = grupo_reconexion;
    }

    public String getNivel_etapa_carga_diesel() {
        return nivel_etapa_carga_diesel == null ? "" : nivel_etapa_carga_diesel;
    }

    public void setNivel_etapa_carga_diesel(String nivel_etapa_carga_diesel) {
        this.nivel_etapa_carga_diesel = nivel_etapa_carga_diesel;
    }

    public String getTiempo_etapa_carga_diesel() {
        return tiempo_etapa_carga_diesel == null ? "" : tiempo_etapa_carga_diesel;
    }

    public void setTiempo_etapa_carga_diesel(String tiempo_etapa_carga_diesel) {
        this.tiempo_etapa_carga_diesel = tiempo_etapa_carga_diesel;
    }

    public String getNivel_carga_diesel() {
        return nivel_carga_diesel == null ? "" : nivel_carga_diesel;
    }

    public void setNivel_carga_diesel(String nivel_carga_diesel) {
        this.nivel_carga_diesel = nivel_carga_diesel;
    }

    public String getTiempo_carga_diesel() {
        return tiempo_carga_diesel == null ? "" : tiempo_carga_diesel;
    }

    public void setTiempo_carga_diesel(String tiempo_carga_diesel) {
        this.tiempo_carga_diesel = tiempo_carga_diesel;
    }

    public String getTiempo_maximo_desconexion() {
        return tiempo_maximo_desconexion == null ? "" : tiempo_maximo_desconexion;
    }

    public void setTiempo_maximo_desconexion(String tiempo_maximo_desconexion) {
        this.tiempo_maximo_desconexion = tiempo_maximo_desconexion;
    }

    public String getConmutacion_automatica() {
        return conmutacion_automatica == null ? "" : conmutacion_automatica;
    }

    public void setConmutacion_automatica(String conmutacion_automatica) {
        this.conmutacion_automatica = conmutacion_automatica;
    }

    public String getFuncional_us11_us12() {
        return funcional_us11_us12 == null ? "" : funcional_us11_us12;
    }

    public void setFuncional_us11_us12(String funcional_us11_us12) {
        this.funcional_us11_us12 = funcional_us11_us12;
    }

    public String getAplicacion_adicional() {
        return aplicacion_adicional == null ? "" : aplicacion_adicional;
    }

    public void setAplicacion_adicional(String aplicacion_adicional) {
        this.aplicacion_adicional = aplicacion_adicional;
    }

    public String getInfo_adicional_aplicacion() {
        return info_adicional_aplicacion == null ? "" : info_adicional_aplicacion;
    }

    public void setInfo_adicional_aplicacion(String info_adicional_aplicacion) {
        this.info_adicional_aplicacion = info_adicional_aplicacion;
    }

    public String getObservaciones1() {
        return observaciones1 == null ? "" : observaciones1;
    }

    public void setObservaciones1(String observaciones1) {
        this.observaciones1 = observaciones1;
    }

    public String getObservaciones2() {
        return observaciones2 == null ? "" : observaciones2;
    }

    public void setObservaciones2(String observaciones2) {
        this.observaciones2 = observaciones2;
    }

    public String getVigente() {
        return vigente == null ? "" : vigente;
    }

    public void setVigente(String vigente) {
        this.vigente = vigente;
    }

    @Transient
    public List<AskAreaVariable> getAreaVariables() {
        return areaVariables;
    }

    public void setAreaVariables(List<AskAreaVariable> areaVariables) {
        this.areaVariables = areaVariables;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ask6) {
            Ask6 ask6 = (Ask6)obj;

            boolean equal = true;

            if (!getDenominacion().trim().equalsIgnoreCase(ask6.getBezeich().trim())) {
                ask6.setBezeich(ask6.getBezeich().concat("*¹"));
                equal = false;
            }
            if (!getRedundancia().trim().equalsIgnoreCase(ask6.getR().trim())) {
                ask6.setR(ask6.getR().concat("*¹"));
                equal = false;
            }
            if (!getTren_electrica().trim().equalsIgnoreCase(ask6.getS().trim())) {
                ask6.setS(ask6.getS().concat("*¹"));
                equal = false;
            }
            if (!getCodigo_bzkz().trim().equalsIgnoreCase(ask6.getBzkz().trim())) {
                ask6.setBzkz(ask6.getBzkz().concat("*¹"));
                equal = false;
            }
            if (!getCorridas_objeto().trim().equalsIgnoreCase(ask6.getO().trim())) {
                ask6.setO(ask6.getO().concat("*¹"));
                equal = false;
            }
            if (!getTipo_modulo().trim().equalsIgnoreCase(ask6.getTypasbg().trim())) {
                ask6.setTypasbg(ask6.getTypasbg().concat("*¹"));
                equal = false;
            }
            if (!getAplicacion().trim().equalsIgnoreCase(ask6.getVerwen().trim())) {
                ask6.setVerwen(ask6.getVerwen().concat("*¹"));
                equal = false;
            }
            if (!getResponsabilidad1().trim().equalsIgnoreCase(ask6.getZust1().trim())) {
                ask6.setZust1(ask6.getZust1().concat("*¹"));
                equal = false;
            }
            if (!getPzs().trim().equalsIgnoreCase(ask6.getPzs().trim())) {
                ask6.setPzs(ask6.getPzs().concat("*¹"));
                equal = false;
            }
            if (!getControl_formulario().trim().equalsIgnoreCase(ask6.getVds().trim())) {
                ask6.setVds(ask6.getVds().concat("*¹"));
                equal = false;
            }
            if (!getModo_medicion().trim().equalsIgnoreCase(ask6.getMsra().trim())) {
                ask6.setMsra(ask6.getMsra().concat("*¹"));
                equal = false;
            }
            if (!getGrupo_funcional().trim().equalsIgnoreCase(ask6.getFkz().trim())) {
                ask6.setFkz(ask6.getFkz().concat("*¹"));
                equal = false;
            }
            if (!getComplejo_funcional().trim().equalsIgnoreCase(ask6.getFb().trim())) {
                ask6.setFb(ask6.getFb().concat("*¹"));
                equal = false;
            }
            if (!getArmario().trim().equalsIgnoreCase(ask6.getSchrank().trim())) {
                ask6.setSchrank(ask6.getSchrank().concat("*¹"));
                equal = false;
            }
            if (!getSeccion_ingenieria().trim().equalsIgnoreCase(ask6.getBe().trim())) {
                ask6.setBe(ask6.getBe().concat("*¹"));
                equal = false;
            }
            if (!getRedundancia_adicional().trim().equalsIgnoreCase(ask6.getZr().trim())) {
                ask6.setZr(ask6.getZr().concat("*¹"));
                equal = false;
            }
            if (!getAlimentacion_ic().trim().equalsIgnoreCase(ask6.getZs().trim())) {
                ask6.setZs(ask6.getZs().concat("*¹"));
                equal = false;
            }
            if (!getResponsabilidades().trim().equalsIgnoreCase(ask6.getBa().trim())) {
                ask6.setBa(ask6.getBa().concat("*¹"));
                equal = false;
            }
            if (!getFuncional_analogico().trim().equalsIgnoreCase(ask6.getUebersic().trim())) {
                ask6.setUebersic(ask6.getUebersic().concat("*¹"));
                equal = false;
            }
            if (!getTipo_mando1().trim().equalsIgnoreCase(ask6.getSst1().trim())) {
                ask6.setSst1(ask6.getSst1().concat("*¹"));
                equal = false;
            }
            if (!getLugar_mando1().trim().equalsIgnoreCase(ask6.getEinbau1().trim())) {
                ask6.setEinbau1(ask6.getEinbau1().concat("*¹"));
                equal = false;
            }
            if (!getTipo_mando2().trim().equalsIgnoreCase(ask6.getSst2().trim())) {
                ask6.setSst2(ask6.getSst2().concat("*¹"));
                equal = false;
            }
            if (!getLugar_mando2().trim().equalsIgnoreCase(ask6.getEinbau2().trim())) {
                ask6.setEinbau2(ask6.getEinbau2().concat("*¹"));
                equal = false;
            }
            if (!getCodigo_conexion().trim().equalsIgnoreCase(ask6.getSchvar().trim())) {
                ask6.setSchvar(ask6.getSchvar().concat("*¹"));
                equal = false;
            }
            if (!getPorcentaje().trim().equalsIgnoreCase(ask6.getProzenta().trim())) {
                ask6.setProzenta(ask6.getProzenta().concat("*¹"));
                equal = false;
            }
            if (!getTemperatura().trim().equalsIgnoreCase(ask6.getTc().trim())) {
                ask6.setTc(ask6.getTc().concat("*¹"));
                equal = false;
            }
            if (!getInstrumentacion_perturbaciones().trim().equalsIgnoreCase(ask6.getSa().trim())) {
                ask6.setSa(ask6.getSa().concat("*¹"));
                equal = false;
            }
            if (!getDiagrama_flujo().trim().equalsIgnoreCase(ask6.getSystplan().trim())) {
                ask6.setSystplan(ask6.getSystplan().concat("*¹"));
                equal = false;
            }
            if (!getResponsabilidad2().trim().equalsIgnoreCase(ask6.getZust2().trim())) {
                ask6.setZust2(ask6.getZust2().concat("*¹"));
                equal = false;
            }
            if (!getRecinto_toma().trim().equalsIgnoreCase(ask6.getRaumever().trim())) {
                ask6.setRaumever(ask6.getRaumever().concat("*¹"));
                equal = false;
            }
            if (!getPlan_group().trim().equalsIgnoreCase(ask6.getPlangrup().trim())) {
                ask6.setPlangrup(ask6.getPlangrup().concat("*¹"));
                equal = false;
            }
            if (!getCajas_empalme().trim().equalsIgnoreCase(ask6.getUva().trim())) {
                ask6.setUva(ask6.getUva().concat("*¹"));
                equal = false;
            }
            if (!getCodigo_montaje().trim().equalsIgnoreCase(ask6.getEp().trim())) {
                ask6.setEp(ask6.getEp().concat("*¹"));
                equal = false;
            }
            if (!getLugar_montaje().trim().equalsIgnoreCase(ask6.getEinbausa().trim())) {
                ask6.setEinbausa(ask6.getEinbausa().concat("*¹"));
                equal = false;
            }
            if (!getTipo_salida().trim().equalsIgnoreCase(ask6.getAbzwtyp().trim())) {
                ask6.setAbzwtyp(ask6.getAbzwtyp().concat("*¹"));
                equal = false;
            }
            if (!getTipo_bornera().trim().equalsIgnoreCase(ask6.getSt().trim())) {
                ask6.setSt(ask6.getSt().concat("*¹"));
                equal = false;
            }
            if (!getTipo_red().trim().equalsIgnoreCase(ask6.getNz().trim())) {
                ask6.setNz(ask6.getNz().concat("*¹"));
                equal = false;
            }
            if (!getTension_voltaje().trim().equalsIgnoreCase(ask6.getSpannv().trim())) {
                ask6.setSpannv(ask6.getSpannv().concat("*¹"));
                equal = false;
            }
            if (!getTension_tipo().trim().equalsIgnoreCase(ask6.getSpanna().trim())) {
                ask6.setSpanna(ask6.getSpanna().concat("*¹"));
                equal = false;
            }
            if (!getNivel_conmutacion().trim().equalsIgnoreCase(ask6.getEbumschs().trim())) {
                ask6.setEbumschs(ask6.getEbumschs().concat("*¹"));
                equal = false;
            }
            if (!getTiempo_conmutacion().trim().equalsIgnoreCase(ask6.getEbumscht().trim())) {
                ask6.setEbumscht(ask6.getEbumscht().concat("*¹"));
                equal = false;
            }
            if (!getModulo_u11().trim().equalsIgnoreCase(ask6.getU11().trim())) {
                ask6.setU11(ask6.getU11().concat("*¹"));
                equal = false;
            }
            if (!getModulo_us12().trim().equalsIgnoreCase(ask6.getUs12t().trim())) {
                ask6.setUs12t(ask6.getUs12t().concat("*¹"));
                equal = false;
            }
            if (!getProtocolo_tiempo_bt().trim().equalsIgnoreCase(ask6.getVerl().trim())) {
                ask6.setVerl(ask6.getVerl().concat("*¹"));
                equal = false;
            }
            if (!getTiempo_maximo().trim().equalsIgnoreCase(ask6.getTmax().trim())) {
                ask6.setTmax(ask6.getTmax().concat("*¹"));
                equal = false;
            }
            if (!getRele_dold().trim().equalsIgnoreCase(ask6.getDold().trim())) {
                ask6.setDold(ask6.getDold().concat("*¹"));
                equal = false;
            }
            if (!getGrupo_reconexion().trim().equalsIgnoreCase(ask6.getUsz().trim())) {
                ask6.setUsz(ask6.getUsz().concat("*¹"));
                equal = false;
            }
            if (!getNivel_etapa_carga_diesel().trim().equalsIgnoreCase(ask6.getNbss().trim())) {
                ask6.setNbss(ask6.getNbss().concat("*¹"));
                equal = false;
            }
            if (!getTiempo_etapa_carga_diesel().trim().equalsIgnoreCase(ask6.getNbt().trim())) {
                ask6.setNbt(ask6.getNbt().concat("*¹"));
                equal = false;
            }
            if (!getNivel_carga_diesel().trim().equalsIgnoreCase(ask6.getNnbss().trim())) {
                ask6.setNnbss(ask6.getNnbss().concat("*¹"));
                equal = false;
            }
            if (!getTiempo_carga_diesel().trim().equalsIgnoreCase(ask6.getNnt().trim())) {
                ask6.setNnt(ask6.getNnt().concat("*¹"));
                equal = false;
            }
            if (!getTiempo_maximo_desconexion().trim().equalsIgnoreCase(ask6.getTaus().trim())) {
                ask6.setTaus(ask6.getTaus().concat("*¹"));
                equal = false;
            }
            if (!getConmutacion_automatica().trim().equalsIgnoreCase(ask6.getAut().trim())) {
                ask6.setAut(ask6.getAut().concat("*¹"));
                equal = false;
            }
            if (!getFuncional_us11_us12().trim().equalsIgnoreCase(ask6.getFkplan().trim())) {
                ask6.setFkplan(ask6.getFkplan().concat("*¹"));
                equal = false;
            }
            if (!getAplicacion_adicional().trim().equalsIgnoreCase(ask6.getSonv().trim())) {
                ask6.setSonv(ask6.getSonv().concat("*¹"));
                equal = false;
            }
            if (!getInfo_adicional_aplicacion().trim().equalsIgnoreCase(ask6.getZa().trim())) {
                ask6.setZa(ask6.getZa().concat("*¹"));
                equal = false;
            }
            if (!getObservaciones1().trim().equalsIgnoreCase(ask6.getBemerku1().trim())) {
                ask6.setBemerku1(ask6.getBemerku1().concat("*¹"));
                equal = false;
            }
            if (!getObservaciones2().trim().equalsIgnoreCase(ask6.getBemerku2().trim())) {
                ask6.setBemerku2(ask6.getBemerku2().concat("*¹"));
                equal = false;
            }
            equal = areasVariablesIguales(ask6.getCs()) && equal;

            ask6.setDiferente(!equal);
            return equal;
        }
        return super.equals(obj);
    }

    private boolean areasVariablesIguales(List<Ask6c> ocs) {
        boolean equal = true;

        for (int i=0; i < areaVariables.size(); i++) {
            if (!areaVariables.get(i).equals(ocs.get(i))) {
                equal = false;
//                break;
            }
        }
        return equal;
    }
}
