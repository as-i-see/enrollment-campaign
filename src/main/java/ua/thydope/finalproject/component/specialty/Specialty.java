package ua.thydope.finalproject.component.specialty;

import ua.thydope.finalproject.component.api.Distinguishable;
import ua.thydope.finalproject.component.criterion.Criterion;
import ua.thydope.finalproject.component.enrollee.Enrollee;

import java.util.Set;

public final class Specialty implements Distinguishable<Specialty.Key> {
  private Key<Specialty> key;
  private String name;
  private int minEntryScore;
  private int licensedVolume;
  private Set<Criterion> criteria;
  private Set<Enrollee> enrollees;

  @Override
  public Key getKey() {
    return this.key;
  }

  public class Key<Specialsty>
      implements Distinguishable.Key<Specialty> {
    @Override
    public int compareTo(Specialty specialty) {
      return 0;
    }
  }
}
