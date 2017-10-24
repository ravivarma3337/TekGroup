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

import com.tek.demo.model.Car;
import com.tek.demo.service.CarService;

@RestController
public class CarController {
	@Autowired
	CarService carservice;

	// List of cars are displayed

	@RequestMapping(value = "/car/", method = RequestMethod.GET)
	public ResponseEntity<List<Car>> listAllCars() {
		List<Car> cars = carservice.findAllCars();
		if (cars.isEmpty()) {

			return new ResponseEntity<List<Car>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
	}

	// Adding new record

	@RequestMapping(value = "/car", method = RequestMethod.POST)
	public ResponseEntity<Void> createCar(@RequestBody Car car, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Car " + car.getName());
		carservice.saveCar(car);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/car/{id}").buildAndExpand(car.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// Updating existed record

	@RequestMapping(value = "/car/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Car> updateCar(@PathVariable("id") int id, @RequestBody Car car) {
		System.out.println("Updating Car " + id);

		Car currentCar = carservice.findById(id);
		currentCar.setName(car.getName());
		currentCar.setId(car.getId());
		currentCar.setPrice(car.getPrice());

		carservice.saveCar(currentCar);
		return new ResponseEntity<Car>(currentCar, HttpStatus.OK);
	}

	// Deleting a record

	@RequestMapping(value = "/car/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Car> deleteCar(@PathVariable("id") int id) {
		System.out.println("Fetching & Deleting Car with id " + id);

		Car car = carservice.findById(id);
		if (car == null) {
			System.out.println("Unable to delete. Car with id " + id + " not found");
			return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
		}
		int id1 = (int) id;
		carservice.deleteCarById(id1);
		return new ResponseEntity<Car>(HttpStatus.NO_CONTENT);
	}

	// Single record retrieval

	@RequestMapping(value = "/car/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Car> getCar(@PathVariable("id") int id) {
		System.out.println("Fetching Car with id " + id);
		Car car = carservice.findById(id);
		if (car == null) {
			System.out.println("Car with id " + id + " not found");
			return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Car>(car, HttpStatus.OK);
	}

}
