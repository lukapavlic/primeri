package si.um.feri.demo.dao;

import org.springframework.data.repository.CrudRepository;
import si.um.feri.demo.vao.Oseba;

public interface OsebaRepository extends CrudRepository<Oseba, Integer>  {
}
