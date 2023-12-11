package si.um.feri.jee.ins.vao;

import jakarta.persistence.*;
import si.um.feri.jee.ins.jsf.vao.PolicyVao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
public class InsurancePolicy {

    public InsurancePolicy() {

    }

    public InsurancePolicy(PolicyVao vao) {
        setAcquirer(vao.getAcquirer());
        setPolicyCode(vao.getPolicyCode());
        setId(vao.getId());
        setCarType(vao.getCarType());
        setFirstCarOwner(vao.isFirstCarOwner());
        if (vao.isAnimals()) getParts().add(Codes.CLAIM_ANIMALS);
        if (vao.isGlasses()) getParts().add(Codes.CLAIM_GLASSES);
        if (vao.isLights()) getParts().add(Codes.CLAIM_LIGHTS);
        if (vao.isThunderStorm()) getParts().add(Codes.CLAIM_THUNDERSTORM);
        if (vao.isVandalism()) getParts().add(Codes.CLAIM_VANDALISM);
        setAcquired(LocalDate.parse(vao.getAcquiredDate(),DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        setValidTill(LocalDate.parse(vao.getValidTillDate(),DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        vao.getClaims().forEach(c->getClaims().add(new Claim(c)));
    }

    public PolicyVao asPolicyVao(){
        PolicyVao ret=new PolicyVao();
        ret.setAcquirer(getAcquirer());
        ret.setId(getId());
        ret.setCarType(getCarType());
        ret.setFirstCarOwner(isFirstCarOwner());
        ret.setPolicyCode(getPolicyCode());
        ret.setAcquiredDate(getAcquired().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        ret.setValidTillDate(getValidTill().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        ret.setAnimals(getParts().contains(Codes.CLAIM_ANIMALS));
        ret.setGlasses(getParts().contains(Codes.CLAIM_GLASSES));
        ret.setLights(getParts().contains(Codes.CLAIM_LIGHTS));
        ret.setThunderStorm(getParts().contains(Codes.CLAIM_THUNDERSTORM));
        ret.setVandalism(getParts().contains(Codes.CLAIM_VANDALISM));
        getClaims().forEach(c->ret.getClaims().add(c.asClaimVao()));
        return ret;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDate acquired=LocalDate.now();

    private LocalDate validTill=LocalDate.now();

    private String acquirer;

    private boolean firstCarOwner=true;

    private String carType= Codes.CAR_TYPE_SEDAN;

    private String policyCode;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> parts=new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Claim> claims=new ArrayList<>();

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

    public LocalDate getValidTill() {
        return validTill;
    }

    public void setValidTill(LocalDate validTill) {
        this.validTill = validTill;
    }

    public String getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(String acquirer) {
        this.acquirer = acquirer;
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

    public boolean isFirstCarOwner() {
        return firstCarOwner;
    }

    public void setFirstCarOwner(boolean firstCarOwner) {
        this.firstCarOwner = firstCarOwner;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "InsurancePolicy{" +
                "id=" + id +
                ", acquired=" + acquired +
                ", validTill=" + validTill +
                ", acquirer='" + acquirer + '\'' +
                ", firstCarOwner=" + firstCarOwner +
                ", carType='" + carType + '\'' +
                ", policyCode='" + policyCode + '\'' +
                ", parts=" + parts +
                ", claims=" + claims +
                '}';
    }

}
