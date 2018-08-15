package ua.thydope.finalproject.component.account;

import java.util.Objects;
import java.util.Optional;

import ua.thydope.finalproject.component.api.DAOFactory;

public class AccountService {

  /** The accounts dao. */
  private AccountDAO dao = DAOFactory.getInstance().accountDAO();

  /**
   * Returns optional role name of given credentials
   *
   * @param the username
   * @param the pwd
   * @return optional role name
   */
  public Optional<Account> authorize(String username, String pwd) {
    return dao.findByUsername(username)
        .filter(acc -> Objects.equals(pwd, acc.password));
  }
}
