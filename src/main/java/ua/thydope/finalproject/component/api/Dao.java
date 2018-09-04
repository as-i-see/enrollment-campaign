package ua.thydope.finalproject.component.api;

import java.util.List;

public interface Dao<T extends Entity> {
  void create(T entity);

  T find(Integer key);

  List<T> findAll();

  void update(T entity);

  void delete(Integer id);
}
