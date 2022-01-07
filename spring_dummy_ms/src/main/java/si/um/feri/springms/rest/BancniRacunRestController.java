package si.um.feri.springms.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.um.feri.springms.dao.BancniRacunRepository;
import si.um.feri.springms.dao.OsebaRepository;
import si.um.feri.springms.vao.BancniRacun;
import si.um.feri.springms.vao.Oseba;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("racuni")
public class BancniRacunRestController {

        private static final Logger log = Logger.getLogger(BancniRacunRestController.class.toString());

        @Autowired
        private OsebaRepository osebaDao;

        @Autowired
        private BancniRacunRepository bancniRacunDao;

        @GetMapping("/{iban}")
        public BancniRacun getBancniRacun(@PathVariable String iban) {
                log.info("Get bancni racun "+iban);
                return bancniRacunDao.findById(iban).get();
        }

        @PostMapping("/{idOsebe}")
        public BancniRacun kreirajBancniRacun(@RequestBody BancniRacun br,@PathVariable("idOsebe") long id) {
                log.info("Kreiraj bancni racun osebi "+id);
                Optional<Oseba> o=osebaDao.findById(id);
                if (!o.isPresent()) {
                        log.info("Napaka! Oseba ne obstaja (id: "+id+")");
                        return null;
                }
                br.setLastnik(o.get());
                return bancniRacunDao.save(br);
        }

}
