package com.tek;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VehicleService {
	private static final AtomicInteger counter = new AtomicInteger();
	@Autowired
	VehicleRepository vehiclerepository;
	private static List<Vehicle> vehicles;

	public List<Vehicle> findAllVehicles() {
		return vehiclerepository.findAll();
	}

	public Vehicle findById(int id) {

		return vehiclerepository.findOne(id);

	}

	public void saveVehicle(Vehicle vehicle) {
		vehicle.setId(counter.incrementAndGet());
		vehiclerepository.save(vehicle);
	}

	public void updateVehicle(Vehicle vehicle) {

		vehiclerepository.save(vehicle);
	}

	/*
	 * public Vehicle findByName(String name) { for (Vehicle vehicle : vehicles) {
	 * if (vehicle.getName().equalsIgnoreCase(name)) { return (Vehicle)
	 * vehicledao.getVehicles(); } } return null; }
	 */

	public void deleteVehicleById(int id) {

		for (Iterator<Vehicle> iterator = vehicles.iterator(); iterator.hasNext();) {
			Vehicle vehicle = iterator.next();
			if (vehicle.getId() == id) {
				iterator.remove();
			}
		}
	}

	/*
	 * public boolean isVehicleExist(Vehicle vehicle) { return
	 * findByName(vehicle.getName()) != null; }
	 */

}
