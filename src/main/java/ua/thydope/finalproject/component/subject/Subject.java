package ua.thydope.finalproject.component.subject;

import ua.thydope.finalproject.component.api.Persistable;

public final class Subject{
  private String name;

  Subject(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
