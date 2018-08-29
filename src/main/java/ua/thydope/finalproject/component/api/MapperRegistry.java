package ua.thydope.finalproject.component.api;

import java.util.HashMap;
import java.util.Map;

public class MapperRegistry implements AutoCloseable {
  private static ThreadLocal<MapperRegistry> threadLocal = new ThreadLocal<>();
  private DaoFactory daoFactory;
  private Map<Class<? extends Entity>, EntityMapper<?, ? extends Entity>> map;

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

  public static <K, V extends Entity> EntityMapper<K, V> mapperFor(
      Class<V> klass) {
    EntityMapper<K, V> entityMapper = (EntityMapper<K, V>) getInstance().map
        .get(klass);
    if (entityMapper != null) {
      return entityMapper;
    } else {
      Dao<V> dao = DBDaoFactory.daoFor(klass);
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
