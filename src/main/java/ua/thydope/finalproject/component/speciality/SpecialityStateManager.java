package ua.thydope.finalproject.component.speciality;

import ua.thydope.finalproject.component.api.GenericDAO;
import ua.thydope.finalproject.component.api.Mapper;

public class SpecialityStateManager extends Mapper<Speciality> {

  public SpecialityStateManager(GenericDAO<Speciality> dao) {
    super(dao);
    // TODO Auto-generated constructor stub
  }

  @Override
  protected Speciality loadByIdAndRetain(int id) {
    // TODO Auto-generated method stub
    return null;
  }

}
