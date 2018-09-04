package ua.thydope.finalproject.component.assessment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.thydope.finalproject.component.api.DBDao;
import ua.thydope.finalproject.component.api.EntityMapper;
import ua.thydope.finalproject.component.api.MapperRegistry;
import ua.thydope.finalproject.component.enrollee.Enrollee;
import ua.thydope.finalproject.component.subject.Subject;
import ua.thydope.finalproject.controller.converter.ResultSetConverter;

public class AssessmentDao extends DBDao<Assessment> {
  public AssessmentDao(Connection connection) {
    super(connection);
    queries = new AssessmentQueries();
  }

  List<Assessment> findUserAssessments(Enrollee enrollee) {
    List<Assessment> list = new ArrayList<>();
    try {
      PreparedStatement statement = connection
          .prepareStatement(((AssessmentQueries) queries).findByEnrollee());
      statement.setInt(1, enrollee.getId());
      ResultSet rs = statement.executeQuery();
      while (rs.next()) {
        list.add(converter().apply(rs));
      }
      DBDao.closeStatement(statement);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }

  @Override
  protected ResultSetConverter<Assessment> converter() {
    return (ResultSet rs) -> {
      Assessment assessment = null;
      try {
        Integer subject_id = rs.getInt(1);
        EntityMapper<Subject> subjectMapper = MapperRegistry
            .mapperFor(Subject.class);
        Subject subject = subjectMapper.get(subject_id);
        Integer id = rs.getInt(2);
        Double grade = rs.getDouble(3);
        assessment = new Assessment(id, subject, grade);
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return assessment;
    };
  }

  @Override
  protected void executeCreate(PreparedStatement ps, Assessment entity) {

  }

  void create(Integer subjectId, Integer enrolleeId) {
    try {
      PreparedStatement statement = connection
          .prepareStatement(queries.create());
      statement.setInt(1, enrolleeId);
      statement.setInt(2, subjectId);
      statement.executeUpdate();
      DBDao.closeStatement(statement);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private class AssessmentQueries implements Queries {
    @Override
    public String update() {
      return null;
    }

    @Override
    public String find() {
      return null;
    }

    public String findByEnrollee() {
      return "SELECT subject.id, assessment.id, assessment.grade "
          + "FROM assessment RIGHT JOIN (subject) "
          + "ON (subject.id=assessment.subject_id) "
          + "WHERE (assessment.enrollee_id=? OR "
          + "assessment.enrollee_id IS NULL)";
    }

    @Override
    public String create() {
      return "INSERT INTO assessment (enrollee_id, subject_id) "
          + "VALUES (?, ?)";
    }

  }
}
