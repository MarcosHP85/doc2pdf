package ar.nasa.ask.domain;

import ar.nasa.mesa.domain.Ask6c;
import ar.nasa.mesa.domain.Mkb6oc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "area_variable")
public class AskAreaVariable {

    private Integer id;
    private String pre1;
    private String pre2;
    private String kks;
    private String kks2;
    private String codigo_dispositivo;
    private String conexion;
    private String codigo_kwu;
    private String numero_producto;
    private String codigo_producto;
    private String proveedor;
    private String depto_pedido;
    private String diseno_equipo;
    private String redundancia;
    private String tren;
    private String lugar_montaje;
    private String cajas_empalme;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCodigo_kwu() {
        return codigo_kwu == null ? "" : codigo_kwu;
    }

    public void setCodigo_kwu(String codigo_kwu) {
        this.codigo_kwu = codigo_kwu;
    }

    public String getNumero_producto() {
        return numero_producto == null ? "" : numero_producto;
    }

    public void setNumero_producto(String numero_producto) {
        this.numero_producto = numero_producto;
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

    public String getDepto_pedido() {
        return depto_pedido == null ? "" : depto_pedido;
    }

    public void setDepto_pedido(String depto_pedido) {
        this.depto_pedido = depto_pedido;
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

    public String getPre1() {
        return pre1 == null ? "" : pre1;
    }

    public void setPre1(String pre1) {
        this.pre1 = pre1;
    }

    public String getPre2() {
        return pre2 == null ? "" : pre2;
    }

    public void setPre2(String pre2) {
        this.pre2 = pre2;
    }

    public String getDiseno_equipo() {
        return diseno_equipo == null ? "" : diseno_equipo;
    }

    public void setDiseno_equipo(String diseno_equipo) {
        this.diseno_equipo = diseno_equipo;
    }

    public String getRedundancia() {
        return redundancia == null ? "" : redundancia;
    }

    public void setRedundancia(String redundancia) {
        this.redundancia = redundancia;
    }

    public String getTren() {
        return tren == null ? "" : tren;
    }

    public void setTren(String tren) {
        this.tren = tren;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ask6c) {
            Ask6c ask6c = (Ask6c)obj;
            
            boolean equal = true;

            if (!getCodigo_dispositivo().trim().equalsIgnoreCase(ask6c.getBkz().trim())) {
                ask6c.setBkz(ask6c.getBkz().concat("*¹"));
                equal = false;
            }
            if (!getConexion().trim().equalsIgnoreCase(ask6c.getAns().trim())) {
                ask6c.setAns(ask6c.getAns().concat("*¹"));
                equal = false;
            }
            if (!getCodigo_kwu().trim().equalsIgnoreCase(ask6c.getSchl().trim())) {
                ask6c.setSchl(ask6c.getSchl().concat("*¹"));
                equal = false;
            }
            if (!getNumero_producto().trim().equalsIgnoreCase(ask6c.getErzeugn().trim())) {
                ask6c.setErzeugn(ask6c.getErzeugn().concat("*¹"));
                equal = false;
            }
            if (!getCodigo_producto().trim().equalsIgnoreCase(ask6c.getEk().trim())) {
                ask6c.setEk(ask6c.getEk().concat("*¹"));
                equal = false;
            }
            if (!getProveedor().trim().equalsIgnoreCase(ask6c.getLie().trim())) {
                ask6c.setLie(ask6c.getLie().concat("*¹"));
                equal = false;
            }
            if (!getDepto_pedido().trim().equalsIgnoreCase(ask6c.getBst().trim())) {
                ask6c.setBst(ask6c.getBst().concat("*¹"));
                equal = false;
            }
            if (!getLugar_montaje().trim().equalsIgnoreCase(ask6c.getEinbaup().trim())) {
                ask6c.setEinbaup(ask6c.getEinbaup().concat("*¹"));
                equal = false;
            }
            if (!getCajas_empalme().trim().equalsIgnoreCase(ask6c.getUv().trim())) {
                ask6c.setUv(ask6c.getUv().concat("*¹"));
                equal = false;
            }
            if (!getPre1().trim().equalsIgnoreCase(ask6c.getPre1().trim())) {
                ask6c.setPre1(ask6c.getPre1().concat("*¹"));
                equal = false;
            }
            if (!getPre2().trim().equalsIgnoreCase(ask6c.getPre2().trim())) {
                ask6c.setPre2(ask6c.getPre2().concat("*¹"));
                equal = false;
            }
            if (!getDiseno_equipo().trim().equalsIgnoreCase(ask6c.getAuslegung().trim())) {
                ask6c.setAuslegung(ask6c.getAuslegung().concat("*¹"));
                equal = false;
            }
            if (!getRedundancia().trim().equalsIgnoreCase(ask6c.getMr().trim())) {
                ask6c.setMr(ask6c.getMr().concat("*¹"));
                equal = false;
            }
            if (!getTren().trim().equalsIgnoreCase(ask6c.getMs().trim())) {
                ask6c.setMs(ask6c.getMs().concat("*¹"));
                equal = false;
            }
        }
        return super.equals(obj);
    }
}
