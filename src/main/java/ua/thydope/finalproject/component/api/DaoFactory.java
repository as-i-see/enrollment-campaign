package ua.thydope.finalproject.component.api;

import ua.thydope.finalproject.component.account.AccountDao;
import ua.thydope.finalproject.component.subject.SubjectDao;

public interface DaoFactory {

  SubjectDao subjectDAO();

  AccountDao accountDAO();

}
