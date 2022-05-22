package ar.nasa.mesa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "askf")
public class Ask6 {
    Integer id;
	String pre1;
	String pre2;
	String kennzeic;
	String fz;
	String bezeich;
	String r;
	String s;
	String bzkz;
	String o;
	String typasbg;
	String verwen;
	String zust1;
	String pzs;
	String vds;
	String msra;
	String fkz;
	String fb;
	String schrank;
	String be;
	String zr;
	String zs;
	String ba;
	String uebersic;
	String sst1;
	String einbau1;
	String sst2;
	String einbau2;
	String schvar;
	String prozenta;
	String tc;
	String sa;
	String systplan;
	String zust2;
	String raumever;
	String plangrup;
	String uva;
	String ep;
	String einbausa;
	String abzwtyp;
	String st;
	String nz;
	String spannv;
	String spanna;
	String ebumschs;
	String ebumscht;
	String u11;
	String us12t;
	String verl;
	String tmax;
	String dold;
	String usz;
	String nbss;
	String nbt;
	String nnbss;
	String nnt;
	String taus;
	String aut;
	String fkplan;
	String sonv;
	String za;
	String bemerku1;
	String bemerku2;
	List<Ask6c> cs;
	boolean diferente;

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
	public String getBezeich() {
		return bezeich;
	}
	public void setBezeich(String bezeich) {
		this.bezeich = bezeich;
	}
	public String getR() {
		return r;
	}
	public void setR(String r) {
		this.r = r;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public String getBzkz() {
		return bzkz;
	}
	public void setBzkz(String bzkz) {
		this.bzkz = bzkz;
	}
	public String getO() {
		return o;
	}
	public void setO(String o) {
		this.o = o;
	}
	public String getTypasbg() {
		return typasbg;
	}
	public void setTypasbg(String typasbg) {
		this.typasbg = typasbg;
	}
	public String getVerwen() {
		return verwen;
	}
	public void setVerwen(String verwen) {
		this.verwen = verwen;
	}
	public String getZust1() {
		return zust1;
	}
	public void setZust1(String zust1) {
		this.zust1 = zust1;
	}
	public String getPzs() {
		return pzs;
	}
	public void setPzs(String pzs) {
		this.pzs = pzs;
	}
	public String getVds() {
		return vds;
	}
	public void setVds(String vds) {
		this.vds = vds;
	}
	public String getMsra() {
		return msra;
	}
	public void setMsra(String msra) {
		this.msra = msra;
	}
	public String getFkz() {
		return fkz;
	}
	public void setFkz(String fkz) {
		this.fkz = fkz;
	}
	public String getFb() {
		return fb;
	}
	public void setFb(String fb) {
		this.fb = fb;
	}
	public String getSchrank() {
		return schrank;
	}
	public void setSchrank(String schrank) {
		this.schrank = schrank;
	}
	public String getBe() {
		return be;
	}
	public void setBe(String be) {
		this.be = be;
	}
	public String getZr() {
		return zr;
	}
	public void setZr(String zr) {
		this.zr = zr;
	}
	public String getZs() {
		return zs;
	}
	public void setZs(String zs) {
		this.zs = zs;
	}
	public String getBa() {
		return ba;
	}
	public void setBa(String ba) {
		this.ba = ba;
	}
	public String getUebersic() {
		return uebersic;
	}
	public void setUebersic(String uebersic) {
		this.uebersic = uebersic;
	}
	public String getSst1() {
		return sst1;
	}
	public void setSst1(String sst1) {
		this.sst1 = sst1;
	}
	public String getEinbau1() {
		return einbau1;
	}
	public void setEinbau1(String einbau1) {
		this.einbau1 = einbau1;
	}
	public String getSst2() {
		return sst2;
	}
	public void setSst2(String sst2) {
		this.sst2 = sst2;
	}
	public String getEinbau2() {
		return einbau2;
	}
	public void setEinbau2(String einbau2) {
		this.einbau2 = einbau2;
	}
	public String getSchvar() {
		return schvar;
	}
	public void setSchvar(String schvar) {
		this.schvar = schvar;
	}
	public String getProzenta() {
		return prozenta;
	}
	public void setProzenta(String prozenta) {
		this.prozenta = prozenta;
	}
	public String getTc() {
		return tc;
	}
	public void setTc(String tc) {
		this.tc = tc;
	}
	public String getSa() {
		return sa;
	}
	public void setSa(String sa) {
		this.sa = sa;
	}
	public String getSystplan() {
		return systplan;
	}
	public void setSystplan(String systplan) {
		this.systplan = systplan;
	}
	public String getZust2() {
		return zust2;
	}
	public void setZust2(String zust2) {
		this.zust2 = zust2;
	}
	public String getRaumever() {
		return raumever;
	}
	public void setRaumever(String raumever) {
		this.raumever = raumever;
	}
	public String getPlangrup() {
		return plangrup;
	}
	public void setPlangrup(String plangrup) {
		this.plangrup = plangrup;
	}
	public String getUva() {
		return uva;
	}
	public void setUva(String uva) {
		this.uva = uva;
	}
	public String getEp() {
		return ep;
	}
	public void setEp(String ep) {
		this.ep = ep;
	}
	public String getEinbausa() {
		return einbausa;
	}
	public void setEinbausa(String einbausa) {
		this.einbausa = einbausa;
	}
	public String getAbzwtyp() {
		return abzwtyp;
	}
	public void setAbzwtyp(String abzwtyp) {
		this.abzwtyp = abzwtyp;
	}
	public String getSt() {
		return st;
	}
	public void setSt(String st) {
		this.st = st;
	}
	public String getNz() {
		return nz;
	}
	public void setNz(String nz) {
		this.nz = nz;
	}
	public String getSpannv() {
		return spannv;
	}
	public void setSpannv(String spannv) {
		this.spannv = spannv;
	}
	public String getSpanna() {
		return spanna;
	}
	public void setSpanna(String spanna) {
		this.spanna = spanna;
	}
	public String getEbumschs() {
		return ebumschs;
	}
	public void setEbumschs(String ebumschs) {
		this.ebumschs = ebumschs;
	}
	public String getEbumscht() {
		return ebumscht;
	}
	public void setEbumscht(String ebumscht) {
		this.ebumscht = ebumscht;
	}
	public String getU11() {
		return u11;
	}
	public void setU11(String u11) {
		this.u11 = u11;
	}
	public String getUs12t() {
		return us12t;
	}
	public void setUs12t(String us12t) {
		this.us12t = us12t;
	}
	public String getVerl() {
		return verl;
	}
	public void setVerl(String verl) {
		this.verl = verl;
	}
	public String getTmax() {
		return tmax;
	}
	public void setTmax(String tmax) {
		this.tmax = tmax;
	}
	public String getDold() {
		return dold;
	}
	public void setDold(String dold) {
		this.dold = dold;
	}
	public String getUsz() {
		return usz;
	}
	public void setUsz(String usz) {
		this.usz = usz;
	}
	public String getNbss() {
		return nbss;
	}
	public void setNbss(String nbss) {
		this.nbss = nbss;
	}
	public String getNbt() {
		return nbt;
	}
	public void setNbt(String nbt) {
		this.nbt = nbt;
	}
	public String getNnbss() {
		return nnbss;
	}
	public void setNnbss(String nnbss) {
		this.nnbss = nnbss;
	}
	public String getNnt() {
		return nnt;
	}
	public void setNnt(String nnt) {
		this.nnt = nnt;
	}
	public String getTaus() {
		return taus;
	}
	public void setTaus(String taus) {
		this.taus = taus;
	}
	public String getAut() {
		return aut;
	}
	public void setAut(String aut) {
		this.aut = aut;
	}
	public String getFkplan() {
		return fkplan;
	}
	public void setFkplan(String fkplan) {
		this.fkplan = fkplan;
	}
	public String getSonv() {
		return sonv;
	}
	public void setSonv(String sonv) {
		this.sonv = sonv;
	}
	public String getZa() {
		return za;
	}
	public void setZa(String za) {
		this.za = za;
	}
	public String getBemerku1() {
		return bemerku1;
	}
	public void setBemerku1(String bemerku1) {
		this.bemerku1 = bemerku1;
	}
	public String getBemerku2() {
		return bemerku2;
	}
	public void setBemerku2(String bemerku2) {
		this.bemerku2 = bemerku2;
	}
    @Transient
	public List<Ask6c> getCs() {
		return cs;
	}
	public void setCs(List<Ask6c> c) {
		this.cs = c;
	}
    @Transient
    public boolean isDiferente() {
        return diferente;
    }
    public void setDiferente(boolean diferente) {
        this.diferente = diferente;
    }
}
