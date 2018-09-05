package ua.thydope.finalproject.controller.frontcommand;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.jdbc.pool.DataSource;

import ua.thydope.finalproject.component.account.Account;
import ua.thydope.finalproject.component.assessment.Assessment;
import ua.thydope.finalproject.component.assessment.AssessmentService;
import ua.thydope.finalproject.controller.converter.ConversionService;

public class Assess implements Command {
  @Override
  public String perform(HttpServletRequest req) {
    Assessment assessment = ConversionService.convert(req.getParameterMap(),
        Assessment.class);
    DataSource pool = (DataSource) req.getServletContext().getAttribute("pool");
    AssessmentService service = new AssessmentService(pool);
    service.assess(assessment);
    Account account = (Account) req.getSession().getAttribute("account");
    List<Assessment> assessments = service.assessmentList(account);
    req.setAttribute("account", account);
    req.setAttribute("assessments", assessments);
    return "WEB-INF/toassess.jsp";
  }
}
