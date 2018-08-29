package ua.thydope.finalproject.component.role;

import ua.thydope.finalproject.component.api.Entity;

public class Role extends Entity {
  private String name;

  public Role(Integer id) {
    super(id);
  }

  public Role(Integer id, String name) {
    this(id);
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
