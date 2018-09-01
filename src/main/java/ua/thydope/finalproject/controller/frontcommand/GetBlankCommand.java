package ua.thydope.finalproject.controller.frontcommand;

import javax.servlet.http.HttpServletRequest;

public class GetBlankCommand implements Command {
  @Override
  public String perform(HttpServletRequest req) {
    if (req.getSession().getAttribute("account") != null) {
      return "specialties.jsp";
    } else
      return "blank.jsp";

  }
}
