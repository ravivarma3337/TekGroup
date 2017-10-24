package com.tek.demo.service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tek.demo.Dao.VehicleRepository;
import com.tek.demo.model.Item;

@Service
public class VehicleService {
	private static final AtomicInteger counter = new AtomicInteger();
	@Autowired
	VehicleRepository vehiclerepository;
	private static List<Item> vehicles;

	public List<Item> findAllVehicles() {
		return vehiclerepository.findAll();
	}

	public Item findById(int id) {

		return vehiclerepository.findOne(id);

	}

	public void saveVehicle(Item vehicle) {
		vehicle.setId(counter.incrementAndGet());
		vehiclerepository.save(vehicle);
	}

	public void updateVehicle(Item vehicle) {

		vehiclerepository.save(vehicle);
	}

	/*
	 * public Vehicle findByName(String name) { for (Vehicle vehicle : vehicles) {
	 * if (vehicle.getName().equalsIgnoreCase(name)) { return (Vehicle)
	 * vehicledao.getVehicles(); } } return null; }
	 */

	public void deleteVehicleById(int id) {

		for (Iterator<Item> iterator = vehicles.iterator(); iterator.hasNext();) {
			Item vehicle = iterator.next();
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
