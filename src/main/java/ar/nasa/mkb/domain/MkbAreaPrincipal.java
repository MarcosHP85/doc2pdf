package ar.nasa.mkb.domain;

import ar.nasa.mesa.domain.Mkb6;
import ar.nasa.mesa.domain.Mkb6oc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Table(name = "area_principal")
public class MkbAreaPrincipal {

    private Integer id;
    private String kks;
    private String kks2;
    private String denominacion;
    private String redundancia;
    private String tren_electrica;
    private String codigo_bzkz;
    private String corridas_objeto;
    private String apl1;
    private String apl2;
    private String apl3;
    private String apl4;
    private String apl5;
    private String apl6;
    private String apl7;
    private String control_formulario;
    private String modo_medicion;
    private String grupo_planos;
    private String diagrama_flujo;
    private String grupo_funcional;
    private String complejo_funcional;
    private String armario;
    private String seccion_ingenieria;
    private String redundancia_adicional;
    private String alimentacion_ic;
    private String responsabilidad1;
    private String responsabilidades;
    private String funcional_analogico;
    private String valor_operacion;
    private String principio_rango_bera;
    private String fin_rango_bere;
    private String unidad;
    private String sobrepresion_admisible;
    private String temperatura_admisible;
    private String dosis;
    private String medio;
    private String clasificacion_sistema;
    private String ensayos_canerias;
    private String instrumentacion_perturbaciones;
    private String diseno_perturbaciones;
    private String perdida_primario;
    private String perdida_secundario;
    private String perdida_anular;
    private String lazo_control;
    private String terremoto;
    private String aeronave;
    private String pzs;
    private String tipo_senal;
    private String recinto_toma;
    private String primer_bloqueo_p;
    private String penetracion_canerias_p;
    private String diametro_externo;
    private String tipico_montaje;
    private String codigo_montaje;
    private String indice_ingenieria;
    private String recinto_primer_bloqueo;
    private String primer_bloqueo_m;
    private String penetracion_canerias_m;
    private String brida;
    private String material_sistema;
    private String proveedor;
    private String tasa_perdida;
    private String recinto_sensor;
    private String componente;
    private String cajas_empalme;
    private String espesor_pared;
    private String material_instrumento;
    private String responsabilidad2;
    private String largo_montaje_equipo;
    private String observaciones1;
    private String observaciones2;
    private List<MkbAreaVariable> areaVariables;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    String getKks() {
        return kks;
    }

    public void setKks(String kks) {
        this.kks = kks;
    }

    public String getKks2() {
        return kks2;
    }

    public void setKks2(String kks2) {
        this.kks2 = kks2;
    }

