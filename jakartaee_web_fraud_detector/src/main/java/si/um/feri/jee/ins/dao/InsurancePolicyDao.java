package si.um.feri.jee.ins.dao;

import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import si.um.feri.jee.ins.vao.Claim;
import si.um.feri.jee.ins.vao.InsurancePolicy;
import java.util.List;
import java.util.logging.Logger;

@LocalBean
@Stateless
public class InsurancePolicyDao {

    private Logger log=Logger.getLogger(InsurancePolicyDao.class.getName());

    @PersistenceContext
    private EntityManager em;

    @EJB
    ClaimDao claimDao;

    public void persist(InsurancePolicy c) {
        em.persist(c);
        log.info("Persisted: "+c);
    }

    public InsurancePolicy find(int id) {
        return em.find(InsurancePolicy.class,id);
    }

    public InsurancePolicy find(String policyCode) {
        Query q=em.createQuery("select o from InsurancePolicy o where o.policyCode = :code");
        q.setParameter("code",policyCode);
        return (InsurancePolicy)q.getSingleResult();
    }

    public List<InsurancePolicy> findAll(String client) {
        Query q=em.createQuery("select o from InsurancePolicy o where o.acquirer = :client");
        q.setParameter("client",client);
        return q.getResultList();
    }

    public void addClaimToPolicy(Claim c, int insurancePolicyId) {
        InsurancePolicy ip=find(insurancePolicyId);
        //Claim c=claimDao.find(claimId);
        ip.getClaims().add(c);
        em.persist(ip);
    }

}
