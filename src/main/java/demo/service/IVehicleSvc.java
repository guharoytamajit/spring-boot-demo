package demo.service;

import demo.entity.Vehicle;

public interface IVehicleSvc {
	public Vehicle save(Vehicle vehicle);

	public Vehicle update(Vehicle vehicle);

	public Vehicle findByNumber(String number);

	Iterable<Vehicle> findByAll();

	void deleteAll();

	void delete(String number);
}
