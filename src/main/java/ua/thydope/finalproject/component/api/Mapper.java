package ua.thydope.finalproject.component.api;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

public class Mapper<T extends Entity> extends Entity {
  protected IdentityMap<T> map = new IdentityMap<>();
  protected GenericDao<T> dao;

  public Mapper(GenericDao<T> dao) {
    super(0);
    this.dao = dao;
  }

  public T findByKey(T.Key key) {
    return map.get(key).orElse(/* loadByIdAndRetain(key) */null);
  }

  public List<T> findAll() {
    return dao.findAll();
  }

  public class Key extends Entity.Key {
    Type enclosingMapperGenericType;

    Key() {
      enclosingMapperGenericType = getClass().getEnclosingClass()
          .getTypeParameters()[0].getGenericDeclaration();
    }

    @Override
    public int hashCode() {
      return enclosingMapperGenericType.getTypeName().hashCode();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (o == null)
        return false;
      if (getClass() != o.getClass())
        return false;
      Mapper.Key otherKey = (Mapper.Key) o;
      return Objects.equals(this.enclosingMapperGenericType.getTypeName(),
          otherKey.enclosingMapperGenericType.getTypeName());
    }
  }
}
