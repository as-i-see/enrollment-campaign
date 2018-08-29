package ua.thydope.finalproject.component.enrollee;

import java.util.List;

import ua.thydope.finalproject.component.api.Entity;
import ua.thydope.finalproject.component.assessment.Assessment;
import ua.thydope.finalproject.component.specialty.Specialty;

public class Enrollee extends Entity {
  private String firstName;
  private String lastName;
  private String email;
  private String phone;

  private Specialty specialtyChosen;
  private List<Assessment> assessments;

  public Enrollee(Integer id) {
    super(id);
  }
}
