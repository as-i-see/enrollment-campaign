package ua.thydope.finalproject.component.api;

public class Entity {
  private Integer id;

  public Entity(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
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
