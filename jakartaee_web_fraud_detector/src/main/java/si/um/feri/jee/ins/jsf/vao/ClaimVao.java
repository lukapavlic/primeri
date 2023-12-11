package si.um.feri.jee.ins.jsf.vao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClaimVao {

    private int id;

    private String date=LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    private String policyCode;

    private String claimType;

    private String desc;

    private double fraudProbability;

    public String getDesc() {
        return desc;
    }

    public double getFraudProbability() {
        return fraudProbability;
    }

    public int getFraudProbabilityInt() {
        return (int)(fraudProbability*100.0);
    }

    public void setFraudProbability(double fraudProbability) {
        this.fraudProbability = fraudProbability;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPolicyCode() {
        return policyCode;
    }

    public void setPolicyCode(String policyCode) {
        this.policyCode = policyCode;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    @Override
    public String toString() {
        return "ClaimVao{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", policyCode='" + policyCode + '\'' +
                ", claimType='" + claimType + '\'' +
                ", desc='" + desc + '\'' +
                ", fraudProbability=" + fraudProbability +
                '}';
    }

}
