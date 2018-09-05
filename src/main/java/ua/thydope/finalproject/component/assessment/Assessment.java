package ua.thydope.finalproject.component.assessment;

import ua.thydope.finalproject.component.api.Entity;
import ua.thydope.finalproject.component.enrollee.Enrollee;
import ua.thydope.finalproject.component.subject.Subject;

public class Assessment extends Entity {
  private Subject subject;
  private Double grade;
  private Enrollee enrollee;

  public Assessment(Integer id, Subject subject, Double grade) {
    super(id);
    this.subject = subject;
    this.grade = grade;
  }

  public Assessment(Integer id, Subject subject, Enrollee enrollee) {
    super(id);
    this.subject = subject;
    this.enrollee = enrollee;
  }

  public Assessment(Integer id, Double grade) {
    super(id);
    this.grade = grade;
  }

  public Enrollee getEnrollee() {
    return enrollee;
  }

  public void setEnrollee(Enrollee enrollee) {
    this.enrollee = enrollee;
  }

  public Subject getSubject() {
    return subject;
  }

  public void setSubject(Subject subject) {
    this.subject = subject;
  }

  public Double getGrade() {
    return grade;
  }

  public void setGrade(Double grade) {
    this.grade = grade;
  }
}
