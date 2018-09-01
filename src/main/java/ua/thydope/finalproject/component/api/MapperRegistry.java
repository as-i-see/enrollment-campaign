package ua.thydope.finalproject.component.api;

import java.util.HashMap;
import java.util.Map;

public class MapperRegistry implements AutoCloseable {
  private static ThreadLocal<MapperRegistry> threadLocal = new ThreadLocal<>();
  private DaoFactory daoFactory;
  private Map<Class<? extends Entity>, EntityMapper<? extends Entity>> map;

  private MapperRegistry(DaoFactory daoFactory) {
    this.map = new HashMap<>();
    this.daoFactory = daoFactory;
  }

  public static MapperRegistry getInstance() {
    return threadLocal.get();
  }

  public static void use(DaoFactory daoFactory) {
    threadLocal.set(new MapperRegistry(daoFactory));
  }

  public static <T extends Entity> EntityMapper<T> mapperFor(Class<T> klass) {
    EntityMapper<T> entityMapper = (EntityMapper<T>) getInstance().map
        .get(klass);
    if (entityMapper != null) {
      return entityMapper;
    } else {
      DBDao<T> dao = (DBDao<T>) getInstance().daoFactory.getDao(klass);
      entityMapper = new EntityMapper<>(dao);
      getInstance().map.put(klass, entityMapper);
      return entityMapper;
    }
  }

  @Override
  public void close() {
    threadLocal.set(null);
  }
}
