package ua.thydope.finalproject.controller.frontcommand;

import javax.servlet.http.HttpServletRequest;

public class GetBlankCommand implements Command {
  @Override
  public String perform(HttpServletRequest req) {
    return "blank.jsp";

  }
}
