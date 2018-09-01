package ua.thydope.finalproject.component.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EntityMapper<T extends Entity> {
  protected DBDao<T> dao;
  private Map<Integer, T> map = new HashMap<>();

  public EntityMapper(DBDao<T> dao) {
    this.dao = dao;
  }

  public T get(Integer key) {
    T value = map.get(key);
    if (Objects.isNull(value)) {
      value = dao.find(key).orElseThrow(RuntimeException::new);
      map.put(key, value);
    }
    return value;
  }

  /*
   * public List<V> findAll() { return dao.findAll(); }
   */
}
