package com.hnevkop.workers;

import lombok.Data;

import java.util.Random;

// Response of the worker
public record Result(ID[] response) {}

@Data
class ID {
  private long id;

  public ID() {
    this.id = new Random().nextInt(Integer.MAX_VALUE);
  }
}
