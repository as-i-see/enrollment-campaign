package ua.thydope.finalproject.component.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class IdentityMap<T extends Entity> {
  private Map<Entity.Key, T> map = new HashMap<>();

  public void add(T arg) {
    // TODO simple put maybe
    map.putIfAbsent(arg.new Key(), arg);
  }

  public Optional<T> get(Entity.Key key) {
    return Optional.ofNullable(map.get(key));
  }
}
