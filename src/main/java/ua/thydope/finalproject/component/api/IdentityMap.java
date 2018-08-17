package ua.thydope.finalproject.component.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

//TODO maybe generic key
public final class IdentityMap<T extends Entity> {
  private Map<Integer, T> map = new HashMap<>();

  public void add(T arg) {
    // TODO simple put maybe
    map.putIfAbsent(arg.getId(), arg);
  }

  public Optional<T> get(int key) {
    return Optional.ofNullable(map.get(key));
  }
}
