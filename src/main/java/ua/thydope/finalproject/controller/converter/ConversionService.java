package ua.thydope.finalproject.controller.converter;

import java.util.HashMap;
import java.util.Map;

import ua.thydope.finalproject.component.account.Account;
import ua.thydope.finalproject.component.account.AccountConverter;

public class ConversionService {
  private Map<Class<?>, RequestParamsConverter<?>> converterMap;

  private ConversionService() {
    converterMap = new HashMap<>();
    converterMap.put(Account.class, AccountConverter.getInstance());
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
