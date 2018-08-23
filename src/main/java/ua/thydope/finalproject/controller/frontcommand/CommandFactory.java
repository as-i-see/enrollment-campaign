package ua.thydope.finalproject.controller.frontcommand;

import javax.servlet.http.HttpServletRequest;

public class CommandFactory {

  public static Command getCommand(String location) {
    switch (location) {
      case "subjects":
        return new SubjectsListCommand();
      case "login":
        return new LoginCommand();
      default:
        return new Command() {
          @Override
          public String perform(HttpServletRequest req) {
            return "error.jsp";
          }
        };
    }
  }
}
