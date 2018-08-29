package ua.thydope.finalproject.component.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityMapper<K, V extends Entity> {
  protected Dao<V> dao;
  private Map<K, V> map = new HashMap<>();

  EntityMapper(Dao<V> dao) {
    this.dao = dao;
  }

  public V get(K key) {
    return map.get(key);
  }

  public List<V> findAll() {
    return dao.findAll();
  }
}
