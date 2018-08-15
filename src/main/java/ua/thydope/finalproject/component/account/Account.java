package ua.thydope.finalproject.component.account;

import java.io.Serializable;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Account implements HttpSessionBindingListener, Serializable {
  private static final long serialVersionUID = 1L;
  private static final Logger LOGGER = LoggerFactory
      .getLogger("ua.thydope.finalproject.logging.file");
  String username;
  String password;
  String role;
  int enrolleeId;

  Account(String username, String password, String role, int enrolleeId) {
    this.username = username;
    this.password = password;
    this.role = role;
    this.enrolleeId = enrolleeId;
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

  public int getEnrolleeId() {
    return enrolleeId;
  }

  public void setEnrolleeId(int enrolleeId) {
    this.enrolleeId = enrolleeId;
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
        + ", role=" + role + ", enrolleeId=" + enrolleeId + "]";
  }

}
