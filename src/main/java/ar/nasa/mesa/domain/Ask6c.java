package ar.nasa.mesa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "askc")
public class Ask6c {
    Integer id;
	String pre1;
	String pre2;
	String kennzeic;
	String fz;
	String bkz;
	String ans;
	String schl;
	String geraet;
	String erzeugn;
	String ek;
	String lie;
	String bst;
	String auslegung;
	String mr;
	String ms;
	String einbaup;
	String uv;

	@Id
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getPre1() {
		return pre1;
	}
	public void setPre1(String pre1) {
		this.pre1 = pre1;
	}
	public String getPre2() {
		return pre2;
	}
	public void setPre2(String pre2) {
		this.pre2 = pre2;
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
	public String getAuslegung() {
		return auslegung;
	}
	public void setAuslegung(String auslegung) {
		this.auslegung = auslegung;
	}
	public String getMr() {
		return mr;
	}
	public void setMr(String mr) {
		this.mr = mr;
	}
	public String getMs() {
		return ms;
	}
	public void setMs(String ms) {
		this.ms = ms;
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
	@Override
	public String toString() {
		return "Ask6c [pre1=" + pre1 + ", pre2=" + pre2 + ", kennzeic=" + kennzeic + ", fz=" + fz + ", bkz=" + bkz
				+ ", ans=" + ans + ", schl=" + schl + ", geraet=" + geraet + ", erzeugn=" + erzeugn + ", ek=" + ek
				+ ", lie=" + lie + ", bst=" + bst + ", auslegung=" + auslegung + ", mr=" + mr + ", ms=" + ms
				+ ", einbaup=" + einbaup + ", uv=" + uv + "]";
	}
	
}
