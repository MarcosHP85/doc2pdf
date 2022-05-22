package ar.nasa.mesa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mkb6f")
public class Mkb6 {
	Integer id;
	String kennzeic;
	String fz;
	String bezeich;
	String r;
	String s;
	String bzkz;
	String o;
	String ver1;
	String ver2;
	String ver3;
	String ver4;
	String ver5;
	String ver6;
	String ver7;
	String vds;
	String msra;
	String plangrup;
	String systplan;
	String fkz;
	String fb;
	String schrank;
	String be;
	String zr;
	String zs;
	String zust1;
	String ba;
	String uebersic;
	String bwert;
	String bera;
	String bere;
	String einheit;
	String zulbtdru;
	String zulbttem;
	String dosis;
	String medium;
	String kl;
	String rltg;
	String si;
	String sa;
	String pl;
	String sl;
	String rl;
	String ns;
	String eb;
	String fe;
	String pzs;
	String sig;
	String raumentn;
	String erst1;
	String rdf1;
	String dn;
	String anord;
	String abs;
	String ep;
	String raumerst;
	String erst2;
	String rdf2;
	String flan;
	String swks;
	String slie;
	String lr;
	String raumgeb;
	String komp;
	String uva;
	String wandd;
	String gwks;
	String zust2;
	String lg;
	String bemerku1;
	String bemerku2;
	List<Mkb6oc> ocs;
	boolean diferente;

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
		return (fz == null) ? "" : fz;
	}
	public void setFz(String fz) {
		this.fz = fz;
	}
	public String getBezeich() {
		return (bezeich == null) ? "" : bezeich;
	}
	public void setBezeich(String bezeich) {
		this.bezeich = bezeich;
	}
	public String getR() {
		return (r == null) ? "" : r;
	}
	public void setR(String r) {
		this.r = r;
	}
	public String getS() {
		return (s == null) ? "" : s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public String getBzkz() {
		return (bzkz == null) ? "" : bzkz;
	}
	public void setBzkz(String bzkz) {
		this.bzkz = bzkz;
	}
	public String getO() {
		return (o == null) ? "" : o;
	}
	public void setO(String o) {
		this.o = o;
	}
	public String getVer1() {
		return (ver1 == null) ? "" : ver1;
	}
	public void setVer1(String ver1) {
		this.ver1 = ver1;
	}
	public String getVer2() {
		return (ver2 == null) ? "" : ver2;
	}
	public void setVer2(String ver2) {
		this.ver2 = ver2;
	}
	public String getVer3() {
		return (ver3 == null) ? "" : ver3;
	}
	public void setVer3(String ver3) {
		this.ver3 = ver3;
	}
	public String getVer4() {
		return (ver4 == null) ? "" : ver4;
	}
	public void setVer4(String ver4) {
		this.ver4 = ver4;
	}
	public String getVer5() {
		return (ver5 == null) ? "" : ver5;
	}
	public void setVer5(String ver5) {
		this.ver5 = ver5;
	}
	public String getVer6() {
		return (ver6 == null) ? "" : ver6;
	}
	public void setVer6(String ver6) {
		this.ver6 = ver6;
	}
	public String getVer7() {
		return (ver7 == null) ? "" : ver7;
	}
	public void setVer7(String ver7) {
		this.ver7 = ver7;
	}
	public String getVds() {
		return (vds == null) ? "" : vds;
	}
	public void setVds(String vds) {
		this.vds = vds;
	}
	public String getMsra() {
		return (msra == null) ? "" : msra;
	}
	public void setMsra(String msra) {
		this.msra = msra;
	}
	public String getPlangrup() {
		return (plangrup == null) ? "" : plangrup;
	}
	public void setPlangrup(String plangrup) {
		this.plangrup = plangrup;
	}
	public String getSystplan() {
		return (systplan == null) ? "" : systplan;
	}
	public void setSystplan(String systplan) {
		this.systplan = systplan;
	}
	public String getFkz() {
		return (fkz == null) ? "" : fkz;
	}
	public void setFkz(String fkz) {
		this.fkz = fkz;
	}
	public String getFb() {
		return (fb == null) ? "" : fb;
	}
	public void setFb(String fb) {
		this.fb = fb;
	}
	public String getSchrank() {
		return (schrank == null) ? "" : schrank;
	}
	public void setSchrank(String schrank) {
		this.schrank = schrank;
	}
	public String getBe() {
		return (be == null) ? "" : be;
	}
	public void setBe(String be) {
		this.be = be;
	}
	public String getZr() {
		return (zr == null) ? "" : zr;
	}
	public void setZr(String zr) {
		this.zr = zr;
	}
	public String getZs() {
		return (zs == null) ? "" : zs;
	}
	public void setZs(String zs) {
		this.zs = zs;
	}
	public String getZust1() {
		return (zust1 == null) ? "" : zust1;
	}
	public void setZust1(String zust1) {
		this.zust1 = zust1;
	}
	public String getBa() {
		return (ba == null) ? "" : ba;
	}
	public void setBa(String ba) {
		this.ba = ba;
	}
	public String getUebersic() {
		return (uebersic == null) ? "" : uebersic;
	}
	public void setUebersic(String uebersic) {
		this.uebersic = uebersic;
	}
	public String getBwert() {
		return (bwert == null) ? "" : bwert;
	}
	public void setBwert(String bwert) {
		this.bwert = bwert;
	}
	public String getBera() {
		return (bera == null) ? "" : bera;
	}
	public void setBera(String bera) {
		this.bera = bera;
	}
	public String getBere() {
		return (bere == null) ? "" : bere;
	}
	public void setBere(String bere) {
		this.bere = bere;
	}
	public String getEinheit() {
		return (einheit == null) ? "" : einheit;
	}
	public void setEinheit(String einheit) {
		this.einheit = einheit;
	}
	public String getZulbtdru() {
		return (zulbtdru == null) ? "" : zulbtdru;
	}
	public void setZulbtdru(String zulbtdru) {
		this.zulbtdru = zulbtdru;
	}
	public String getZulbttem() {
		return (zulbttem == null) ? "" : zulbttem;
	}
	public void setZulbttem(String zulbttem) {
		this.zulbttem = zulbttem;
	}
	public String getDosis() {
		return (dosis == null) ? "" : dosis;
	}
	public void setDosis(String dosis) {
		this.dosis = dosis;
	}
	public String getMedium() {
		return (medium == null) ? "" : medium;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}
	public String getKl() {
		return (kl == null) ? "" : kl;
	}
	public void setKl(String kl) {
		this.kl = kl;
	}
	public String getRltg() {
		return (rltg == null) ? "" : rltg;
	}
	public void setRltg(String rltg) {
		this.rltg = rltg;
	}
	public String getSi() {
		return (si == null) ? "" : si;
	}
	public void setSi(String si) {
		this.si = si;
	}
	public String getSa() {
		return (sa == null) ? "" : sa;
	}
	public void setSa(String sa) {
		this.sa = sa;
	}
	public String getPl() {
		return (pl == null) ? "" : pl;
	}
	public void setPl(String pl) {
		this.pl = pl;
	}
	public String getSl() {
		return (sl == null) ? "" : sl;
	}
	public void setSl(String sl) {
		this.sl = sl;
	}
	public String getRl() {
		return (rl == null) ? "" : rl;
	}
	public void setRl(String rl) {
		this.rl = rl;
	}
	public String getNs() {
		return (ns == null) ? "" : ns;
	}
	public void setNs(String ns) {
		this.ns = ns;
	}
	public String getEb() {
		return (eb == null) ? "" : eb;
	}
	public void setEb(String eb) {
		this.eb = eb;
	}
	public String getFe() {
		return (fe == null) ? "" : fe;
	}
	public void setFe(String fe) {
		this.fe = fe;
	}
	public String getPzs() {
		return (pzs == null) ? "" : pzs;
	}
	public void setPzs(String pzs) {
		this.pzs = pzs;
	}
	public String getSig() {
		return (sig == null) ? "" : sig;
	}
	public void setSig(String sig) {
		this.sig = sig;
	}
	public String getRaumentn() {
		return (raumentn == null) ? "" : raumentn;
	}
	public void setRaumentn(String raumentn) {
		this.raumentn = raumentn;
	}
	public String getErst1() {
		return (erst1 == null) ? "" : erst1;
	}
	public void setErst1(String erst1) {
		this.erst1 = erst1;
	}
	public String getRdf1() {
		return (rdf1 == null) ? "" : rdf1;
	}
	public void setRdf1(String rdf1) {
		this.rdf1 = rdf1;
	}
	public String getDn() {
		return (dn == null) ? "" : dn;
	}
	public void setDn(String dn) {
		this.dn = dn;
	}
	public String getAnord() {
		return (anord == null) ? "" : anord;
	}
	public void setAnord(String anord) {
		this.anord = anord;
	}
	public String getAbs() {
		return (abs == null) ? "" : abs;
	}
	public void setAbs(String abs) {
		this.abs = abs;
	}
	public String getEp() {
		return (ep == null) ? "" : ep;
	}
	public void setEp(String ep) {
		this.ep = ep;
	}
	public String getRaumerst() {
		return (raumerst == null) ? "" : raumerst;
	}
	public void setRaumerst(String raumerst) {
		this.raumerst = raumerst;
	}
	public String getErst2() {
		return (erst2 == null) ? "" : erst2;
	}
	public void setErst2(String erst2) {
		this.erst2 = erst2;
	}
	public String getRdf2() {
		return (rdf2 == null) ? "" : rdf2;
	}
	public void setRdf2(String rdf2) {
		this.rdf2 = rdf2;
	}
	public String getFlan() {
		return (flan == null) ? "" : flan;
	}
	public void setFlan(String flan) {
		this.flan = flan;
	}
	public String getSwks() {
		return (swks == null) ? "" : swks;
	}
	public void setSwks(String swks) {
		this.swks = swks;
	}
	public String getSlie() {
		return (slie == null) ? "" : slie;
	}
	public void setSlie(String slie) {
		this.slie = slie;
	}
	public String getLr() {
		return (lr == null) ? "" : lr;
	}
	public void setLr(String lr) {
		this.lr = lr;
	}
	public String getRaumgeb() {
		return (raumgeb == null) ? "" : raumgeb;
	}
	public void setRaumgeb(String raumgeb) {
		this.raumgeb = raumgeb;
	}
	public String getKomp() {
		return (komp == null) ? "" : komp;
	}
	public void setKomp(String komp) {
		this.komp = komp;
	}
	public String getUva() {
		return (uva == null) ? "" : uva;
	}
	public void setUva(String uva) {
		this.uva = uva;
	}
	public String getWandd() {
		return (wandd == null) ? "" : wandd;
	}
	public void setWandd(String wandd) {
		this.wandd = wandd;
	}
	public String getGwks() {
		return (gwks == null) ? "" : gwks;
	}
	public void setGwks(String gwks) {
		this.gwks = gwks;
	}
	public String getZust2() {
		return (zust2 == null) ? "" : zust2;
	}
	public void setZust2(String zust2) {
		this.zust2 = zust2;
	}
	public String getLg() {
		return (lg == null) ? "" : lg;
	}
	public void setLg(String lg) {
		this.lg = lg;
	}
	public String getBemerku1() {
		return (bemerku1 == null) ? "" : bemerku1;
	}
	public void setBemerku1(String bemerku1) {
		this.bemerku1 = bemerku1;
	}
	public String getBemerku2() {
		return (bemerku2 == null) ? "" : bemerku2;
	}
	public void setBemerku2(String bemerku2) {
		this.bemerku2 = bemerku2;
	}

	@Transient
	public List<Mkb6oc> getOcs() {
		return ocs;
	}
	public void setOcs(List<Mkb6oc> mkb6ocs) {
		this.ocs = mkb6ocs;
	}
    @Transient
    public boolean isDiferente() {
        return diferente;
    }
    public void setDiferente(boolean diferente) {
        this.diferente = diferente;
    }
}
