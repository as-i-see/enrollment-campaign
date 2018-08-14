package ua.thydope.finalproject.model.dao;

import ua.thydope.finalproject.model.subject.SubjectDAO;

public abstract class DAOFactory {
  private static volatile DAOFactory factory;

  public abstract SubjectDAO subjectDAO();

  public static DAOFactory getInstance() {
    if (factory == null) {
      synchronized (DAOFactory.class) {
        if (factory == null) {
          factory = new JDBCDAOFactory();
        }
      }
    }
    return factory;
  }
}
