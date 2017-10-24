package com.tek.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tek.demo.model.Car;

public interface CarRepository  extends JpaRepository<Car,Integer>{

}
