package ua.thydope.finalproject.controller.request.command;

import javax.servlet.http.HttpServletRequest;

import ua.thydope.finalproject.component.account.AccountService;
import ua.thydope.finalproject.component.subject.SubjectService;

public class CommandFactory {

  public static Command getCommand(String location) {
    switch (location) {
    case "subjects":
      return new SubjectsListCommand(new SubjectService());
    case "login":
      return new LoginCommand(new AccountService());
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
