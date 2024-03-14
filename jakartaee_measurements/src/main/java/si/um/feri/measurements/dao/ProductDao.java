package si.um.feri.measurements.dao;

import si.um.feri.measurements.vao.Product;
import java.util.List;

public interface ProductDao {

    Product save(Product p);

    void delete(Product p);

    List<Product> getAll();

    Product find(int id);

    int getProductsCount();

    void insertTestData();

}
