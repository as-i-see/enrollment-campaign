package ua.thydope.finalproject.component.subject;

import ua.thydope.finalproject.component.api.Entity;

public final class Subject implements Entity {
  private int id;
  private String name;

  Subject(int id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
