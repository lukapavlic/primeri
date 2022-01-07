package si.um.feri.springms.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import si.um.feri.springms.dao.OsebaRepository;
import si.um.feri.springms.vao.Oseba;
import java.util.logging.Logger;

@RestController
@RequestMapping("osebe")
public class OsebaRestController {

        private static final Logger log = Logger.getLogger(OsebaRestController.class.toString());

        @Autowired
        private OsebaRepository osebaDao;

        @RequestMapping(produces = "text/plain",method = RequestMethod.GET)
        public ResponseEntity<String> getOsebe() {
            return ResponseEntity.ok("To je OsebaRestController");
        }

        @GetMapping("/{id}")
        public Oseba getOseba(@PathVariable long id) {
                log.info("Get osebe z id "+id);
                return osebaDao.findById(id).get();
        }

        @PostMapping
        public Oseba postOseba(@RequestBody Oseba oseba) {
                log.info("Dodajanje nove osebe "+oseba);
                return osebaDao.save(new Oseba(oseba.getEmail(),oseba.getIme(),oseba.getPriimek()));
        }

}
