package si.um.feri.jee.ins.jsf;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.jee.ins.dao.ClaimDao;
import si.um.feri.jee.ins.dao.InsurancePolicyDao;
import si.um.feri.jee.ins.jsf.vao.ClaimVao;
import si.um.feri.jee.ins.jsf.vao.PolicyVao;
import si.um.feri.jee.ins.vao.Claim;
import si.um.feri.jee.ins.vao.InsurancePolicy;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Named("ins")
@SessionScoped
public class InsuranceView implements Serializable {

    private Logger log=Logger.getLogger(InsuranceView.class.getName());

    @EJB
    ClaimDao claimDao;

    @EJB
    InsurancePolicyDao insurancePolicyDao;

    private String client;

    private PolicyVao newPolicy=new PolicyVao();

    private PolicyVao selectedPolicy=new PolicyVao();

    private List<PolicyVao> policies=new ArrayList<>();

    private ClaimVao currentClaim=new ClaimVao();

    public void updateClient() {
        policies=new ArrayList<>();
        currentClaim=new ClaimVao();
        insurancePolicyDao.findAll(client).forEach(p -> policies.add(p.asPolicyVao()));
    }

    public void addNewPolicy(){
        //check dates
        try {
            LocalDate.parse(newPolicy.getAcquiredDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            LocalDate.parse(newPolicy.getAcquiredDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (Exception e) {
            log.info("Error parsing: "+e.getMessage());
            return;
        }

        newPolicy.setAcquirer(client);
        newPolicy.setPolicyCode(client+"-"+newPolicy.getPolicyCode());
        insurancePolicyDao.persist(new InsurancePolicy(newPolicy));
        newPolicy=new PolicyVao();
        updateClient();
    }

    public void selectPolicy(int id) {
        currentClaim=new ClaimVao();
        selectedPolicy=insurancePolicyDao.find(id).asPolicyVao();
        currentClaim.setPolicyCode(selectedPolicy.getPolicyCode());
    }

    public void makeClaim(){
        //InsurancePolicy insurancePolicy=insurancePolicyDao.find(selectedPolicy.getId());
        Claim c=new Claim(currentClaim);
        //insurancePolicy.getClaims().add(c);
        //claimDao.persist(c);
        //insurancePolicyDao.persist(insurancePolicy);
        insurancePolicyDao.addClaimToPolicy(c, selectedPolicy.getId());
        updateClient();
    }

    public PolicyVao getNewPolicy() {
        return newPolicy;
    }

    public void setNewPolicy(PolicyVao newPolicy) {
        this.newPolicy = newPolicy;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public ClaimVao getCurrentClaim() {
        return currentClaim;
    }

    public void setCurrentClaim(ClaimVao currentClaim) {
        this.currentClaim = currentClaim;
    }

    public List<PolicyVao> getPolicies() {
        return policies;
    }

    public void setPolicies(List<PolicyVao> policies) {
        this.policies = policies;
    }

    public PolicyVao getSelectedPolicy() {
        return selectedPolicy;
    }

    public void setSelectedPolicy(PolicyVao selectedPolicy) {
        this.selectedPolicy = selectedPolicy;
    }
}
