package ua.thydope.finalproject.component.enrollee;

import java.time.LocalDate;
import java.util.Map;

import ua.thydope.finalproject.component.speciality.Speciality;
import ua.thydope.finalproject.component.subject.Subject;

public final class Enrollee {
  private long id;
  private String firstName;
  private String middleName;
  private String lastName;
  private String sex;
  private LocalDate birthDate;
  private String citizenship;
  private String address;
  private String country;
  private String postcode;
  private String email;
  private String internationalPhoneNumber;
  private boolean hostelNeed;

  private Speciality chosenSpeciality;
  private Map<Subject, Double> scores;

}
