package ua.thydope.finalproject.controller.frontcommand;

public class CommandFactory {

  public static Command findGetCommand(String location) {
    switch (location) {
    case "subjects": {
      return new SubjectsListCommand();
    }
    case "login": {
      return new LoginCommand();
    }
    default: {
      return new IndexPageCommand();
    }
    }
  }
}
