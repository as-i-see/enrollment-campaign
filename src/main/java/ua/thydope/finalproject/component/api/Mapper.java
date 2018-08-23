package ua.thydope.finalproject.component.api;

import java.util.List;

public abstract class Mapper<T extends Persistable> {
  protected IdentityMap<T> map = new IdentityMap<>();
  protected GenericDao<T> dao;

  // TODO get dao from factory by T
  public Mapper(GenericDao<T> dao) {
    this.dao = dao;
  }

  public T findById(int id) {
    return map.get(id).orElse(loadByIdAndRetain(id));
  }

  public List<T> findAll() {
    return dao.findAll();
  }

  protected abstract T loadByIdAndRetain(int id);
}
