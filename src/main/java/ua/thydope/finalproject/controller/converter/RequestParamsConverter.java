package ua.thydope.finalproject.controller.converter;

import java.util.Map;

@FunctionalInterface
public interface RequestParamsConverter<T>
    extends Converter<Map<String, String[]>, T> {
  @Override
  T apply(Map<String, String[]> stringStringMap);
}
