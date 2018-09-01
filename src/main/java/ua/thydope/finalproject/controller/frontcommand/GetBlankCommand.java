package ua.thydope.finalproject.controller.frontcommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class GetBlankCommand implements Command {
  @Override
  public String perform(HttpServletRequest req) {
    return "blank.jsp";
  }
}
