package ua.thydope.finalproject.controller.frontcommand;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.jdbc.pool.DataSource;

import ua.thydope.finalproject.component.account.Account;
import ua.thydope.finalproject.component.assessment.Assessment;
import ua.thydope.finalproject.component.assessment.AssessmentService;

public class ListAssessments implements Command {
  @Override
  public String perform(HttpServletRequest req) {
    Account account = (Account) req.getSession().getAttribute("account");
    DataSource pool = (DataSource) req.getServletContext().getAttribute("pool");
    AssessmentService service = new AssessmentService(pool);
    List<Assessment> assessments = service.assessmentList(account);
    req.setAttribute("assessments", assessments);
    return "assessments.jsp";
  }
}
