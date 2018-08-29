package ua.thydope.finalproject.component.api;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class EntityMapper<T extends Entity> extends Entity {
  protected Dao<T> dao;
  private Map<T.Key, T> map = new HashMap<>();

  EntityMapper(Dao<T> dao) {
    super(0);
    this.dao = dao;
  }

  public T get(T.Key key) {
    return map.get(key);
  }

  public List<T> findAll() {
    return dao.findAll();
  }

  public class Key extends Entity.Key {
    Type enclosingMapperGenericType = getClass().getEnclosingClass()
        .getTypeParameters()[0].getGenericDeclaration();

    @Override
    public int hashCode() {
      return Objects.hashCode(enclosingMapperGenericType);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (o == null)
        return false;
      if (getClass() != o.getClass())
        return false;
      EntityMapper.Key otherKey = (EntityMapper.Key) o;
      return Objects.equals(this.enclosingMapperGenericType.getTypeName(),
          otherKey.enclosingMapperGenericType.getTypeName());
    }
  }
}
