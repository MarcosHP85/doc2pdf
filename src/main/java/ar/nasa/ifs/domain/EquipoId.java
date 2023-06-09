package ar.nasa.ifs.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

public class EquipoId implements Serializable {
    private String mchCode;
    private String contract;

    public EquipoId(String mchCode, String contract) {
        this.mchCode = mchCode;
        this.contract = contract;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EquipoId)) return false;
        EquipoId equipoId = (EquipoId) o;
        return Objects.equals(mchCode, equipoId.mchCode) && Objects.equals(contract, equipoId.contract);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mchCode, contract);
    }

    public String getMchCode() {
        return mchCode;
    }

    public void setMchCode(String mchCode) {
        this.mchCode = mchCode;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }
}
