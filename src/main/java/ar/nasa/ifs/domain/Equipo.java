package ar.nasa.ifs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EQUIPMENT_OBJECT_TAB", schema = "IFSATA", catalog = "IFSATA")
public class Equipo {

	private String mchCode;
	private String mchName;
	private String mchPos;
	private String mchLoc;
	private String mchDoc;
	
	@Id
	@Column(name = "MCH_CODE")
	public String getMchCode() {
		return mchCode;
	}
	public void setMchCode(String mchCode) {
		this.mchCode = mchCode;
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
}
