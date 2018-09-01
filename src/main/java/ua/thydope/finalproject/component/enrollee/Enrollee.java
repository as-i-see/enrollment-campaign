package ua.thydope.finalproject.component.enrollee;

import java.util.List;

import ua.thydope.finalproject.component.api.Entity;
import ua.thydope.finalproject.component.assessment.Assessment;
import ua.thydope.finalproject.component.specialty.Specialty;

public class Enrollee extends Entity {
  public Enrollee(Integer id, String firstName, String lastName, String email, String phone) {
    super(id);
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
  }

  private String firstName;
  private String lastName;
  private String email;
  private String phone;

  private Specialty specialtyChosen;
  private List<Assessment> assessments;

  public Enrollee(Integer id) {
    super(id);
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Specialty getSpecialtyChosen() {
    return specialtyChosen;
  }

  public void setSpecialtyChosen(Specialty specialtyChosen) {
    this.specialtyChosen = specialtyChosen;
  }

  public List<Assessment> getAssessments() {
    return assessments;
  }

  public void setAssessments(List<Assessment> assessments) {
    this.assessments = assessments;
  }

}
