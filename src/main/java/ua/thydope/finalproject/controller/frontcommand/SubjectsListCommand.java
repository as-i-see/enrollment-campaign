package ua.thydope.finalproject.controller.frontcommand;

import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.jdbc.pool.DataSource;
import ua.thydope.finalproject.component.subject.Subject;
import ua.thydope.finalproject.component.subject.SubjectService;

class SubjectsListCommand implements Command {

  @Override
  public String perform(HttpServletRequest req) {
    //List<Subject> subjects = subjectService.getAllSubjects();
    //req.setAttribute("subjects", subjects);
    return null;
    //return "/WEB-INF/subjectsList.jsp";
  }

}
