package ua.thydope.finalproject.component.speciality;

import java.util.Set;

import ua.thydope.finalproject.component.api.Persistable;
import ua.thydope.finalproject.component.enrollee.Enrollee;
import ua.thydope.finalproject.component.criterion.Criterion;

public final class Speciality implements Persistable {
  private int id;
  private String name;
  private int minEntryScore;
  private int licensedVolume;
  private Set<Criterion> exams;
  private Set<Enrollee> enrollees;

  @Override
  public int getId() {
    return id;
  }

  @Override
  public void setId(int id) {
    this.id = id;
  }
}
