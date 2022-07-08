package com.techprimers.springbootwebsocketexample.repository;

import com.techprimers.springbootwebsocketexample.model.Car;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

  @Query(nativeQuery = true, value = "SELECT * FROM car WHERE car.\"time\" >= (NOW() - INTERVAL '5 hours')")
  List<Car> getCars();
}
