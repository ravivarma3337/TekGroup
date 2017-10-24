package com.tek.demo.service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tek.demo.Dao.CarRepository;
import com.tek.demo.model.Car;

@Service
public class CarService {
	private static final AtomicInteger counter = new AtomicInteger();
	@Autowired
	CarRepository carrepository;
	private static List<Car> cars;

	public List<Car> findAllCars() {
		return carrepository.findAll();
	}

	public Car findById(int id) {

		return carrepository.findOne(id);

	}

	public void saveCar(Car car) {
		car.setId(counter.incrementAndGet());
		carrepository.save(car);
	}

	public void updateCar(Car car) {

		carrepository.save(car);
	}

	/*
	 * public Car findByName(String name) { for (Car car : cars) {
	 * if (car.getName().equalsIgnoreCase(name)) { return (car)
	 * cardao.getCars(); } } return null; }
	 */

	public void deleteCarById(int id) {

		for (Iterator<Car> iterator = cars.iterator(); iterator.hasNext();) {
			Car car = iterator.next();
			if (car.getId() == id) {
				iterator.remove();
			}
		}
	}

	/*
	 * public boolean isCarExist(Car car) { return
	 * findByName(car.getName()) != null; }
	 */

}
