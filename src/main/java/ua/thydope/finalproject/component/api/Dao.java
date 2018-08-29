package ua.thydope.finalproject.component.api;

import java.util.List;
import java.util.Optional;

public interface Dao<T extends Entity> {
  void create(T entity);

  Optional<T> find(Integer key);

  List<T> findAll();

  void update(T entity);

  void delete(int id);
}
