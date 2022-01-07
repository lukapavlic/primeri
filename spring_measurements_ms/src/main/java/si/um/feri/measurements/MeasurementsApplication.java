package si.um.feri.measurements;

import java.util.logging.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import si.um.feri.measurements.dao.ProductRepository;

@SpringBootApplication
public class MeasurementsApplication {

	private static final Logger log = Logger.getLogger(MeasurementsApplication.class.toString());
	
	public static void main(String[] args) {
		SpringApplication.run(MeasurementsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ProductRepository daoProd) {
		return args -> {
			log.info("Ready, Set, Go!");
			new MeasurementsRestServiceInit().populateTestDataIfNotPresent(daoProd);
		};
	}

}
