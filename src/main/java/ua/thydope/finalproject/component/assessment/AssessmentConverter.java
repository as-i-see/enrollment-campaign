package ua.thydope.finalproject.component.assessment;

import java.util.Map;

import ua.thydope.finalproject.controller.converter.ParamMapConverter;

public final class AssessmentConverter
    implements ParamMapConverter<Assessment> {
  private AssessmentConverter() {}

  public static AssessmentConverter getInstance() {
    return AssessmentConverter.SingletonHelper.INSTANCE;
  }

  @Override
  public Assessment apply(Map<String, String[]> source) {
    Integer assessmentId = Integer.valueOf(source.get("id")[0]);
    Double grade = Double.valueOf(source.get("grade")[0]);
    return new Assessment(assessmentId, grade);
  }

  private static class SingletonHelper {
    private static final AssessmentConverter INSTANCE = new AssessmentConverter();
  }
}
