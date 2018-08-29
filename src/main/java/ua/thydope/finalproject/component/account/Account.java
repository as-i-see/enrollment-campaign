package ua.thydope.finalproject.component.account;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Data;
import ua.thydope.finalproject.component.api.Entity;
import ua.thydope.finalproject.component.enrollee.Enrollee;
import ua.thydope.finalproject.component.role.Role;

/**
 * The type Account.
 */
@Data
public class Account extends Entity implements HttpSessionBindingListener {
  private static final Logger LOGGER = LoggerFactory
      .getLogger("ua.thydope.finalproject.logging.file");

  private String username;
  private String password;
  private Role role;
  private Enrollee enrollee;

  /**
   * Instantiates a new Account.
   *
   * @param username the username
   * @param password the password
   */
  public Account(String username, String password) {
    super(null);
    this.username = username;
    this.password = password;
  }

  /**
   * Instantiates a new Account.
   *
   * @param id       the id
   * @param username the username
   * @param password the password
   * @param role     the role
   */
  public Account(Integer id, String username, String password, Role role) {
    super(id);
    this.username = username;
    this.password = password;
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

  /**
   * Gets username.
   *
   * @return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * Sets username.
   *
   * @param username the username
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Gets password.
   *
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets password.
   *
   * @param password the password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Gets role.
   *
   * @return the role
   */
  public Role getRole() {
    return role;
  }

  /**
   * Sets role.
   *
   * @param role the role
   */
  public void setRole(Role role) {
    this.role = role;
  }

  /**
   * Gets enrollee.
   *
   * @return the enrollee
   */
  public Enrollee getEnrollee() {
    return enrollee;
  }

  /**
   * Sets enrollee.
   *
   * @param enrollee the enrollee
   */
  public void setEnrollee(Enrollee enrollee) {
    this.enrollee = enrollee;
  }
}
