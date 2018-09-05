package ua.thydope.finalproject.component.assessment;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import ua.thydope.finalproject.component.account.Account;
import ua.thydope.finalproject.component.api.DBDaoFactory;
import ua.thydope.finalproject.component.api.MapperRegistry;
import ua.thydope.finalproject.component.api.Service;
import ua.thydope.finalproject.component.enrollee.Enrollee;
import ua.thydope.finalproject.component.enrollee.EnrolleeDao;
import ua.thydope.finalproject.component.role.Role;
import ua.thydope.finalproject.component.role.RoleDao;

public class AssessmentService extends Service {
  public AssessmentService(DataSource dataSource) {
    super(dataSource);
  }

  public List<Assessment> assessmentList(Account account) {
    try (Connection connection = dataSource.getConnection()) {
      DBDaoFactory.use(connection);
      MapperRegistry.restart();
      RoleDao roleDao = (RoleDao) DBDaoFactory.daoFor(Role.class);
      Role accountRole = roleDao.find(account.getRole_id());
      if (accountRole.getName().equals("USER")) {
        EnrolleeDao enrolleeDao = (EnrolleeDao) DBDaoFactory
            .daoFor(Enrollee.class);
        Enrollee enrollee = enrolleeDao.find(account.getId());
        return getUserAssessments(enrollee);
      } else {
        return listToAssess();
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private List<Assessment> getUserAssessments(Enrollee enrollee) {

    AssessmentDao dao = (AssessmentDao) DBDaoFactory.daoFor(Assessment.class);
    return dao.findUserAssessments(enrollee);
  }

  private List<Assessment> listToAssess() {
    AssessmentDao dao = (AssessmentDao) DBDaoFactory.daoFor(Assessment.class);
    return dao.findAll();
  }

  public void requestAssessment(Integer enrolleeId, Integer subjectId) {
    try (Connection connection = dataSource.getConnection()) {
      DBDaoFactory.use(connection);
      AssessmentDao dao = (AssessmentDao) DBDaoFactory.daoFor(Assessment.class);
      dao.create(subjectId, enrolleeId);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void assess(Assessment assessment) {
    try (Connection connection = dataSource.getConnection()) {
      DBDaoFactory.use(connection);
      AssessmentDao dao = (AssessmentDao) DBDaoFactory.daoFor(Assessment.class);
      dao.update(assessment);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

}
