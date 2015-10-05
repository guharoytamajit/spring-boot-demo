package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.entity.Vehicle;
import demo.exception.VehicleAlreadyExists;
import demo.repo.VehicleDao;

@Service
public class VehicleSvcImpl implements IVehicleSvc {

	@Autowired
	VehicleDao vehicleDao;

	@Override
	public Vehicle save(Vehicle vehicle) {
		if (vehicleDao.exists(vehicle.getNumber())) {
			new VehicleAlreadyExists(vehicle);
		}
		return vehicleDao.save(vehicle);
	}

	@Override
	public Vehicle update(Vehicle vehicle) {
		return vehicleDao.save(vehicle);
	}

	@Override
	public Vehicle findByNumber(String number) {
		return vehicleDao.findOne(number);
	}

	@Override
	public Iterable<Vehicle> findByAll() {
		return vehicleDao.findAll();
	}

	@Override
	public void deleteAll() {
		vehicleDao.deleteAll();
	}

	@Override
	public void delete(String number) {
		vehicleDao.delete(number);
	}

}
