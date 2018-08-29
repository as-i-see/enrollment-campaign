package ua.thydope.finalproject.component.api;

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
    return id;
  }

  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }
}
