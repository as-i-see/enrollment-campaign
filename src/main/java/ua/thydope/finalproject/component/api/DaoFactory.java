package ua.thydope.finalproject.component.api;

public interface DaoFactory {

  GenericDao<? extends Distinguishable> getDao(Class<? extends Distinguishable> klass);
}
