package ua.thydope.finalproject.controller.frontcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.jdbc.pool.DataSource;

import ua.thydope.finalproject.component.account.Account;
import ua.thydope.finalproject.component.account.AccountService;
import ua.thydope.finalproject.component.enrollee.Enrollee;
import ua.thydope.finalproject.component.enrollee.EnrolleeService;
import ua.thydope.finalproject.controller.converter.ConversionService;

public class SignUpCommand implements Command {
  @Override
  public String perform(HttpServletRequest req) {
    Map<String, String[]> requestParams = req.getParameterMap();
    DataSource pool = (DataSource) req.getServletContext().getAttribute("pool");

    Account account = ConversionService.convert(requestParams, Account.class);
    Enrollee enrollee = ConversionService.convert(requestParams,
        Enrollee.class);

    account.setEnrollee(enrollee);
    EnrolleeService enrolleeService = new EnrolleeService(pool);
    enrolleeService.register(account);
    req.getSession().setAttribute("account", account);
    return "specialties.jsp";

  }
}
