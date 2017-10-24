package com.tek.demo.controller;

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

import com.tek.demo.model.Item;
import com.tek.demo.service.VehicleService;

@RestController
public class VehicleController {
	@Autowired
	VehicleService vehicleservice;

	// Display list

	@RequestMapping(value = "/vehicle/", method = RequestMethod.GET)
	public ResponseEntity<List<Item>> listAllVehicles() {
		List<Item> vehicles = vehicleservice.findAllVehicles();
		if (vehicles.isEmpty()) {

			return new ResponseEntity<List<Item>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Item>>(vehicles, HttpStatus.OK);
	}

	// new record creation

	@RequestMapping(value = "/vehicle", method = RequestMethod.POST)
	public ResponseEntity<Void> createVehicle(@RequestBody Item vehicle, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Vehicle " + vehicle.getName());
		vehicleservice.saveVehicle(vehicle);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/vehicle/{id}").buildAndExpand(vehicle.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// Updating existed record

	@RequestMapping(value = "/vehicle/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Item> updateVehicle(@PathVariable("id") int id, @RequestBody Item vehicle) {
		System.out.println("Updating Vehicle " + id);

		Item currentVehicle = vehicleservice.findById(id);
		currentVehicle.setName(vehicle.getName());
		currentVehicle.setId(vehicle.getId());
		currentVehicle.setPrice(vehicle.getPrice());

		vehicleservice.saveVehicle(currentVehicle);
		return new ResponseEntity<Item>(currentVehicle, HttpStatus.OK);
	}

	// Deleting a record

	@RequestMapping(value = "/vehicle/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Item> deleteVehicle(@PathVariable("id") int id) {
		System.out.println("Fetching & Deleting Vehicle with id " + id);

		Item vehicle = vehicleservice.findById(id);
		if (vehicle == null) {
			System.out.println("Unable to delete. Vehicle with id " + id + " not found");
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}
		int id1 = (int) id;
		vehicleservice.deleteVehicleById(id1);
		return new ResponseEntity<Item>(HttpStatus.NO_CONTENT);
	}

	// Single record retrieval

	@RequestMapping(value = "/vehicle/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Item> getVehicle(@PathVariable("id") int id) {
		System.out.println("Fetching Vehicle with id " + id);
		Item vehicle = vehicleservice.findById(id);
		if (vehicle == null) {
			System.out.println("Vehicle with id " + id + " not found");
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Item>(vehicle, HttpStatus.OK);
	}

}
