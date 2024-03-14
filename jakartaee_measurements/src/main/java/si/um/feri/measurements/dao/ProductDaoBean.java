package si.um.feri.measurements.dao;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import si.um.feri.measurements.vao.Product;
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

}
