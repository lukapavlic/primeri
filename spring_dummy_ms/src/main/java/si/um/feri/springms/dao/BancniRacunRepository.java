package si.um.feri.springms.dao;

import org.springframework.data.repository.CrudRepository;
import si.um.feri.springms.vao.BancniRacun;
import si.um.feri.springms.vao.Oseba;
import java.util.List;

public interface BancniRacunRepository extends CrudRepository<BancniRacun, String> {

    List<BancniRacun> findByLastnik(Oseba lastnik);

}
