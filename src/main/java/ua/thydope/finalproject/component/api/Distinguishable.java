package ua.thydope.finalproject.component.api;

public interface Distinguishable<K extends Distinguishable.Key> {
  K getKey();

  interface Key<T extends Distinguishable> extends Comparable<T> {}
}
