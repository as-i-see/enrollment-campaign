package ua.thydope.finalproject.component.api;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMapper<T> {
  protected Map<Integer, T> loadedMap = new HashMap<>();

  protected abstract String findStatement();

//  protected T abstractFind(Integer id) {
//
//  }
}
