package si.um.feri.jee.ins.dao;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import si.um.feri.jee.ins.vao.Claim;
import java.util.List;
import java.util.logging.Logger;

@LocalBean
@Stateless
public class ClaimDao {

    private Logger log=Logger.getLogger(ClaimDao.class.getName());

    @PersistenceContext
    private EntityManager em;

    public void persist(Claim c) {
        em.persist(c);
        log.info("Persisted: "+c);
    }

    public Claim find(int id) {
        return em.find(Claim.class,id);
    }

    public List<Claim> find(String policyCode) {
        Query q=em.createQuery("select o from Claim o where o.policyCode = :code");
        q.setParameter("code",policyCode);
        return q.getResultList();
    }

}
