package ua.thydope.finalproject.controller.frontcommand;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.thydope.finalproject.component.account.Account;
import ua.thydope.finalproject.component.account.AccountService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

class LoginCommand implements Command {
  private static final Logger LOGGER =
      LoggerFactory.getLogger("ua.thydope.finalproject.logging.file");

  @Override
  public String perform(HttpServletRequest req) {
    String username = req.getParameter("login");
    String pwd = req.getParameter("pwd");
    LOGGER.debug("Got login request with credentials: {} - {}", username, pwd);
    try {
      DataSource pool = (DataSource) req.getServletContext().getAttribute("pool");
      AccountService accountService = new AccountService(pool.getConnection());
      Optional<Account> account = accountService.authorize(username, pwd);
      if (account.isPresent()) {
        LOGGER.debug("Logged as: {}", account.get().toString());
        req.getSession().setAttribute("account", account.get());
        Set<String> activeAccounts =
            (ConcurrentSkipListSet<String>) req.getServletContext().getAttribute("activeAccounts");
        activeAccounts.add(username);
        return "index.jsp";
      }
      return "error.jsp";
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
