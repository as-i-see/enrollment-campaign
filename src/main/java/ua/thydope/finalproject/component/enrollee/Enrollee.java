package ua.thydope.finalproject.component.enrollee;

import java.util.List;

import ua.thydope.finalproject.component.api.Entity;
import ua.thydope.finalproject.component.assessment.Assessment;
import ua.thydope.finalproject.component.specialty.Specialty;

public class Enrollee extends Entity {
  private String firstName;
  private String lastName;
  private String address;
  private String country;
  private String postcode;
  private String email;
  private String phoneNumber;

  private Specialty chosenSpecialty;
  private List<Assessment> assessments;

  public Enrollee(Integer id) {
    super(id);
  }
}
