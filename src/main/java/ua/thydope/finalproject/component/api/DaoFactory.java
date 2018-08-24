package ua.thydope.finalproject.component.api;

public interface DaoFactory {

  <T extends Entity> GenericDao<T> getDao(Class<T> klass);
}
