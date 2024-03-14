package si.um.feri.measurements.vao;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Data @NoArgsConstructor
public class Measurement {

	private static final DateTimeFormatter TIMESTAMP = DateTimeFormatter.ofPattern("dd. MM. yyyy HH:mm:ss");

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "measvalue")
	private double value;
	
	private LocalDateTime created=LocalDateTime.now();
	
	private boolean isOk=true;
	
	@ManyToOne
	private Product product;

	@Transient
	public String getCreatedString() {
		return TIMESTAMP.format(created);
	}

}
