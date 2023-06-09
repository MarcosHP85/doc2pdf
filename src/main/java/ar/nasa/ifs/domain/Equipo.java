package ar.nasa.ifs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "EQUIPMENT_OBJECT_TAB", schema = "IFSATA", catalog = "IFSATA")
public class Equipo implements Serializable {

	private String mchCode;
	private String mchName;
	private String mchPos;
	private String mchLoc;
	private String mchDoc;
	private String criticality;
	private String contract;

	public Equipo() {
	}

	public Equipo(String mchCode, String mchName, String mchPos, String mchLoc, String mchDoc, String criticality, String contract) {
		this.mchCode = mchCode;
		this.mchName = mchName;
		this.mchPos = mchPos;
		this.mchLoc = mchLoc;
		this.mchDoc = mchDoc;
		this.criticality = criticality;
		this.contract = contract;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Equipo)) return false;
		Equipo equipo = (Equipo) o;
		return Objects.equals(mchCode, equipo.mchCode) && Objects.equals(mchName, equipo.mchName) && Objects.equals(mchPos, equipo.mchPos) && Objects.equals(mchLoc, equipo.mchLoc) && Objects.equals(mchDoc, equipo.mchDoc) && Objects.equals(criticality, equipo.criticality) && Objects.equals(contract, equipo.contract);
	}

	@Override
	public int hashCode() {
		return Objects.hash(mchCode, mchName, mchPos, mchLoc, mchDoc, criticality, contract);
	}

	@Id
	@Column(name = "MCH_CODE")
	public String getMchCode() {
		return mchCode;
	}
	public void setMchCode(String mchCode) {
		this.mchCode = mchCode;
	}

	@Id
	@Column(name = "CONTRACT")
	public String getContract() {
		return contract;
	}
	public void setContract(String contract) {
		this.contract = contract;
	}

	@Column(name = "MCH_NAME")
	public String getMchName() {
		return mchName;
	}
	public void setMchName(String mchName) {
		this.mchName = mchName;
	}
	
	@Column(name = "MCH_POS")
	public String getMchPos() {
		return mchPos;
	}
	public void setMchPos(String mchPos) {
		this.mchPos = mchPos;
	}
	
	@Column(name = "MCH_DOC")
	public String getMchDoc() {
		return mchDoc;
	}
	public void setMchDoc(String mchDoc) {
		this.mchDoc = mchDoc;
	}
	
	@Column(name = "MCH_LOC")
	public String getMchLoc() {
		return mchLoc;
	}
	public void setMchLoc(String mchLoc) {
		this.mchLoc = mchLoc;
	}

	@Column(name = "CRITICALITY")
	public String getCriticality() {
		return criticality;
	}
	public void setCriticality(String criticality) {
		this.criticality = criticality;
	}
}
