package si.um.feri.banka;

import java.time.format.DateTimeFormatter;

public interface Constants {

    final static double PRIVZETO_DOVOLJEN_LIMIT_ZLATI_RACUN=-1000.0d;

    final static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

}
