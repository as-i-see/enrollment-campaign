package ua.thydope.finalproject.component.speciality;

import ua.thydope.finalproject.component.api.Distinguishable;
import ua.thydope.finalproject.component.criterion.Criterion;
import ua.thydope.finalproject.component.enrollee.Enrollee;

import java.util.Set;

public final class Speciality implements Distinguishable<Speciality.Key> {
  private Key<Speciality> key;
  private String name;
  private int minEntryScore;
  private int licensedVolume;
  private Set<Criterion> criteria;
  private Set<Enrollee> enrollees;

  @Override
  public Key getKey() {
    return this.key;
  }

  public class Key<Speciality>
      implements Distinguishable.Key<ua.thydope.finalproject.component.speciality.Speciality> {
    @Override
    public int compareTo(ua.thydope.finalproject.component.speciality.Speciality speciality) {
      return 0;
    }
  }
}
