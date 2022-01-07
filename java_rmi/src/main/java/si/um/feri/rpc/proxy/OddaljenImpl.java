package si.um.feri.rpc.proxy;

import java.util.logging.Logger;

public class OddaljenImpl implements Oddaljen {

    static Logger log=Logger.getLogger(OddaljenImpl.class.toString());

    @Override
    public String dajMePozdravit(String takole) {
        log.info("Pozdravljam od daleč!");
        return "Zdravo, "+takole;
    }

}
