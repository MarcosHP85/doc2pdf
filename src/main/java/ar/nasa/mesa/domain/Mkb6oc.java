package ar.nasa.mesa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mkb6oc")
public class Mkb6oc {
    Integer id;
    String prek1;
	String prek2;
	String kennzeic;
	String fz;
	String bkz;
	String ans;
	String t;
	String schl;
	String geraet;
	String erzeugn;
	String ek;
	String lie;
	String bst;
	String pg;
	String auslegu;
	String sig;
	String einbaup;
	String uv;

	@Id
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	public String getKennzeic() {
		return kennzeic;
	}
	public void setKennzeic(String kennzeic) {
		this.kennzeic = kennzeic;
	}
	public String getFz() {
		return fz;
	}
	public void setFz(String fz) {
		this.fz = fz;
	}
	public String getBkz() {
		return bkz;
	}
	public void setBkz(String bkz) {
		this.bkz = bkz;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}
	public String getSchl() {
		return schl;
	}
	public void setSchl(String schl) {
		this.schl = schl;
	}
	public String getGeraet() {
		return geraet;
	}
	public void setGeraet(String geraet) {
		this.geraet = geraet;
	}
	public String getErzeugn() {
		return erzeugn;
	}
	public void setErzeugn(String erzeugn) {
		this.erzeugn = erzeugn;
	}
	public String getEk() {
		return ek;
	}
	public void setEk(String ek) {
		this.ek = ek;
	}
	public String getLie() {
		return lie;
	}
	public void setLie(String lie) {
		this.lie = lie;
	}
	public String getBst() {
		return bst;
	}
	public void setBst(String bst) {
		this.bst = bst;
	}
	public String getPg() {
		return pg;
	}
	public void setPg(String pg) {
		this.pg = pg;
	}
	public String getAuslegu() {
		return auslegu;
	}
	public void setAuslegu(String auslegu) {
		this.auslegu = auslegu;
	}
	public String getSig() {
		return sig;
	}
	public void setSig(String sig) {
		this.sig = sig;
	}
	public String getEinbaup() {
		return einbaup;
	}
	public void setEinbaup(String einbaup) {
		this.einbaup = einbaup;
	}
	public String getUv() {
		return uv;
	}
	public void setUv(String uv) {
		this.uv = uv;
	}
	@Column(name = "prek1")
	public String getPrek1() {
		return prek1;
	}
	public void setPrek1(String prek1) {
		this.prek1 = prek1;
	}
    @Column(name = "prek2")
	public String getPrek2() {
		return prek2;
	}
	public void setPrek2(String prek2) {
		this.prek2 = prek2;
	}

    public Mkb6oc() {
    }

    public Mkb6oc(String prek1, String prek2, String kennzeic, String fz, String bkz, String ans, String t, String schl, String geraet, String erzeugn, String ek, String lie, String bst, String pg, String auslegu, String sig, String einbaup, String uv) {
        this.prek1 = prek1;
        this.prek2 = prek2;
        this.kennzeic = kennzeic;
        this.fz = fz;
        this.bkz = bkz;
        this.ans = ans;
        this.t = t;
        this.schl = schl;
        this.geraet = geraet;
        this.erzeugn = erzeugn;
        this.ek = ek;
        this.lie = lie;
        this.bst = bst;
        this.pg = pg;
        this.auslegu = auslegu;
        this.sig = sig;
        this.einbaup = einbaup;
        this.uv = uv;
    }
}
