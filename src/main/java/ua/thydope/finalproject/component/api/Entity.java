package ua.thydope.finalproject.component.api;

import java.util.Objects;

public class Entity {
  private Integer id;

  public Entity(Integer id) {
    this.id = id;
  }

  public class Key {

    @Override
    public int hashCode() {
      return Entity.this.id;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (o == null)
        return false;
      if (getClass() != o.getClass())
        return false;
      Entity.Key otherKey = (Entity.Key) o;
      return Objects.equals(this.hashCode(), otherKey.hashCode());
    }
  }
}
