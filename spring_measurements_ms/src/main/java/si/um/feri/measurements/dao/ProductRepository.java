package si.um.feri.measurements.dao;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import si.um.feri.measurements.vao.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	Optional<Product> findByProductid(int created_id);

}