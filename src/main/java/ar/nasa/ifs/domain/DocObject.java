package ar.nasa.ifs.domain;

import javax.persistence.*;

@Entity
@Table(name = "DOC_REFERENCE_OBJECT_TAB", schema = "IFSATA", catalog = "IFSATA")
public class DocObject {

    private String docNo;
    private String docClass;
    private String keyRef;
    private FileStorage file;

    @Id
    @Column(name = "DOC_NO")
    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    @Column(name = "DOC_CLASS")
    public String getDocClass() {
        return docClass;
    }

    public void setDocClass(String docClass) {
        this.docClass = docClass;
    }

    @Column(name = "KEY_REF")
    public String getKeyRef() {
        return keyRef;
    }

    public void setKeyRef(String keyRef) {
        this.keyRef = keyRef;
    }

    @OneToOne
    @JoinColumn(name = "DOC_NO")
    public FileStorage getFile() {
        return file;
    }

    public void setFile(FileStorage file) {
        this.file = file;
    }
}
