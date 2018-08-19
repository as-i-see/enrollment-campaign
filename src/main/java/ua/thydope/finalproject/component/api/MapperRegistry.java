package ua.thydope.finalproject.component.api;

public interface MapperRegistry<T extends Persistable> {
    Mapper<T> getMapper(Class<T> klass);
}
