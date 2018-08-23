package ua.thydope.finalproject.component.speciality;

import java.util.Set;

import ua.thydope.finalproject.component.api.Distinguishable;
import ua.thydope.finalproject.component.enrollee.Enrollee;
import ua.thydope.finalproject.component.criterion.Criterion;

public final class Speciality implements Distinguishable<Speciality.Key> {
  private Key<Speciality> key;
  private String name;
  private int minEntryScore;
  private int licensedVolume;
  private Set<Criterion> criteria;
  private Set<Enrollee> enrollees;

  public class Key<Speciality> implements Distinguishable.Key<ua.thydope.finalproject.component.speciality.Speciality> {
    @Override
    public int compareTo(ua.thydope.finalproject.component.speciality.Speciality speciality) {
      return 0;
    }
  }

  @Override
  public Key getKey() {
    return this.key;
  }
}
