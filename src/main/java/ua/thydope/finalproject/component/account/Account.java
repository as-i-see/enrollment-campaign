package ua.thydope.finalproject.component.account;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.thydope.finalproject.component.api.Entity;

public class Account extends Entity implements HttpSessionBindingListener {
  private static final Logger LOGGER = LoggerFactory
      .getLogger("ua.thydope.finalproject.logging.file");

  private String username;
  private String password;
  // TODO change type to ENUM
  private String role;

  public Account(Integer id, String username, String password, String role) {
    super(id);
    this.username = username;
    this.password = password;
    this.role = role;
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

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public void valueBound(HttpSessionBindingEvent event) {
    LOGGER.debug("Customer [{}] logged in as {}", this.username, this.role);
  }

  @Override
  public void valueUnbound(HttpSessionBindingEvent event) {
    LOGGER.debug("Customer [{}] logged out", this.username);
  }

  @Override
  public String toString() {
    return "Account [username=" + username + ", password=" + password
        + ", role=" + role + "]";
  }
}
