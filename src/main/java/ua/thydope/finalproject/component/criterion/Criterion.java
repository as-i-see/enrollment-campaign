package ua.thydope.finalproject.component.criterion;

import ua.thydope.finalproject.component.api.Entity;
import ua.thydope.finalproject.component.specialty.Specialty;
import ua.thydope.finalproject.component.subject.Subject;

public class Criterion extends Entity {
  // TODO maybe remove the field
  private Specialty specialty;
  private Subject subject;
  private double coefficient;
  private int minScore;

  public Criterion(Integer id) {
    super(id);
  }

}
