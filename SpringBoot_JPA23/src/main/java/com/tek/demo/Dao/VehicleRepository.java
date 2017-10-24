package com.tek.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tek.demo.model.Item;

public interface VehicleRepository  extends JpaRepository<Item,Integer>{

}
