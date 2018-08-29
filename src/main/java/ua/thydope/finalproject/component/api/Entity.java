package ua.thydope.finalproject.component.api;

import java.util.Objects;

public class Entity {
  private Integer id;

  public Entity(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return this.id;
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }
}
