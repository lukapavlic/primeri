package si.um.feri.measurements.jsf;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import si.um.feri.measurements.dao.MeasurementDao;
import si.um.feri.measurements.dao.ProductDao;
import si.um.feri.measurements.vao.Measurement;
import si.um.feri.measurements.vao.Product;

@Named("measurementsapp")
@SessionScoped
public class MeasurementsJsfBean implements Serializable {

	Logger log=Logger.getLogger(MeasurementsJsfBean.class.toString());

	@EJB
	MeasurementDao measurementDao;

	@Getter
	@EJB
	ProductDao productDao;

	@Getter @Setter
	private Product currentProduct=new Product();

	@Getter @Setter
	private double newMeasurementInput;

	@Getter
	private String productViewParam;

	public void setProductViewParam(String productViewParam) {
		this.productViewParam = productViewParam;
		currentProduct=productDao.find(Integer.parseInt(productViewParam));
		if (currentProduct==null) currentProduct=new Product();
	}

	public List<Product> getAllProducts() {
		return productDao.getAll();
	}

	public void addProduct() {
		productDao.save(currentProduct);
		currentProduct=new Product();
	}

	public List<Measurement> getCurrentProductMeasurements() {
		return measurementDao.getAllForProduct(currentProduct);
	}

	public void addMeasurement() {
		measurementDao.save(currentProduct,newMeasurementInput);
		newMeasurementInput=0.0;
	}

}
