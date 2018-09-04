package ua.thydope.finalproject.component.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class EntityMapper<T extends Entity> {
  private DBDao<T> dao;
  private Map<Integer, T> map = new HashMap<>();

  EntityMapper(DBDao<T> dao) {
    this.dao = dao;
  }

  public T get(Integer key) {
    T value = map.get(key);
    if (Objects.isNull(value)) {
      value = Optional.ofNullable(dao.find(key))
          .orElseThrow(RuntimeException::new);
      map.put(key, value);
    }
    return value;
  }
}
