package com.metao.java8.designpatterns.dp.saga.orchestration;

public class FlyBookingService extends Service<String> {
  @Override
  public String getName() {
    return "booking a Fly";
  }
}
