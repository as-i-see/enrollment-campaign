package ua.thydope.finalproject.component.account;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.thydope.finalproject.component.api.Entity;
import ua.thydope.finalproject.component.enrollee.Enrollee;

/**
 * The type Account.
 */
public class Account extends Entity {
  private static final Logger LOGGER = LoggerFactory
      .getLogger("ua.thydope.finalproject.logging.file");

  private String username;
  private String password;
  private Integer role_id;
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
   * @param id the id
   * @param username the username
   * @param password the password
   * @param role the role
   */
  public Account(Integer id, String username, String password,
      Integer role_id) {
    super(id);
    this.username = username;
    this.password = password;
    this.role_id = role_id;
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

  public Integer getRole_id() {
    return role_id;
  }

  public void setRole_id(Integer role_id) {
    this.role_id = role_id;
  }

  /**
   * Gets role.
   *
   * @return the role
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

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    if (!super.equals(o))
      return false;
    Account account = (Account) o;
    return Objects.equals(username, account.username);
  }

  @Override
  public String toString() {
    return username;
  }

  @Override
  public int hashCode() {
    return Objects.hash(username);
  }
}
