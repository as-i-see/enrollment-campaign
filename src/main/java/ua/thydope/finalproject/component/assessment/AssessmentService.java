package ua.thydope.finalproject.component.assessment;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import ua.thydope.finalproject.component.account.Account;
import ua.thydope.finalproject.component.api.DBDaoFactory;
import ua.thydope.finalproject.component.api.MapperRegistry;
import ua.thydope.finalproject.component.api.Service;
import ua.thydope.finalproject.component.role.Role;
import ua.thydope.finalproject.component.role.RoleDao;

public class AssessmentService extends Service {
  public AssessmentService(DataSource dataSource) {
    super(dataSource);
  }

  public List<Assessment> assessmentList(Account account) {
    try (Connection connection = dataSource.getConnection()) {
      DBDaoFactory.use(connection);
      MapperRegistry.use(DBDaoFactory.getInstance());
      RoleDao roleDao = (RoleDao) DBDaoFactory.daoFor(Role.class);
      Role accountRole = roleDao.find(account.getRole_id());
      if (accountRole.getName().equals("USER")) {
        return getUserAssessments(account);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return Collections.emptyList();
  }

  private List<Assessment> getUserAssessments(Account account) {

  }

}

