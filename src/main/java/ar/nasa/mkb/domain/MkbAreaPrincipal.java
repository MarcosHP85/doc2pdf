package ar.nasa.mkb.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mkb.area_principal")
public class MkbAreaPrincipal {

    private Integer id;
    private String kks;
    private String kks2;

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
}
