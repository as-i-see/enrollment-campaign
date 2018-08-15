package ua.thydope.finalproject.component.subject;

import java.util.List;

import ua.thydope.finalproject.component.api.DAOFactory;

public class SubjectService {
  private SubjectDAO dao = DAOFactory.getInstance().subjectDAO();

  public List<Subject> getAllSubjects() {
    return dao.findAll();
  }

}
