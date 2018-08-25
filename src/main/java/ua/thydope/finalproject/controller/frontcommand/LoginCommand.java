package ua.thydope.finalproject.controller.frontcommand;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.thydope.finalproject.component.account.Account;
import ua.thydope.finalproject.component.account.AccountService;
import ua.thydope.finalproject.controller.converter.ConversionService;

class LoginCommand implements Command {
  private static final Logger LOGGER = LoggerFactory
      .getLogger("ua.thydope.finalproject.logging.file");

  @Override
  public String perform(HttpServletRequest req) {
    Account targetAccount = ConversionService.convert(req.getParameterMap(),
        Account.class);
    // LOGGER.debug("Got login request with credentials: {} - {}", username,
    // pwd);
    DataSource pool = (DataSource) req.getServletContext().getAttribute("pool");
    AccountService accountService = new AccountService(pool);
    accountService.authorize(targetAccount);
    if (!targetAccount.getRole().equals("GUEST")) {
      // LOGGER.debug("Logged as: {}", account.get().toString());
      req.getSession().setAttribute("account", targetAccount);
      Set<String> activeAccounts = (ConcurrentSkipListSet<String>) req
          .getServletContext().getAttribute("activeAccounts");
      activeAccounts.add(targetAccount.getUsername());
      return "index.jsp";
    }
    return "error.jsp";
  }
}
