package si.um.feri.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.um.feri.demo.dao.OsebaRepository;
import si.um.feri.demo.vao.Oseba;
import java.util.logging.Logger;

@RestController
@RequestMapping("/osebe")
public class OsebaController {

    private static final Logger log = Logger.getLogger(OsebaController.class.toString());

    @Autowired
    OsebaRepository dao;

    @GetMapping("/{id}")
    public Oseba getOseba(@PathVariable int id) {
        log.info("Get osebe z id "+id);
        return dao.findById(id).get();
    }

    @PostMapping
    public Oseba postOseba(@RequestBody Oseba oseba) {
        log.info("Dodajanje nove osebe "+oseba);
        return dao.save(oseba);
    }

}
