package si.um.feri.measurements.dao;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import si.um.feri.measurements.vao.Measurement;
import si.um.feri.measurements.vao.Product;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
@Local(ProductDao.class)
public class ProductDaoBean implements ProductDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public Product find(int id) {
        return em.find(Product.class,id);
    }

    @Override
    public Product save(Product p) {
        if (find(p.getId())==null)
            em.persist(p);
        else em.merge(p);
        return p;
    }

    @Override
    public void delete(Product p) {
        em.remove(p);
    }

    @Override
    public List<Product> getAll() {
        return em.createQuery("select p from Product p").getResultList();
    }

    @Override
    public int getProductsCount() {
        List<Product> all=getAll();
        if (all==null) return 0;
        return all.size();
    }

    @Override
    public void insertTestData() {
        Product p1=new Product();
        p1.setName("Milka Classic");
        p1.setMinMeasure(-5.0);
        p1.setMaxMeasure(18.0);
        em.persist(p1);

        em.persist(new Measurement(p1, LocalDateTime.now(), 12, true));
        em.persist(new Measurement(p1, LocalDateTime.now().minusHours(1), 12, true));
        em.persist(new Measurement(p1, LocalDateTime.now().minusHours(2), 11, true));
        em.persist(new Measurement(p1, LocalDateTime.now().minusHours(3), 10, true));
        em.persist(new Measurement(p1, LocalDateTime.now().minusHours(4), 9, true));
        em.persist(new Measurement(p1, LocalDateTime.now().minusHours(5), 19, false));
        em.persist(new Measurement(p1, LocalDateTime.now().minusHours(6), 22, false));
        em.persist(new Measurement(p1, LocalDateTime.now().minusHours(6), 17, true));
        em.persist(new Measurement(p1, LocalDateTime.now().minusHours(6), 19.5, false));

        Product p2=new Product();
        p2.setName("Chicken Breasts");
        p2.setMinMeasure(-25.0);
        p2.setMaxMeasure(-8.0);
        em.persist(p2);

        em.persist(new Measurement(p2, LocalDateTime.now().minusHours(0), -4, false));
        em.persist(new Measurement(p2, LocalDateTime.now().minusHours(1), -5, false));
        em.persist(new Measurement(p2, LocalDateTime.now().minusHours(2), -5, false));
        em.persist(new Measurement(p2, LocalDateTime.now().minusHours(3), -6, false));
        em.persist(new Measurement(p2, LocalDateTime.now().minusHours(4), -7, false));
        em.persist(new Measurement(p2, LocalDateTime.now().minusHours(5), -8, true));
        em.persist(new Measurement(p2, LocalDateTime.now().minusHours(6), -8.5, true));
        em.persist(new Measurement(p2, LocalDateTime.now().minusHours(7), -9, true));
        em.persist(new Measurement(p2, LocalDateTime.now().minusHours(8), -7, false));
        em.persist(new Measurement(p2, LocalDateTime.now().minusHours(9), -6, false));
        em.persist(new Measurement(p2, LocalDateTime.now().minusHours(10), -6, false));
    }

}
