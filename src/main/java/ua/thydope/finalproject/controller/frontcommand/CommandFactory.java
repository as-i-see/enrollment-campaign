package ua.thydope.finalproject.controller.frontcommand;

public class CommandFactory {

  public static Command findGetCommand(String location) {
    switch (location) {
    case "login": {
      return new LoginCommand();
    }
    case "index": {
      return new IndexPageCommand();
    }
    case "signup": {
      return new SignUpCommand();
    }
    default: {
      return new GetBlankCommand();
    }
    }
  }
}
