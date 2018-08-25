package ua.thydope.finalproject.controller.converter;

import java.util.function.Function;

@FunctionalInterface
public interface Converter<S, T> extends Function<S, T> {
  @Override
  T apply(S s);
}