package ua.thydope.finalproject.component.subject;

import java.util.List;

import ua.thydope.finalproject.component.api.DAOFactory;
import ua.thydope.finalproject.component.api.Mapper;

public class SubjectService {
  private Mapper<Subject> mapper = new SubjectMapper(
      DAOFactory.getInstance().subjectDAO());

  public List<Subject> getAllSubjects() {
    return mapper.findAll();
  }

}
