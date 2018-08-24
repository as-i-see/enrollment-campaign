package ua.thydope.finalproject.component.assessment;

import ua.thydope.finalproject.component.api.Entity;
import ua.thydope.finalproject.component.enrollee.Enrollee;
import ua.thydope.finalproject.component.subject.Subject;

public class Assessment extends Entity {
  private Enrollee enrollee;
  private Subject subject;
  private Double grade;

  public Assessment(Integer id) {
    super(id);
  }
}
