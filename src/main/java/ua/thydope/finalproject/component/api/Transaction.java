package ua.thydope.finalproject.component.api;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private List<Persistable> newObjects = new ArrayList<>();
    private List<Persistable> dirtyObjects = new ArrayList<>();
    private List<Persistable> deleteObjects = new ArrayList<>();

    public void registerNew(Persistable obj) {
        // TODO
        newObjects.add(obj);
    }

    public void registerDirty(Persistable obj) {
        // TODO
        dirtyObjects.add(obj);
    }

    public void registerRemoved(Persistable obj) {
        // TODO
        deleteObjects.add(obj);
    }

    public void commit() {
        insertNew();
        updateDirty();
        deleteRemoved();
    }

    private void insertNew() {
        newObjects.forEach((obj) -> {
            // TODO
            // MapperRegistry.getMapper(obj.getClass()).insert(obj);
        });
    }

    private void updateDirty() {
        dirtyObjects.forEach((obj) -> {
            // TODO
            // MapperRegistry.getMapper(obj.getClass()).update(obj);
        });
    }

    private void deleteRemoved() {
        deleteObjects.forEach((obj) -> {
            // TODO
            // MapperRegistry.getMapper(obj.getClass()).delete(obj);
        });
    }

}
