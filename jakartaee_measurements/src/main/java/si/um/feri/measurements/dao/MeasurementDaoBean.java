package si.um.feri.measurements.dao;

import jakarta.ejb.EJB;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import si.um.feri.measurements.vao.Measurement;
import si.um.feri.measurements.vao.Product;
import java.util.List;

@Stateless
@Local(MeasurementDao.class)
public class MeasurementDaoBean implements MeasurementDao {

    @PersistenceContext
    EntityManager em;

    @EJB
    ProductDao productDao;

    @Override
    public Measurement save(Product p, double currentMeasurement) {
        Product product=productDao.find(p.getId());
        if (product==null) return null;

        Measurement m=new Measurement();
        m.setProduct(product);
        m.setValue(currentMeasurement);
        m.setOk(product.getMinMeasure()<=currentMeasurement && currentMeasurement<=product.getMaxMeasure());
        em.persist(m);

        return m;
    }

    @Override
    public Measurement save(Measurement m) {
        em.persist(m);
        return m;
    }

    @Override
    public List<Measurement> getAllForProduct(Product p) {
        Query q=em.createQuery("select m from Measurement m where m.product.id = :id order by m.created desc");
        q.setParameter("id",p.getId());
        return q.getResultList();
    }

}
