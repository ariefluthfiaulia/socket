package com.techprimers.springbootwebsocketexample.service;

import com.techprimers.springbootwebsocketexample.dto.CarRequest;
import com.techprimers.springbootwebsocketexample.dto.CarResponse;
import com.techprimers.springbootwebsocketexample.model.Car;
import com.techprimers.springbootwebsocketexample.repository.CarRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

  @Autowired
  private CarRepository carRepository;

  ModelMapper modelMapper = new ModelMapper();

  public Car save(CarRequest carDto) {
    Car car = modelMapper.map(carDto, Car.class);

    car.setTime(new Date());
    return carRepository.save(car);
  }

  public List<CarResponse> getCarData() {
    List<Car> cars = carRepository.getCars();
    List<CarResponse> responses = new ArrayList<>();

    for (Car car : cars) {
      CarResponse carResponse = new CarResponse(car.getSpeed(), car.getCondition(), car.getGear());
      responses.add(carResponse);
    }

    return responses;
  }
}
