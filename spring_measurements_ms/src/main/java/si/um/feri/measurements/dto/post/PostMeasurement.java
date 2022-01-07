package si.um.feri.measurements.dto.post;

public record PostMeasurement (
	int id,
	double avgTemperature,
	String bluetoothID,
	String measurementType,
	int location,
	int wholesaleId) {}