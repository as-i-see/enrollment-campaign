package ua.thydope.finalproject.component.account;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Data;
import ua.thydope.finalproject.component.api.Entity;
import ua.thydope.finalproject.component.enrollee.Enrollee;

@Data
public class Account extends Entity implements HttpSessionBindingListener {
  private static final Logger LOGGER = LoggerFactory
      .getLogger("ua.thydope.finalproject.logging.file");

  private String username;
  private String password;
  private AccountType role;
  private Enrollee enrollee;

  public Account(String username, String password) {
    super(null);
    this.username = username;
    this.password = password;
    this.role = AccountType.GUEST;
  }

  public Account(Integer id, String username, String password, String role) {
    super(id);
    this.username = username;
    this.password = password;
    this.role = AccountType.valueOf(role);
  }

  @Override
  public void valueBound(HttpSessionBindingEvent event) {
    LOGGER.debug("Customer [{}] logged in as {}", this.username, this.role);
  }

  @Override
  public void valueUnbound(HttpSessionBindingEvent event) {
    LOGGER.debug("Customer [{}] logged out", this.username);
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public AccountType getRole() {
    return role;
  }

  public void setRole(AccountType role) {
    this.role = role;
  }

  public Enrollee getEnrollee() {
    return enrollee;
  }

  public void setEnrollee(Enrollee enrollee) {
    this.enrollee = enrollee;
  }
}
