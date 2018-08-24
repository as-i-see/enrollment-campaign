package ua.thydope.finalproject.component.api;

public class MapperRegistry {
  private DaoFactory daoFactory;
  private IdentityMap<Mapper> registry;

  public MapperRegistry(DaoFactory daoFactory) {
    this.daoFactory = daoFactory;
  }

  public Mapper<? extends Entity> getMapper(Class<? extends Entity> klass) {
    // return this.daoFactory.getDsao(klass);
    return null;
  }
}
