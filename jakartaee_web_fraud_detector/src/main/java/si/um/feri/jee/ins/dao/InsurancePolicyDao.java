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

    public List<InsurancePolicy> findAll(String client) {
        Query q=em.createQuery("select o from InsurancePolicy o where o.acquirer = :client");
        q.setParameter("client",client);
        return q.getResultList();
    }

    public void addClaimToPolicy(Claim c, int insurancePolicyId) {
        InsurancePolicy ip=find(insurancePolicyId);
        claimDao.persist(c);
        ip.getClaims().add(c);
        persist(ip);
    }

}
