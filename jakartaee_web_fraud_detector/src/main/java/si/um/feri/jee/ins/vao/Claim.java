package si.um.feri.jee.ins.vao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import si.um.feri.jee.ins.jsf.vao.ClaimVao;

import java.time.LocalDate;

@Entity
public class Claim {

    public Claim() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDate issued=LocalDate.now();

    private String policyCode;

    private String partCode;

    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getIssued() {
        return issued;
    }

    public void setIssued(LocalDate issued) {
        this.issued = issued;
    }

    public String getPolicyCode() {
        return policyCode;
    }

    public void setPolicyCode(String policyCode) {
        this.policyCode = policyCode;
    }

    public String getPartCode() {
        return partCode;
    }

    public void setPartCode(String partCode) {
        this.partCode = partCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "id=" + id +
                ", issued=" + issued +
                ", policyCode='" + policyCode + '\'' +
                ", partCode='" + partCode + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
