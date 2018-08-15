package ua.thydope.finalproject.component.subject;

import java.util.List;

public class SubjectService {
  private SubjectDAO dao;

  public SubjectService(SubjectDAO dao) {
    this.dao = dao;
  }

  public List<Subject> getAllSubjects() {
    return dao.findAll();
  }

}
