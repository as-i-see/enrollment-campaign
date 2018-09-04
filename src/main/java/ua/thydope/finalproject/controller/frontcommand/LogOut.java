package ua.thydope.finalproject.controller.frontcommand;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

public class LogOut implements Command {
  @Override
  public String perform(HttpServletRequest req) {
    Optional.ofNullable(req.getSession(false)).ifPresent(session -> {
      req.getServletContext()
          .removeAttribute(session.getAttribute("account").toString());
      session.invalidate();
    });
    return "blank.jsp";
  }
}
