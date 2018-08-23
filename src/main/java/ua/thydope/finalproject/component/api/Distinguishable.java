package ua.thydope.finalproject.component.api;

public interface Distinguishable<K extends Distinguishable.Key> {
    interface Key<T extends Distinguishable> extends Comparable<T>{}

    K getKey();
}
