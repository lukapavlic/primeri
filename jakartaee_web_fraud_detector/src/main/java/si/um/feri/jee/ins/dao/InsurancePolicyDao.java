package si.um.feri.jee.ins.dao;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import si.um.feri.jee.ins.vao.InsurancePolicy;

@LocalBean
@Stateless
public class InsurancePolicyDao {

    @PersistenceContext
    private EntityManager em;

    public void persist(InsurancePolicy c) {
        em.persist(c);
    }

    public InsurancePolicy find(int id) {
        return em.find(InsurancePolicy.class,id);
    }

    public InsurancePolicy find(String policyCode) {
        Query q=em.createQuery("select o from InsurancePolicy o where o.policyCode = :code");
        q.setParameter("code",policyCode);
        return (InsurancePolicy)q.getSingleResult();
    }
    
}
