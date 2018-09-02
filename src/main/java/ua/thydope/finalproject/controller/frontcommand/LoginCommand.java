package ua.thydope.finalproject.controller.frontcommand;

import java.util.Objects;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.jdbc.pool.DataSource;

import ua.thydope.finalproject.component.account.Account;
import ua.thydope.finalproject.component.account.AccountService;
import ua.thydope.finalproject.controller.converter.ConversionService;

class LoginCommand implements Command {
  @Override
  public String perform(HttpServletRequest req) {
    Account targetAccount = ConversionService.convert(req.getParameterMap(),
        Account.class);
    if (Objects.isNull(
        req.getServletContext().getAttribute(targetAccount.getUsername()))) {
      DataSource pool = (DataSource) req.getServletContext()
          .getAttribute("pool");
      AccountService accountService = new AccountService(pool);
      accountService.authorize(targetAccount);
      if (Objects.nonNull(targetAccount.getRole_id())) {
        req.getSession().setAttribute("account", targetAccount);
        req.getServletContext().setAttribute(targetAccount.toString(),
            Boolean.TRUE);
        return "specialties.jsp";
      }
    }
    return "blank.jsp";
  }
}
