package com.techprimers.springbootwebsocketexample.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarResponse {

  private Integer speed;
  private Integer condition;
  private String gear;

  public CarResponse(Integer speed, Integer condition, Integer gear) {
    this.speed = speed;
    this.condition = condition;
    if (gear == 6) {
      this.gear = "R";
    } else {
      this.gear = gear + "";
    }
  }
}