    public String getDenominacion() {
        return (denominacion == null) ? "" : denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getRedundancia() {
        return (redundancia == null) ? "" : redundancia;
    }

    public void setRedundancia(String redundancia) {
        this.redundancia = redundancia;
    }

    public String getTren_electrica() {
        return (tren_electrica == null) ? "" : tren_electrica;
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

    public String getApl1() {
        return apl1 == null ? "" : apl1;
    }

    public void setApl1(String apl1) {
        this.apl1 = apl1;
    }

    public String getApl2() {
        return apl2 == null ? "" : apl2;
    }

    public void setApl2(String apl2) {
        this.apl2 = apl2;
    }

    public String getApl3() {
        return apl3 == null ? "" : apl3;
    }

    public void setApl3(String apl3) {
        this.apl3 = apl3;
    }

    public String getApl4() {
        return apl4 == null ? "" : apl4;
    }

    public void setApl4(String apl4) {
        this.apl4 = apl4;
    }

    public String getApl5() {
        return apl5 == null ? "" : apl5;
    }

    public void setApl5(String apl5) {
        this.apl5 = apl5;
    }

    public String getApl6() {
        return apl6 == null ? "" : apl6;
    }

    public void setApl6(String apl6) {
        this.apl6 = apl6;
    }

    public String getApl7() {
        return apl7 == null ? "" : apl7;
    }

    public void setApl7(String apl7) {
        this.apl7 = apl7;
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

    public String getGrupo_planos() {
        return grupo_planos == null ? "" : grupo_planos;
    }

    public void setGrupo_planos(String grupo_planos) {
        this.grupo_planos = grupo_planos;
    }

    public String getDiagrama_flujo() {
        return diagrama_flujo == null ? "" : diagrama_flujo;
    }

    public void setDiagrama_flujo(String diagrama_flujo) {
        this.diagrama_flujo = diagrama_flujo;
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

    public String getResponsabilidad1() {
        return responsabilidad1 == null ? "" : responsabilidad1;
    }

    public void setResponsabilidad1(String responsabilidad1) {
        this.responsabilidad1 = responsabilidad1;
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

    public String getValor_operacion() {
        return valor_operacion == null ? "" : valor_operacion;
    }

    public void setValor_operacion(String valor_operacion) {
        this.valor_operacion = valor_operacion;
    }

    public String getPrincipio_rango_bera() {
        return principio_rango_bera == null ? "" : principio_rango_bera;
    }

    public void setPrincipio_rango_bera(String principio_rango_bera) {
        this.principio_rango_bera = principio_rango_bera;
    }

    public String getFin_rango_bere() {
        return fin_rango_bere == null ? "" : fin_rango_bere;
    }

    public void setFin_rango_bere(String fin_rango_bere) {
        this.fin_rango_bere = fin_rango_bere;
    }

    public String getUnidad() {
        return unidad == null ? "" : unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getSobrepresion_admisible() {
        return sobrepresion_admisible == null ? "" : sobrepresion_admisible;
    }

    public void setSobrepresion_admisible(String sobrepresion_admisible) {
        this.sobrepresion_admisible = sobrepresion_admisible;
    }

    public String getTemperatura_admisible() {
        return temperatura_admisible == null ? "" : temperatura_admisible;
    }

    public void setTemperatura_admisible(String temperatura_admisible) {
        this.temperatura_admisible = temperatura_admisible;
    }

    public String getDosis() {
        return dosis == null ? "" : dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getMedio() {
        return medio == null ? "" : medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }

    public String getClasificacion_sistema() {
        return clasificacion_sistema == null ? "" : clasificacion_sistema;
    }

    public void setClasificacion_sistema(String clasificacion_sistema) {
        this.clasificacion_sistema = clasificacion_sistema;
    }

    public String getEnsayos_canerias() {
        return ensayos_canerias == null ? "" : ensayos_canerias;
    }

    public void setEnsayos_canerias(String ensayos_canerias) {
        this.ensayos_canerias = ensayos_canerias;
    }

    public String getInstrumentacion_perturbaciones() {
        return instrumentacion_perturbaciones == null ? "" : instrumentacion_perturbaciones;
    }

    public void setInstrumentacion_perturbaciones(String instrumentacion_perturbaciones) {
        this.instrumentacion_perturbaciones = instrumentacion_perturbaciones;
    }

    public String getDiseno_perturbaciones() {
        return diseno_perturbaciones == null ? "" : diseno_perturbaciones;
    }

    public void setDiseno_perturbaciones(String diseno_perturbaciones) {
        this.diseno_perturbaciones = diseno_perturbaciones;
    }

    public String getPerdida_primario() {
        return perdida_primario == null ? "" : perdida_primario;
    }

    public void setPerdida_primario(String perdida_primario) {
        this.perdida_primario = perdida_primario;
    }

    public String getPerdida_secundario() {
        return perdida_secundario == null ? "" : perdida_secundario;
    }

    public void setPerdida_secundario(String perdida_secundario) {
        this.perdida_secundario = perdida_secundario;
    }

    public String getPerdida_anular() {
        return perdida_anular == null ? "" : perdida_anular;
    }

    public void setPerdida_anular(String perdida_anular) {
        this.perdida_anular = perdida_anular;
    }

    public String getLazo_control() {
        return lazo_control == null ? "" : lazo_control;
    }

    public void setLazo_control(String lazo_control) {
        this.lazo_control = lazo_control;
    }

    public String getTerremoto() {
        return terremoto == null ? "" : terremoto;
    }

    public void setTerremoto(String terremoto) {
        this.terremoto = terremoto;
    }

    public String getAeronave() {
        return aeronave == null ? "" : aeronave;
    }

    public void setAeronave(String aeronave) {
        this.aeronave = aeronave;
    }

    public String getPzs() {
        return pzs == null ? "" : pzs;
    }

    public void setPzs(String pzs) {
        this.pzs = pzs;
    }

    public String getTipo_senal() {
        return tipo_senal == null ? "" : tipo_senal;
    }

    public void setTipo_senal(String tipo_senal) {
        this.tipo_senal = tipo_senal;
    }

    public String getRecinto_toma() {
        return recinto_toma == null ? "" : recinto_toma;
    }

    public void setRecinto_toma(String recinto_toma) {
        this.recinto_toma = recinto_toma;
    }

    public String getPrimer_bloqueo_p() {
        return primer_bloqueo_p == null ? "" : primer_bloqueo_p;
    }

    public void setPrimer_bloqueo_p(String primer_bloqueo_p) {
        this.primer_bloqueo_p = primer_bloqueo_p;
    }

    public String getPenetracion_canerias_p() {
        return penetracion_canerias_p == null ? "" : penetracion_canerias_p;
    }

    public void setPenetracion_canerias_p(String penetracion_canerias_p) {
        this.penetracion_canerias_p = penetracion_canerias_p;
    }

    public String getDiametro_externo() {
        return diametro_externo == null ? "" : diametro_externo;
    }

    public void setDiametro_externo(String diametro_externo) {
        this.diametro_externo = diametro_externo;
    }

    public String getTipico_montaje() {
        return tipico_montaje == null ? "" : tipico_montaje;
    }

    public void setTipico_montaje(String tipico_montaje) {
        this.tipico_montaje = tipico_montaje;
    }

    public String getCodigo_montaje() {
        return codigo_montaje == null ? "" : codigo_montaje;
    }

    public void setCodigo_montaje(String codigo_montaje) {
        this.codigo_montaje = codigo_montaje;
    }

    public String getIndice_ingenieria() {
        return indice_ingenieria == null ? "" : indice_ingenieria;
    }

    public void setIndice_ingenieria(String indice_ingenieria) {
        this.indice_ingenieria = indice_ingenieria;
    }

    public String getRecinto_primer_bloqueo() {
        return recinto_primer_bloqueo == null ? "" : recinto_primer_bloqueo;
    }

    public void setRecinto_primer_bloqueo(String recinto_primer_bloqueo) {
        this.recinto_primer_bloqueo = recinto_primer_bloqueo;
    }

    public String getPrimer_bloqueo_m() {
        return primer_bloqueo_m == null ? "" : primer_bloqueo_m;
    }

    public void setPrimer_bloqueo_m(String primer_bloqueo_m) {
        this.primer_bloqueo_m = primer_bloqueo_m;
    }

    public String getPenetracion_canerias_m() {
        return penetracion_canerias_m == null ? "" : penetracion_canerias_m;
    }

    public void setPenetracion_canerias_m(String penetracion_canerias_m) {
        this.penetracion_canerias_m = penetracion_canerias_m;
    }

    public String getBrida() {
        return brida == null ? "" : brida;
    }

    public void setBrida(String brida) {
        this.brida = brida;
    }

    public String getMaterial_sistema() {
        return material_sistema == null ? "" : material_sistema;
    }

    public void setMaterial_sistema(String material_sistema) {
        this.material_sistema = material_sistema;
    }

    public String getProveedor() {
        return proveedor == null ? "" : proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getTasa_perdida() {
        return tasa_perdida == null ? "" : tasa_perdida;
    }

    public void setTasa_perdida(String tasa_perdida) {
        this.tasa_perdida = tasa_perdida;
    }

    public String getRecinto_sensor() {
        return recinto_sensor == null ? "" : recinto_sensor;
    }

    public void setRecinto_sensor(String recinto_sensor) {
        this.recinto_sensor = recinto_sensor;
    }

    public String getComponente() {
        return componente == null ? "" : componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public String getCajas_empalme() {
        return cajas_empalme == null ? "" : cajas_empalme;
    }

    public void setCajas_empalme(String cajas_empalme) {
        this.cajas_empalme = cajas_empalme;
    }

    public String getEspesor_pared() {
        return espesor_pared == null ? "" : espesor_pared;
    }

    public void setEspesor_pared(String espesor_pared) {
        this.espesor_pared = espesor_pared;
    }

    public String getMaterial_instrumento() {
        return material_instrumento == null ? "" : material_instrumento;
    }

    public void setMaterial_instrumento(String material_instrumento) {
        this.material_instrumento = material_instrumento;
    }

    public String getResponsabilidad2() {
        return responsabilidad2 == null ? "" : responsabilidad2;
    }

    public void setResponsabilidad2(String responsabilidad2) {
        this.responsabilidad2 = responsabilidad2;
    }

    public String getLargo_montaje_equipo() {
        return largo_montaje_equipo == null ? "" : largo_montaje_equipo;
    }

    public void setLargo_montaje_equipo(String largo_montaje_equipo) {
        this.largo_montaje_equipo = largo_montaje_equipo;
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

    @Transient
    public List<MkbAreaVariable> getAreaVariables() {
        return areaVariables;
    }

    public void setAreaVariables(List<MkbAreaVariable> areaVariables) {
        this.areaVariables = areaVariables;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Mkb6) {
            Mkb6 mkb6 = (Mkb6)obj;

            boolean equal = true;

            if (!getDenominacion().trim().equalsIgnoreCase(mkb6.getBezeich().trim())) {
                mkb6.setBezeich(mkb6.getBezeich().concat("*¹"));
                equal = false;
            }
            if (!getRedundancia().trim().equalsIgnoreCase(mkb6.getR().trim())) {
                mkb6.setR(mkb6.getR().concat("*¹"));
                equal = false;
            }
            if (!getTren_electrica().trim().equalsIgnoreCase(mkb6.getS().trim())) {
                mkb6.setS(mkb6.getS().concat("*¹"));
                equal = false;
            }
            if (!getCodigo_bzkz().trim().equalsIgnoreCase(mkb6.getBzkz().trim())) {
                mkb6.setBzkz(mkb6.getBzkz().concat("*¹"));
                equal = false;
            }
            if (!getCorridas_objeto().trim().equalsIgnoreCase(mkb6.getO().trim())) {
                mkb6.setO(mkb6.getO().concat("*¹"));
                equal = false;
            }
            if (!getApl1().trim().equalsIgnoreCase(mkb6.getVer1().trim())) {
                mkb6.setVer1(mkb6.getVer1().concat("*¹"));
                equal = false;
            }
            if (!getApl2().trim().equalsIgnoreCase(mkb6.getVer2().trim())) {
                mkb6.setVer2(mkb6.getVer2().concat("*¹"));
                equal = false;
            }
            if (!getApl3().trim().equalsIgnoreCase(mkb6.getVer3().trim())) {
                mkb6.setVer3(mkb6.getVer3().concat("*¹"));
                equal = false;
            }
            if (!getApl4().trim().equalsIgnoreCase(mkb6.getVer4().trim())) {
                mkb6.setVer4(mkb6.getVer4().concat("*¹"));
                equal = false;
            }
            if (!getApl5().trim().equalsIgnoreCase(mkb6.getVer5().trim())) {
                mkb6.setVer5(mkb6.getVer5().concat("*¹"));
                equal = false;
            }
            if (!getApl6().trim().equalsIgnoreCase(mkb6.getVer6().trim())) {
                mkb6.setVer6(mkb6.getVer6().concat("*¹"));
                equal = false;
            }
            if (!getApl7().trim().equalsIgnoreCase(mkb6.getVer7().trim())) {
                mkb6.setVer7(mkb6.getVer7().concat("*¹"));
                equal = false;
            }
            if (!getControl_formulario().trim().equalsIgnoreCase(mkb6.getVds().trim())) {
                mkb6.setVds(mkb6.getVds().concat("*¹"));
                equal = false;
            }
            if (!getModo_medicion().trim().equalsIgnoreCase(mkb6.getMsra().trim())) {
                mkb6.setMsra(mkb6.getMsra().concat("*¹"));
                equal = false;
            }
            if (!getGrupo_planos().trim().equalsIgnoreCase(mkb6.getPlangrup().trim())) {
                mkb6.setPlangrup(mkb6.getPlangrup().concat("*¹"));
                equal = false;
            }
            if (!getDiagrama_flujo().trim().equalsIgnoreCase(mkb6.getSystplan().trim())) {
                mkb6.setSystplan(mkb6.getSystplan().concat("*¹"));
                equal = false;
            }
            if (!getGrupo_funcional().trim().equalsIgnoreCase(mkb6.getFkz().trim())) {
                mkb6.setFkz(mkb6.getFkz().concat("*¹"));
                equal = false;
            }
            if (!getComplejo_funcional().trim().equalsIgnoreCase(mkb6.getFb().trim())) {
                mkb6.setFb(mkb6.getFb().concat("*¹"));
                equal = false;
            }
            if (!getArmario().trim().equalsIgnoreCase(mkb6.getSchrank().trim())) {
                mkb6.setSchrank(mkb6.getSchrank().concat("*¹"));
                equal = false;
            }
            if (!getSeccion_ingenieria().trim().equalsIgnoreCase(mkb6.getBe().trim())) {
                mkb6.setBe(mkb6.getBe().concat("*¹"));
                equal = false;
            }
            if (!getRedundancia_adicional().trim().equalsIgnoreCase(mkb6.getZr().trim())) {
                mkb6.setZr(mkb6.getZr().concat("*¹"));
                equal = false;
            }
            if (!getAlimentacion_ic().trim().equalsIgnoreCase(mkb6.getZs().trim())) {
                mkb6.setZs(mkb6.getZs().concat("*¹"));
                equal = false;
            }
            if (!getResponsabilidad1().trim().equalsIgnoreCase(mkb6.getZust1().trim())) {
                mkb6.setZust1(mkb6.getZust1().concat("*¹"));
                equal = false;
            }
            if (!getResponsabilidades().trim().equalsIgnoreCase(mkb6.getBa().trim())) {
                mkb6.setBa(mkb6.getBa().concat("*¹"));
                equal = false;
            }
            if (!getFuncional_analogico().trim().equalsIgnoreCase(mkb6.getUebersic().trim())) {
                mkb6.setUebersic(mkb6.getUebersic().concat("*¹"));
                equal = false;
            }
            if (!getValor_operacion().trim().equalsIgnoreCase(mkb6.getBwert().trim())) {
                mkb6.setBwert(mkb6.getBwert().concat("*¹"));
                equal = false;
            }
            if (!getPrincipio_rango_bera().trim().equalsIgnoreCase(mkb6.getBera().trim())) {
                mkb6.setBera(mkb6.getBera().concat("*¹"));
                equal = false;
            }
            if (!getFin_rango_bere().trim().equalsIgnoreCase(mkb6.getBere().trim())) {
                mkb6.setBere(mkb6.getBere().concat("*¹"));
                equal = false;
            }
            if (!getUnidad().trim().equalsIgnoreCase(mkb6.getEinheit().trim())) {
                mkb6.setEinheit(mkb6.getEinheit().concat("*¹"));
                equal = false;
            }
            if (!getSobrepresion_admisible().trim().equalsIgnoreCase(mkb6.getZulbtdru().trim())) {
                mkb6.setZulbtdru(mkb6.getZulbtdru().concat("*¹"));
                equal = false;
            }
            if (!getTemperatura_admisible().trim().equalsIgnoreCase(mkb6.getZulbttem().trim())) {
                mkb6.setZulbttem(mkb6.getZulbttem().concat("*¹"));
                equal = false;
            }
            if (!getDosis().trim().equalsIgnoreCase(mkb6.getDosis().trim())) {
                mkb6.setDosis(mkb6.getDosis().concat("*¹"));
                equal = false;
            }
            if (!getMedio().trim().equalsIgnoreCase(mkb6.getMedium().trim())) {
                mkb6.setMedium(mkb6.getMedium().concat("*¹"));
                equal = false;
            }
            if (!getClasificacion_sistema().trim().equalsIgnoreCase(mkb6.getKl().trim())) {
                mkb6.setKl(mkb6.getKl().concat("*¹"));
                equal = false;
            }
            if (!getEnsayos_canerias().trim().equalsIgnoreCase(mkb6.getRltg().trim())) {
                mkb6.setRltg(mkb6.getRltg().concat("*¹"));
                equal = false;
            }
            if (!getInstrumentacion_perturbaciones().trim().equalsIgnoreCase(mkb6.getSi().trim())) {
                mkb6.setSi(mkb6.getSi().concat("*¹"));
                equal = false;
            }
            if (!getDiseno_perturbaciones().trim().equalsIgnoreCase(mkb6.getSa().trim())) {
                mkb6.setSa(mkb6.getSa().concat("*¹"));
                equal = false;
            }
            if (!getPerdida_primario().trim().equalsIgnoreCase(mkb6.getPl().trim())) {
                mkb6.setPl(mkb6.getPl().concat("*¹"));
                equal = false;
            }
            if (!getPerdida_secundario().trim().equalsIgnoreCase(mkb6.getSl().trim())) {
                mkb6.setSl(mkb6.getSl().concat("*¹"));
                equal = false;
            }
            if (!getPerdida_anular().trim().equalsIgnoreCase(mkb6.getRl().trim())) {
                mkb6.setRl(mkb6.getRl().concat("*¹"));
                equal = false;
            }
            if (!getLazo_control().trim().equalsIgnoreCase(mkb6.getNs().trim())) {
                mkb6.setNs(mkb6.getNs().concat("*¹"));
                equal = false;
            }
            if (!getTerremoto().trim().equalsIgnoreCase(mkb6.getEb().trim())) {
                mkb6.setEb(mkb6.getEb().concat("*¹"));
                equal = false;
            }
            if (!getAeronave().trim().equalsIgnoreCase(mkb6.getFe().trim())) {
                mkb6.setFe(mkb6.getFe().concat("*¹"));
                equal = false;
            }
            if (!getPzs().trim().equalsIgnoreCase(mkb6.getPzs().trim())) {
                mkb6.setPzs(mkb6.getPzs().concat("*¹"));
                equal = false;
            }
            if (!getTipo_senal().trim().equalsIgnoreCase(mkb6.getSig().trim())) {
                mkb6.setSig(mkb6.getSig().concat("*¹"));
                equal = false;
            }
            if (!getRecinto_toma().trim().equalsIgnoreCase(mkb6.getRaumentn().trim())) {
                mkb6.setRaumentn(mkb6.getRaumentn().concat("*¹"));
                equal = false;
            }
            if (!getPrimer_bloqueo_p().trim().equalsIgnoreCase(mkb6.getErst1().trim())) {
                mkb6.setErst1(mkb6.getErst1().concat("*¹"));
                equal = false;
            }
            if (!getPenetracion_canerias_p().trim().equalsIgnoreCase(mkb6.getRdf1().trim())) {
                mkb6.setRdf1(mkb6.getRdf1().concat("*¹"));
                equal = false;
            }
            if (!getDiametro_externo().trim().equalsIgnoreCase(mkb6.getDn().trim())) {
                mkb6.setDn(mkb6.getDn().concat("*¹"));
                equal = false;
            }
            if (!getTipico_montaje().trim().equalsIgnoreCase(mkb6.getAnord().trim())) {
                mkb6.setAnord(mkb6.getAnord().concat("*¹"));
                equal = false;
            }
            if (!getCodigo_montaje().trim().equalsIgnoreCase(mkb6.getAbs().trim())) {
                mkb6.setAbs(mkb6.getAbs().concat("*¹"));
                equal = false;
            }
            if (!getIndice_ingenieria().trim().equalsIgnoreCase(mkb6.getEp().trim())) {
                mkb6.setEp(mkb6.getEp().concat("*¹"));
                equal = false;
            }
            if (!getRecinto_primer_bloqueo().trim().equalsIgnoreCase(mkb6.getRaumerst().trim())) {
                mkb6.setRaumerst(mkb6.getRaumerst().concat("*¹"));
                equal = false;
            }
            if (!getPrimer_bloqueo_m().trim().equalsIgnoreCase(mkb6.getErst2().trim())) {
                mkb6.setErst2(mkb6.getErst2().concat("*¹"));
                equal = false;
            }
            if (!getPenetracion_canerias_m().trim().equalsIgnoreCase(mkb6.getRdf2().trim())) {
                mkb6.setRdf2(mkb6.getRdf2().concat("*¹"));
                equal = false;
            }
            if (!getBrida().trim().equalsIgnoreCase(mkb6.getFlan().trim())) {
                mkb6.setFlan(mkb6.getFlan().concat("*¹"));
                equal = false;
            }
            if (!getMaterial_sistema().trim().equalsIgnoreCase(mkb6.getSwks().trim())) {
                mkb6.setSwks(mkb6.getSwks().concat("*¹"));
                equal = false;
            }
            if (!getProveedor().trim().equalsIgnoreCase(mkb6.getSlie().trim())) {
                mkb6.setSlie(mkb6.getSlie().concat("*¹"));
                equal = false;
            }
            if (!getTasa_perdida().trim().equalsIgnoreCase(mkb6.getLr().trim())) {
                mkb6.setLr(mkb6.getLr().concat("*¹"));
                equal = false;
            }
            if (!getRecinto_sensor().trim().equalsIgnoreCase(mkb6.getRaumgeb())) {
                mkb6.setRaumgeb(mkb6.getRaumgeb().concat("*¹"));
                equal = false;
            }
            if (!getComponente().trim().equalsIgnoreCase(mkb6.getKomp().trim())) {
                mkb6.setKomp(mkb6.getKomp().concat("*¹"));
                equal = false;
            }
            if (!getCajas_empalme().trim().equalsIgnoreCase(mkb6.getUva().trim())) {
                mkb6.setUva(mkb6.getUva().concat("*¹"));
                equal = false;
            }
            if (!getEspesor_pared().trim().equalsIgnoreCase(mkb6.getWandd().trim())) {
                mkb6.setWandd(mkb6.getWandd().concat("*¹"));
                equal = false;
            }
            if (!getMaterial_instrumento().trim().equalsIgnoreCase(mkb6.getGwks().trim())) {
                mkb6.setGwks(mkb6.getGwks().concat("*¹"));
                equal = false;
            }
            if (!getResponsabilidad2().trim().equalsIgnoreCase(mkb6.getZust2().trim())) {
                mkb6.setZust2(mkb6.getZust2().concat("*¹"));
                equal = false;
            }
            if (!getLargo_montaje_equipo().trim().equalsIgnoreCase(mkb6.getLg().trim())) {
                mkb6.setLg(mkb6.getLg().concat("*¹"));
                equal = false;
            }
            if (!getObservaciones1().trim().equalsIgnoreCase(mkb6.getBemerku1().trim())) {
                mkb6.setBemerku1(mkb6.getBemerku1().concat("*¹"));
                equal = false;
            }
            if (!getObservaciones2().trim().equalsIgnoreCase(mkb6.getBemerku2().trim())) {
                mkb6.setBemerku2(mkb6.getBemerku2().concat("*¹"));
                equal = false;
            }
            equal = areasVariablesIguales(mkb6.getOcs()) && equal;

            mkb6.setDiferente(!equal);
            return equal;
        }
        return super.equals(obj);
    }

    private boolean areasVariablesIguales(List<Mkb6oc> ocs) {
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