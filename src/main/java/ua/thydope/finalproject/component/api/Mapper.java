package ua.thydope.finalproject.component.api;

import java.util.List;

public abstract class Mapper<T extends Distinguishable> implements Distinguishable<Mapper.Key>{
  protected IdentityMap<T> map = new IdentityMap<>();
  protected GenericDao<T> dao;

  // TODO get dao from factory by T
  public Mapper(GenericDao<T> dao) {
    this.dao = dao;
  }

  public T findById(T.Key key) {
    return map.get(key).orElse(loadByIdAndRetain(key));
  }

  public List<T> findAll() {
    return dao.findAll();
  }

  protected abstract T loadByIdAndRetain(T.Key id);

  public abstract class Key implements Distinguishable.Key<T> {}

}
