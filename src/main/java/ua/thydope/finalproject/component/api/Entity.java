package ua.thydope.finalproject.component.api;

import java.util.Objects;

public class Entity {
  private Integer id;

  public Entity(Integer id) {
    this.id = id;
  }

  public class Key {
    public final Integer id = Entity.this.id;
    private Class<? extends Entity> enclosingClass = Entity.this.getClass();

    @Override
    public int hashCode() {
      return Objects.hash(id, enclosingClass);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (o == null || getClass() != o.getClass())
        return false;
      Entity.Key otherKey = (Entity.Key) o;
      return Objects.equals(enclosingClass, otherKey.enclosingClass)
          && Objects.equals(id, otherKey.id);
    }
  }
}
