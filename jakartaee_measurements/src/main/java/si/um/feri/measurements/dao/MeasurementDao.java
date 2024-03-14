package si.um.feri.measurements.dao;

import si.um.feri.measurements.vao.Measurement;
import si.um.feri.measurements.vao.Product;
import java.util.List;

public interface MeasurementDao {

    Measurement save(Measurement m);

    Measurement save(Product p, double currentMeasurement);

    List<Measurement> getAllForProduct(Product p);

}
