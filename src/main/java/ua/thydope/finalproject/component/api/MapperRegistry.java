package ua.thydope.finalproject.component.api;

import java.util.HashMap;
import java.util.Map;

public class MapperRegistry implements AutoCloseable {
  private static ThreadLocal<MapperRegistry> threadLocal = new ThreadLocal<>();
  private Map<Class<? extends Entity>, EntityMapper<? extends Entity>> map = new HashMap<>();

  private static MapperRegistry getInstance() {
    return threadLocal.get();
  }

  public static <T extends Entity> EntityMapper<T> mapperFor(Class<T> klass) {
    EntityMapper<T> entityMapper = (EntityMapper<T>) getInstance().map
        .get(klass);
    if (entityMapper != null) {
      return entityMapper;
    } else {
      DBDao<T> dao = (DBDao<T>) DBDaoFactory.daoFor(klass);
      entityMapper = new EntityMapper<>(dao);
      getInstance().map.put(klass, entityMapper);
      return entityMapper;
    }
  }

  public static void restart() {
    threadLocal.set(new MapperRegistry());
  }

  @Override
  public void close() {
    threadLocal.set(null);
  }
}
