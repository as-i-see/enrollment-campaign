package ua.thydope.finalproject.component.account;

import ua.thydope.finalproject.component.api.GenericDao;

import java.util.Optional;

public interface AccountDao extends GenericDao<Account> {
  Optional<Account> findByUsername(String username);
}
