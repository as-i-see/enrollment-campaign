package ua.thydope.finalproject.controller.request.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ua.thydope.finalproject.model.subject.Subject;
import ua.thydope.finalproject.model.subject.SubjectService;

class SubjectsListCommand implements Command {
  private SubjectService subjectService;

  SubjectsListCommand(SubjectService subjectService) {
    this.subjectService = subjectService;
  }

  @Override
  public String perform(HttpServletRequest req) {
    List<Subject> subjects = subjectService.getAllSubjects();
    req.setAttribute("subjects", subjects);
    return "/WEB-INF/subjectsList.jsp";
  }

}
