package ua.thydope.finalproject.model.speciality;

import java.util.Set;

import ua.thydope.finalproject.model.enrollee.Enrollee;
import ua.thydope.finalproject.model.examination.Examination;

public final class Speciality {
  private long id;
  private String name;
  private int minEntryScore;
  private int licensedVolume;
  private Set<Examination> exams;
  private Set<Enrollee> enrollees;
}
