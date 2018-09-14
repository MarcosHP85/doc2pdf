package ar.nasa.mkb.domain;

import ar.nasa.mesa.domain.Mkb6oc;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "area_variable")
public class MkbAreaVariable {

    private Integer id;
    private String in;
    private String kks;
    private String kks2;
    private String codigo_dispositivo;
    private String conexion;
    private String dador_binario;
    private String codigo_kwu;
    private String equipo;
    private String nro_producto;
    private String codigo_producto;
    private String proveedor;
    private String departamento_pedido;
    private String grupo_ensayos;
    private String rango;
    private String codigo_senal;
    private String lugar_montaje;
    private String cajas_empalme;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }

    public String getKks() {
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

    public String getCodigo_dispositivo() {
        return codigo_dispositivo == null ? "" : codigo_dispositivo;
    }

    public void setCodigo_dispositivo(String codigo_dispositivo) {
        this.codigo_dispositivo = codigo_dispositivo;
    }

    public String getConexion() {
        return conexion == null ? "" : conexion;
    }

    public void setConexion(String conexion) {
        this.conexion = conexion;
    }

    public String getDador_binario() {
        return dador_binario == null ? "" : dador_binario;
    }

    public void setDador_binario(String dador_binario) {
        this.dador_binario = dador_binario;
    }

    public String getCodigo_kwu() {
        return codigo_kwu == null ? "" : codigo_kwu;
    }

    public void setCodigo_kwu(String codigo_kwu) {
        this.codigo_kwu = codigo_kwu;
    }

    public String getEquipo() {
        return equipo == null ? "" : equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getNro_producto() {
        return nro_producto == null ? "" : nro_producto;
    }

    public void setNro_producto(String nro_producto) {
        this.nro_producto = nro_producto;
    }

    public String getCodigo_producto() {
        return codigo_producto == null ? "" : codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getProveedor() {
        return proveedor == null ? "" : proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getDepartamento_pedido() {
        return departamento_pedido == null ? "" : departamento_pedido;
    }

    public void setDepartamento_pedido(String departamento_pedido) {
        this.departamento_pedido = departamento_pedido;
    }

    public String getGrupo_ensayos() {
        return grupo_ensayos == null ? "" : grupo_ensayos;
    }

    public void setGrupo_ensayos(String grupo_ensayos) {
        this.grupo_ensayos = grupo_ensayos;
    }

    public String getRango() {
        return rango == null ? "" : rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getCodigo_senal() {
        return codigo_senal == null ? "" : codigo_senal;
    }

    public void setCodigo_senal(String codigo_senal) {
        this.codigo_senal = codigo_senal;
    }

    public String getLugar_montaje() {
        return lugar_montaje == null ? "" : lugar_montaje;
    }

    public void setLugar_montaje(String lugar_montaje) {
        this.lugar_montaje = lugar_montaje;
    }

    public String getCajas_empalme() {
        return cajas_empalme == null ? "" : cajas_empalme;
    }

    public void setCajas_empalme(String cajas_empalme) {
        this.cajas_empalme = cajas_empalme;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Mkb6oc) {
            Mkb6oc mkb6oc = (Mkb6oc)obj;

            boolean equal = true;
            
            if (!getCodigo_dispositivo().trim().equalsIgnoreCase(mkb6oc.getBkz().trim())) {
                mkb6oc.setBkz(mkb6oc.getBkz().concat("*¹"));
                equal = false;
            }
            if (!getConexion().trim().equalsIgnoreCase(mkb6oc.getAns().trim())) {
                mkb6oc.setAns(mkb6oc.getAns().concat("*¹"));
                equal = false;
            }
            if (!getDador_binario().trim().equalsIgnoreCase(mkb6oc.getT().trim())) {
                mkb6oc.setT(mkb6oc.getT().concat("*¹"));
                equal = false;
            }
            if (!getCodigo_kwu().trim().equalsIgnoreCase(mkb6oc.getSchl().trim())) {
                mkb6oc.setSchl(mkb6oc.getSchl().concat("*¹"));
                equal = false;
            }
            if (!getEquipo().trim().equalsIgnoreCase(mkb6oc.getGeraet().trim())) {
                mkb6oc.setGeraet(mkb6oc.getGeraet().concat("*¹"));
                equal = false;
            }
            if (!getNro_producto().trim().equalsIgnoreCase(mkb6oc.getErzeugn().trim())) {
                mkb6oc.setErzeugn(mkb6oc.getErzeugn().concat("*¹"));
                equal = false;
            }
            if (!getCodigo_producto().trim().equalsIgnoreCase(mkb6oc.getEk().trim())) {
                mkb6oc.setEk(mkb6oc.getEk().concat("*¹"));
                equal = false;
            }
            if (!getProveedor().trim().equalsIgnoreCase(mkb6oc.getLie().trim())) {
                mkb6oc.setLie(mkb6oc.getLie().concat("*¹"));
                equal = false;
            }
            if (!getDepartamento_pedido().trim().equalsIgnoreCase(mkb6oc.getBst().trim())) {
                mkb6oc.setBst(mkb6oc.getBst().concat("*¹"));
                equal = false;
            }
            if (!getGrupo_ensayos().trim().equalsIgnoreCase(mkb6oc.getPg().trim())) {
                mkb6oc.setPg(mkb6oc.getPg().concat("*¹"));
                equal = false;
            }
            if (!getRango().trim().equalsIgnoreCase(mkb6oc.getAuslegu().trim())) {
                mkb6oc.setAuslegu(mkb6oc.getAuslegu().concat("*¹"));
                equal = false;
            }
            if (!getCodigo_senal().trim().equalsIgnoreCase(mkb6oc.getSig().trim())) {
                mkb6oc.setSig(mkb6oc.getSig().concat("*¹"));
                equal = false;
            }
            if (!getLugar_montaje().trim().equalsIgnoreCase(mkb6oc.getEinbaup().trim())) {
                mkb6oc.setEinbaup(mkb6oc.getEinbaup().concat("*¹"));
                equal = false;
            }
            if (!getCajas_empalme().trim().equalsIgnoreCase(mkb6oc.getUv().trim())) {
                mkb6oc.setUv(mkb6oc.getUv().concat("*¹"));
                equal = false;
            }
            
            return equal;
        }
        return super.equals(obj);
    }
}