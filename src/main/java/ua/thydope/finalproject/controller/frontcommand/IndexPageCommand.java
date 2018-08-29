package ua.thydope.finalproject.controller.frontcommand;

import javax.servlet.http.HttpServletRequest;

public class IndexPageCommand implements Command {
  @Override
  public String perform(HttpServletRequest req) {
    return "index.html";
  }
}
