package ua.thydope.finalproject.controller.listener;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.thydope.finalproject.component.account.Account;

import javax.naming.InitialContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

@WebListener
public class ContextListener implements ServletContextListener {
  private static final Logger LOGGER =
      LoggerFactory.getLogger("ua.thydope.finalproject.logging.file");

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    Set<Account> activeAccounts = new HashSet<>();
    sce.getServletContext().setAttribute("activeAccounts", activeAccounts);
    LOGGER.debug(
        "Initialized servlets context at {} and created set of active users : {}",
        sce.getServletContext().getContextPath(),
        activeAccounts);
    try {
      InitialContext ctx = new InitialContext();
      DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/enrollment");
      if (ds == null) {
        LOGGER.error("Data source wasn't found!");
        throw new Exception("Data source wasn't found");
      }
      sce.getServletContext().setAttribute("pool", ds);
      LOGGER.debug("Initialized connection pool");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    Optional.ofNullable((Set<String>) sce.getServletContext().getAttribute("activeAccounts"))
        .ifPresent(Set::clear);
    Optional.ofNullable((DataSource) sce.getServletContext().getAttribute("connectionPool"))
        .ifPresent(DataSource::close);
  }
}
