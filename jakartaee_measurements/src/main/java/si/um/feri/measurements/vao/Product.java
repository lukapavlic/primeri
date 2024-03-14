package si.um.feri.measurements.vao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data @NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;

	protected String name="Product";

	protected LocalDateTime created=LocalDateTime.now();

	protected double maxMeasure=10;

	protected double minMeasure=-10;

}
