package si.um.feri.jee.ins.jsf.vao;

import si.um.feri.jee.ins.vao.Codes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;

public class PolicyVao {

    private int id;

    private String acquiredDate=LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    private String validTillDate=LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    private boolean firstCarOwner=true;

    private String carType= Codes.CAR_TYPE_SEDAN;

    private String Acquirer;

    private String policyCode="1-1-1";

    private boolean animals;

    private boolean thunderStorm;

    private boolean vandalism;

    private boolean lights;

    private boolean glasses;

    private List<ClaimVao> claims=new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getValidTillDate() {
        return validTillDate;
    }

    public void setValidTillDate(String validTillDate) {
        this.validTillDate = validTillDate;
    }

    public String getAcquiredDate() {
        return acquiredDate;
    }

    public void setAcquiredDate(String acquiredDate) {
        this.acquiredDate = acquiredDate;
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

    public boolean isAnimals() {
        return animals;
    }

    public void setAnimals(boolean animals) {
        this.animals = animals;
    }

    public boolean isThunderStorm() {
        return thunderStorm;
    }

    public void setThunderStorm(boolean thunderStorm) {
        this.thunderStorm = thunderStorm;
    }

    public boolean isVandalism() {
        return vandalism;
    }

    public void setVandalism(boolean vandalism) {
        this.vandalism = vandalism;
    }

    public boolean isLights() {
        return lights;
    }

    public void setLights(boolean lights) {
        this.lights = lights;
    }

    public boolean isGlasses() {
        return glasses;
    }

    public void setGlasses(boolean glasses) {
        this.glasses = glasses;
    }

    public List<ClaimVao> getClaims() {
        return claims;
    }

    public void setClaims(List<ClaimVao> claims) {
        this.claims = claims;
    }

    @Override
    public String toString() {
        return "PolicyVao{" +
                "id=" + id +
                ", acquiredDate='" + acquiredDate + '\'' +
                ", validTillDate='" + validTillDate + '\'' +
                ", firstCarOwner=" + firstCarOwner +
                ", carType='" + carType + '\'' +
                ", Acquirer='" + Acquirer + '\'' +
                ", policyCode='" + policyCode + '\'' +
                ", animals=" + animals +
                ", thunderStorm=" + thunderStorm +
                ", vandalism=" + vandalism +
                ", lights=" + lights +
                ", glasses=" + glasses +
                ", claims=" + claims +
                '}';
    }

}
