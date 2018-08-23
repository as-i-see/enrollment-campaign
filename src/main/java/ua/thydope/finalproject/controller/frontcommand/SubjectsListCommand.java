package ua.thydope.finalproject.controller.frontcommand;

import javax.servlet.http.HttpServletRequest;

class SubjectsListCommand implements Command {

  @Override
  public String perform(HttpServletRequest req) {
    // List<Subject> subjects = subjectService.getAllSubjects();
    // req.setAttribute("subjects", subjects);
    return null;
    // return "/WEB-INF/subjectsList.jsp";
  }
}
