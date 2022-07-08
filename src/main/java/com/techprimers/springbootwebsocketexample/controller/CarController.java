package com.techprimers.springbootwebsocketexample.controller;

import com.techprimers.springbootwebsocketexample.dto.CarRequest;
import com.techprimers.springbootwebsocketexample.model.Car;
import com.techprimers.springbootwebsocketexample.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CarController {

  @Autowired
  private CarService carService;

  @PostMapping("/car")
  public ResponseEntity<Car> saveCar(@RequestBody CarRequest carDto) {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(carService.save(carDto));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

  }
}
