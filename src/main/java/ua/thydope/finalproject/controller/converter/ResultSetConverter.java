package ua.thydope.finalproject.controller.converter;

import java.sql.ResultSet;

@FunctionalInterface
public interface ResultSetConverter<T> extends Converter<ResultSet, T> {
  @Override
  T apply(ResultSet resultSet);
}
