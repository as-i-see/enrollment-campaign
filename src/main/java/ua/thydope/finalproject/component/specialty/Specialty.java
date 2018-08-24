package ua.thydope.finalproject.component.specialty;

import java.util.Set;

import ua.thydope.finalproject.component.api.Entity;
import ua.thydope.finalproject.component.criterion.Criterion;
import ua.thydope.finalproject.component.enrollee.Enrollee;

public class Specialty extends Entity {
  private String name;
  private int minEntryScore;
  private int licensedVolume;
  private Set<Criterion> criteria;
  private Set<Enrollee> enrollees;

  public Specialty(Integer id) {
    super(id);
  }
}
