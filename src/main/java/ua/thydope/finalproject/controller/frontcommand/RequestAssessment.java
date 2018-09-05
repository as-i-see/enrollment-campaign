package ua.thydope.finalproject.controller.frontcommand;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.jdbc.pool.DataSource;

import ua.thydope.finalproject.component.account.Account;
import ua.thydope.finalproject.component.assessment.Assessment;
import ua.thydope.finalproject.component.assessment.AssessmentService;

public class RequestAssessment implements Command {
  @Override
  public String perform(HttpServletRequest req) {
    Integer subjectId = Integer.valueOf(req.getParameter("s"));
    Account account = (Account) req.getSession().getAttribute("account");
    Integer enrolleeId = account.getId();
    DataSource dataSource = (DataSource) req.getServletContext()
        .getAttribute("pool");
    AssessmentService service = new AssessmentService(dataSource);
    service.requestAssessment(enrolleeId, subjectId);
    List<Assessment> assessments = service.assessmentList(account);
    req.setAttribute("account", account);
    req.setAttribute("assessments", assessments);
    return "WEB-INF/assessments.jsp";
  }
}
