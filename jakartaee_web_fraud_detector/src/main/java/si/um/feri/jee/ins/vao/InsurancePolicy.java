package si.um.feri.jee.ins.vao;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class InsurancePolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDate acquired=LocalDate.now();

    private String Acquirer;

    private String policyCode;

    @ElementCollection
    private List<String> parts;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Claim> claims;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getAcquired() {
        return acquired;
    }

    public void setAcquired(LocalDate acquired) {
        this.acquired = acquired;
    }

    public String getAcquirer() {
        return Acquirer;
    }

    public void setAcquirer(String acquirer) {
        Acquirer = acquirer;
    }

    public String getPolicyCode() {
        return policyCode;
    }

    public void setPolicyCode(String policyCode) {
        this.policyCode = policyCode;
    }

    public List<String> getParts() {
        return parts;
    }

    public void setParts(List<String> parts) {
        this.parts = parts;
    }

    public List<Claim> getClaims() {
        return claims;
    }

    public void setClaims(List<Claim> claims) {
        this.claims = claims;
    }

    @Override
    public String toString() {
        return "InsurancePolicy{" +
                "id=" + id +
                ", acquired=" + acquired +
                ", Acquirer='" + Acquirer + '\'' +
                ", policyCode='" + policyCode + '\'' +
                ", parts=" + parts +
                ", claims=" + claims +
                '}';
    }
    
}
