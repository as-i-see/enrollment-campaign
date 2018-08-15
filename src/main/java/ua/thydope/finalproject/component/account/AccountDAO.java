package ua.thydope.finalproject.component.account;

import java.util.Optional;

import ua.thydope.finalproject.component.api.GenericDAO;

public interface AccountDAO extends GenericDAO<Account> {
  Optional<Account> findByUsername(String username);
}
