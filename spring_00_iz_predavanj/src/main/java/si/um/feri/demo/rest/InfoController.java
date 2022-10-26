package si.um.feri.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import si.um.feri.demo.dao.OsebaRepository;
import si.um.feri.demo.vao.Oseba;

@RestController
public class InfoController {

    @Autowired
    OsebaRepository dao;

    @GetMapping("/info")
    public String pozdravi() {
        dao.save(new Oseba("Peter","Klepec"));
        return "Zdravo. Dodali smo eno osebo.";
    }

}
