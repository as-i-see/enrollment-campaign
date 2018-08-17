package ua.thydope.finalproject.component.subject;

import ua.thydope.finalproject.component.api.GenericDAO;
import ua.thydope.finalproject.component.api.Mapper;

public class SubjectMapper extends Mapper<Subject> {
  public SubjectMapper(GenericDAO<Subject> dao) {
    super(dao);
    // TODO Auto-generated constructor stub
  }

  @Override
  protected Subject loadByIdAndRetain(int id) {
    Subject entity = this.dao.findById(id);
    this.map.add(entity);
    return entity;
  }
}
