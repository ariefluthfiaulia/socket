package com.techprimers.springbootwebsocketexample.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarRequest {
  private Integer speed;
  private Integer condition;
  private Integer gear;
}
