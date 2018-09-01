package ua.thydope.finalproject.controller.converter;

import java.util.HashMap;
import java.util.Map;

import ua.thydope.finalproject.component.account.Account;
import ua.thydope.finalproject.component.account.AccountConverter;
import ua.thydope.finalproject.component.enrollee.Enrollee;
import ua.thydope.finalproject.component.enrollee.EnrolleeConverter;

public class ConversionService {
  private Map<Class<?>, ParamMapConverter<?>> converterMap;

  private ConversionService() {
    converterMap = new HashMap<>();
    converterMap.put(Account.class, AccountConverter.getInstance());
    converterMap.put(Enrollee.class, EnrolleeConverter.getInstance());
  }

  public static ConversionService getInstance() {
    return SingletonHelper.INSTANCE;
  }

  public static <T> T convert(Map<String, String[]> source,
      Class<T> targetType) {
    return (T) getInstance().converterMap.get(targetType).apply(source);
  }

  private static class SingletonHelper {
    private static final ConversionService INSTANCE = new ConversionService();
  }
}
