package ua.thydope.finalproject.component.api;

import java.util.List;

public interface Dao<T extends Entity> {
  void create(T entity);

  T findById(int id);

  List<T> findAll();

  void update(T entity);

  void delete(int id);
}
