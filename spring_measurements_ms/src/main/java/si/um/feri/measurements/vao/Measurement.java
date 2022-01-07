package si.um.feri.measurements.vao;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import si.um.feri.measurements.Constants;
import si.um.feri.measurements.dto.post.PostMeasurement;

@Entity
@Table(name = "Measurement")
public class Measurement {
	
	public Measurement() {
	}

	public Measurement(PostMeasurement m, Product p) {
		this.value=m.avgTemperature();
		this.bluetoothID=m.bluetoothID();
		this.measurementType=m.measurementType();
		this.subject=Constants.MeasurementSubjects.PRODUCT.getValue();
		this.product=p;
		this.wholesaleId=m.wholesaleId();
	}
	
	public si.um.feri.measurements.dto.Measurement toDto() {
		return new si.um.feri.measurements.dto.Measurement(
			id,
			Constants.JSON_DATE_FORMAT.format(created),
			(product!=null)?product.getProductid():-1,
			value,
			employeeId,
			employee,
			isOk,
			measurementType,
			0,
			wholesaleId
		);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private double value;
	
	private LocalDateTime created=LocalDateTime.now();
	
	private long createdLong=System.currentTimeMillis();
	
	private int subject=Constants.MeasurementSubjects.PRODUCT.getValue();
	
	private String bluetoothID;
	
	private String measurementType;
	
	private int wholesaleId;
	
	private int employeeId=5000;
	
	private String employee="Employee";

	private boolean isOk=true;
	
	@ManyToOne
	private Product product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public long getCreatedLong() {
		return createdLong;
	}

	public void setCreatedLong(long createdLong) {
		this.createdLong = createdLong;
	}

	public int getSubject() {
		return subject;
	}

	public void setSubject(int subject) {
		this.subject = subject;
	}

	public String getBluetoothID() {
		return bluetoothID;
	}

	public void setBluetoothID(String bluetoothID) {
		this.bluetoothID = bluetoothID;
	}

	public String getMeasurementType() {
		return measurementType;
	}

	public void setMeasurementType(String measurementType) {
		this.measurementType = measurementType;
	}

	public int getWholesaleId() {
		return wholesaleId;
	}

	public void setWholesaleId(int wholesaleId) {
		this.wholesaleId = wholesaleId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Measurement [id=" + id + ", value=" + value + ", created=" + created + ", createdLong=" + createdLong
				+ ", subject=" + subject + ", bluetoothID=" + bluetoothID + ", measurementType=" + measurementType
				+ ", wholesaleId=" + wholesaleId + ", employeeId=" + employeeId + ", employee=" + employee + ", isOk="
				+ isOk + ", product=" + product + "]";
	}
	
}
