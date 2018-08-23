package ua.thydope.finalproject.component.account;

import java.util.Optional;

import ua.thydope.finalproject.component.api.GenericDao;

public interface AccountDao extends GenericDao<Account> {
  Optional<Account> findByUsername(String username);
}
