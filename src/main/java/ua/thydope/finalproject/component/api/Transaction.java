package ua.thydope.finalproject.component.api;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
  private List<Distinguishable> newObjects;
  private List<Distinguishable> dirtyObjects;
  private List<Distinguishable> deleteObjects;

  public Transaction() {
    this.newObjects = new ArrayList<>();
    this.dirtyObjects = new ArrayList<>();
    this.deleteObjects = new ArrayList<>();
  }

  public void registerNew(Distinguishable obj) {
    // TODO
    newObjects.add(obj);
  }

  public void registerDirty(Distinguishable obj) {
    // TODO
    dirtyObjects.add(obj);
  }

  public void registerRemoved(Distinguishable obj) {
    // TODO
    deleteObjects.add(obj);
  }

  public void commit(Connection connection) {
    try {
      connection.setAutoCommit(false);
      insertNew();
      updateDirty();
      deleteRemoved();
      connection.commit();
      connection.setAutoCommit(true);
    } catch (SQLException e) {
      // connection.rollback();
      throw new RuntimeException(e);
    }
  }

  private void insertNew() {
    newObjects.forEach(
        (obj) -> {
          // TODO
          // MapperRegistry.getMapper(obj.getClass()).insert(obj);
        });
  }

  private void updateDirty() {
    dirtyObjects.forEach(
        (obj) -> {
          // TODO
          // MapperRegistry.getMapper(obj.getClass()).update(obj);
        });
  }

  private void deleteRemoved() {
    deleteObjects.forEach(
        (obj) -> {
          // TODO
          // MapperRegistry.getMapper(obj.getClass()).delete(obj);
        });
  }
}
