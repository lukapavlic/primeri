package si.um.feri.measurements.vao;

import java.time.LocalDateTime;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Measurable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;
	
	protected String name;
	
	protected LocalDateTime created=LocalDateTime.now();
	
	protected double maxMeasure;

	protected double minMeasure;
	
	protected int measureCount;
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public double getMaxMeasure() {
		return maxMeasure;
	}

	public void setMaxMeasure(double maxMeasure) {
		this.maxMeasure = maxMeasure;
	}

	public double getMinMeasure() {
		return minMeasure;
	}

	public void setMinMeasure(double minMeasure) {
		this.minMeasure = minMeasure;
	}

	public int getMeasureCount() {
		return measureCount;
	}

	public void setMeasureCount(int measureCount) {
		this.measureCount = measureCount;
	}

	public void setId(int id) {
		this.id = id;
	}

}
