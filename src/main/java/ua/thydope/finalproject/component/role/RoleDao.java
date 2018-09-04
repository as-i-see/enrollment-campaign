package ua.thydope.finalproject.component.role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.thydope.finalproject.component.api.DBDao;
import ua.thydope.finalproject.controller.converter.ResultSetConverter;

public class RoleDao extends DBDao<Role> {
  public RoleDao(Connection connection) {
    super(connection);
    queries = new RoleQueries();
  }

  @Override
  protected void executeCreate(PreparedStatement ps, Role entity) {

  }

  @Override
  protected ResultSet executeFind(PreparedStatement ps, Integer key) {
    ResultSet rs = null;
    try {
      ps.setInt(1, key);
      rs = ps.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rs;
  }

  @Override
  protected ResultSetConverter<Role> converter() {
    return (ResultSet rs) -> {
      Role role = null;
      try {
        rs.next();
        Integer id = rs.getInt(1);
        String name = rs.getString(2);
        role = new Role(id, name);
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return role;
    };
  }

  private class RoleQueries implements Queries {
    @Override
    public String find() {
      return "SELECT id, name FROM role WHERE id=?";
    }
  }
}
