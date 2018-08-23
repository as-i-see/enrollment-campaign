package ua.thydope.finalproject.component.api;

public class MapperRegistry {
    private DaoFactory daoFactory;
    private IdentityMap<Mapper> registry;

    public MapperRegistry(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public Mapper<? extends Distinguishable> getMapper(Class<? extends Distinguishable> klass) {
        //return this.daoFactory.getDao(klass);
        return null;
    }
}
