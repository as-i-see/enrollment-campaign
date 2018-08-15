package ua.thydope.finalproject.controller.request.command;

import java.util.Optional;

import ua.thydope.finalproject.model.dao.DAOFactory;
import ua.thydope.finalproject.model.subject.SubjectDAO;
import ua.thydope.finalproject.model.subject.SubjectService;

public class URICommandFactory implements CommandFactory<String> {
  @Override
  public Optional<Command> getCommand(String location) {
    switch (location) {
    case "subjects":
      SubjectDAO dao = DAOFactory.getInstance().subjectDAO();
      SubjectService service = new SubjectService(dao);
      Command command = new SubjectsListCommand(service);
      return Optional.of(command);
    }
    return Optional.empty();
  }

}
