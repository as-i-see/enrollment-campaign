package ua.thydope.finalproject.controller.frontcommand;

import javax.servlet.http.HttpServletRequest;

import ua.thydope.finalproject.component.account.Account;

public class IndexPageCommand implements Command {
  @Override
  public String perform(HttpServletRequest req) {
    Account account = (Account) req.getSession().getAttribute("account");
    req.setAttribute("account", account);
    return "specialties.jsp";
  }
}
