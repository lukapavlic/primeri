package si.um.feri.measurements.vao;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product extends Measurable {

	public Product() {
	}

	public Product(si.um.feri.measurements.dto.Product dto) {
		setProductid(dto.id());
		setName(dto.name());
		setMaxMeasure(dto.maxMeasure());
		setMinMeasure(dto.minMeasure());
		setMeasureCount(dto.measureCount());
	}
	
	public void updateFrom(si.um.feri.measurements.dto.Product dto) {
		setProductid(dto.id());
		setName(dto.name());
		setMaxMeasure(dto.maxMeasure());
		setMinMeasure(dto.minMeasure());
		setMeasureCount(dto.measureCount());
	}
	
	public si.um.feri.measurements.dto.Product toDto() {
		return new si.um.feri.measurements.dto.Product(
			getProductid(),
			getName(),
			maxMeasure,
			minMeasure,
			measureCount);
	}
	
	protected int productid;

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + productid + ", id=" + id + ", name=" + name + ", created=" + created
				+ ", maxMeasure=" + maxMeasure + ", minMeasure=" + minMeasure + ", measureCount=" + measureCount + "]";
	}
	
}
