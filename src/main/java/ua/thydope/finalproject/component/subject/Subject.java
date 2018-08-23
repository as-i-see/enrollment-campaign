package ua.thydope.finalproject.component.subject;

import ua.thydope.finalproject.component.api.Distinguishable;

public final class Subject implements Distinguishable<Subject.Key> {
  private String name;

  Subject(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public class Key<Subject> implements Distinguishable.Key<ua.thydope.finalproject.component.subject.Subject> {
    @Override
    public int compareTo(ua.thydope.finalproject.component.subject.Subject subject) {
      return 0;
    }
  }

  @Override
  public Key getKey() {
    return null;
  }
}
