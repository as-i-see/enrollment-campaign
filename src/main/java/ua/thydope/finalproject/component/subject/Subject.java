package ua.thydope.finalproject.component.subject;

import ua.thydope.finalproject.component.api.Entity;

public class Subject extends Entity {
  private String name;

  Subject(Integer id, String name) {
    super(id);
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
