package ua.thydope.finalproject.component.api;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Transaction implements AutoCloseable {
  private static ThreadLocal<Transaction> threadLocalTransaction = new ThreadLocal<>();

  private Connection connection;
  private List<Entity> newObjects;
  private List<Entity> dirtyObjects;
  private List<Entity> deleteObjects;

  private Transaction(Connection connection) {
    this.connection = connection;
    this.newObjects = new ArrayList<>();
    this.dirtyObjects = new ArrayList<>();
    this.deleteObjects = new ArrayList<>();
  }

  public static Transaction getInstance() {
    return threadLocalTransaction.get();
  }

  public static void start(Connection connection) {
    threadLocalTransaction.set(new Transaction(connection));
  }

  public static void commit() {
    try {
      Connection connection = getInstance().connection;
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

  public static void registerNew(Entity obj) {
    // TODO
    getInstance().newObjects.add(obj);
  }

  public static void registerDirty(Entity obj) {
    // TODO
    getInstance().dirtyObjects.add(obj);
  }

  public static void registerRemoved(Entity obj) {
    // TODO
    getInstance().deleteObjects.add(obj);
  }

  private static void insertNew() {
    getInstance().newObjects.forEach((obj) -> {
      // TODO
      // MapperRegistry.getMapper(obj.getClass()).insert(obj);
    });
  }

  private static void updateDirty() {
    getInstance().dirtyObjects.forEach((obj) -> {
      // TODO
      // MapperRegistry.getMapper(obj.getClass()).update(obj);
    });
  }

  private static void deleteRemoved() {
    getInstance().deleteObjects.forEach((obj) -> {
      // TODO
      // MapperRegistry.getMapper(obj.getClass()).delete(obj);
    });
  }

  @Override
  public void close() {
    threadLocalTransaction.set(null);
  }
}
