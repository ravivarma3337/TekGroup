package com.tek;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class VehicleController {
	@Autowired
	VehicleService vehicleservice;

	// Display list

	@RequestMapping(value = "/vehicle/", method = RequestMethod.GET)
	public ResponseEntity<List<Vehicle>> listAllVehicles() {
		List<Vehicle> vehicles = vehicleservice.findAllVehicles();
		if (vehicles.isEmpty()) {

			return new ResponseEntity<List<Vehicle>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
	}

	// new record creation

	@RequestMapping(value = "/vehicle", method = RequestMethod.POST)
	public ResponseEntity<Void> createVehicle(@RequestBody Vehicle vehicle, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Vehicle " + vehicle.getName());
		vehicleservice.saveVehicle(vehicle);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/vehicle/{id}").buildAndExpand(vehicle.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// Updating existed record

	@RequestMapping(value = "/vehicle/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id") int id, @RequestBody Vehicle vehicle) {
		System.out.println("Updating Vehicle " + id);

		Vehicle currentVehicle = vehicleservice.findById(id);
		currentVehicle.setName(vehicle.getName());
		currentVehicle.setId(vehicle.getId());
		currentVehicle.setPrice(vehicle.getPrice());

		vehicleservice.saveVehicle(currentVehicle);
		return new ResponseEntity<Vehicle>(currentVehicle, HttpStatus.OK);
	}

	// Deleting a record

	@RequestMapping(value = "/vehicle/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Vehicle> deleteVehicle(@PathVariable("id") int id) {
		System.out.println("Fetching & Deleting Vehicle with id " + id);

		Vehicle vehicle = vehicleservice.findById(id);
		if (vehicle == null) {
			System.out.println("Unable to delete. Vehicle with id " + id + " not found");
			return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
		}
		int id1 = (int) id;
		vehicleservice.deleteVehicleById(id1);
		return new ResponseEntity<Vehicle>(HttpStatus.NO_CONTENT);
	}

	// Single record retrieval

	@RequestMapping(value = "/vehicle/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vehicle> getVehicle(@PathVariable("id") int id) {
		System.out.println("Fetching Vehicle with id " + id);
		Vehicle vehicle = vehicleservice.findById(id);
		if (vehicle == null) {
			System.out.println("Vehicle with id " + id + " not found");
			return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
	}

}
