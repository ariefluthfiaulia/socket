package com.techprimers.springbootwebsocketexample.config;

import com.techprimers.springbootwebsocketexample.model.Car;
import com.techprimers.springbootwebsocketexample.model.UserResponse;
import com.techprimers.springbootwebsocketexample.repository.CarRepository;
import com.techprimers.springbootwebsocketexample.service.CarService;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class SchedulerConfig {

  @Autowired
  SimpMessagingTemplate template;

  @Autowired
  CarService carService;

  @Scheduled(fixedDelay = 2000)
  public void sendAdhocMessages() {
//    UUID uuid = UUID.randomUUID();
//    String uuidAsString = uuid.toString();
//
//    int gear = (int) Math.floor(Math.random() * (6 - 1 + 1) + 1);
//    int speed = (int) Math.floor(Math.random() * (200 - 0 + 1) + 0);
//
//    Car car = new Car();
//
//    car.setId(uuidAsString);
//    car.setGear(gear);
//    car.setSpeed(speed);

//    Calendar date = Calendar.getInstance();
//    long timeInSecs = date.getTimeInMillis();
//    Date afterAdding10Mins = new Date(timeInSecs + (5 * 60 * 1000));
//
//    System.out.println("After adding 10 mins : " + afterAdding10Mins);
    template.convertAndSend("/topic/user", carService.getCarData());

  }

  @Scheduled(fixedDelay = 2000)
  public void sendAdhocMessagesToRace() {
//    UUID uuid = UUID.randomUUID();
//    String uuidAsString = uuid.toString();
//
//    int gear = (int) Math.floor(Math.random() * (6 - 1 + 1) + 1);
//    int speed = (int) Math.floor(Math.random() * (200 - 0 + 1) + 0);
//
//    Car car = new Car();
//
//    car.setId(uuidAsString);
//    car.setGear(gear);
//    car.setSpeed(100);
    template.convertAndSend("/topic/race", carService.getCarData());
  }
}
