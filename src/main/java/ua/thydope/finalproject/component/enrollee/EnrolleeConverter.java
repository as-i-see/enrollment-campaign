package ua.thydope.finalproject.component.enrollee;

import java.util.Map;

import ua.thydope.finalproject.controller.converter.ParamMapConverter;

public class EnrolleeConverter implements ParamMapConverter<Enrollee> {
  private EnrolleeConverter() {}

  public static EnrolleeConverter getInstance() {
    return SingletonHelper.INSTANCE;
  }

  @Override
  public Enrollee apply(Map<String, String[]> requestMap) {
    Enrollee enrollee = new Enrollee(0);
    String firstName = requestMap.get("fName")[0];
    enrollee.setFirstName(firstName);
    String lastName = requestMap.get("sName")[0];
    enrollee.setLastName(lastName);
    String email = requestMap.get("email")[0];
    enrollee.setEmail(email);
    String phone = requestMap.get("phone")[0];
    enrollee.setPhone(phone);
    return enrollee;
  }

  private static class SingletonHelper {
    private static final EnrolleeConverter INSTANCE = new EnrolleeConverter();
  }
}
