package ua.thydope.finalproject.component.api;


public interface DaoFactory {

  <T extends Entity> Dao<T> getDao(Class<T> klass);
}
