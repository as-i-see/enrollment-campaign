package ua.thydope.finalproject.component.subject;

import java.util.Objects;

import ua.thydope.finalproject.component.api.Entity;

public class Subject extends Entity {
  private String name;

  public Subject(String name) {
    super(0);
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
