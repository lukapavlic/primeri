package si.um.feri.measurements;

import si.um.feri.measurements.dao.ProductRepository;
import si.um.feri.measurements.vao.Product;
import java.util.logging.Logger;

public class MeasurementsRestServiceInit {

	private static final Logger log = Logger.getLogger(MeasurementsRestServiceInit.class.toString());

	void populateTestDataIfNotPresent(
			ProductRepository daoProd
			) {
		if (daoProd.count()>0) {
			log.info("populateTestData - skipped.");
			return;
		}
		log.info("populateTestData initiated.");
		
		Product p1=new Product();
		p1.setName("Product 2.1");
		p1.setProductid(5);
		p1.setMinMeasure(-10.0);
		p1.setMaxMeasure(32.0);
		daoProd.save(p1);

		Product p2=new Product();
		p2.setName("Product 2.2");
		p2.setProductid(6);
		p2.setMinMeasure(-20.0);
		p2.setMaxMeasure(-10.0);
		daoProd.save(p2);
		
	}
	
}
