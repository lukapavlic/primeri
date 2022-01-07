package si.um.feri.measurements.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public record Measurement (
	int id,
	String date,
	int productId,
	double avgTemperature,
	int employeeId,
	String employee,
	boolean isOk,
	String measurementType,
	int location,
	int wholesaleId) {}
