package ar.nasa.ifs.domain;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "EDM_FILE_STORAGE_TAB", schema = "IFSATA", catalog = "IFSATA")
public class FileStorage {

    private String docNo;
    private Blob fileData;

    @Id
    @Column(name = "DOC_NO")
    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    @Lob
    @Column(name = "FILE_DATA")
    public Blob getFileData() {
        return fileData;
    }

    public void setFileData(Blob fileData) {
        this.fileData = fileData;
    }
}
