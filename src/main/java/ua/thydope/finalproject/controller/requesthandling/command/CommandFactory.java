package ua.thydope.finalproject.controller.requesthandling.command;

import java.util.Optional;

public interface CommandFactory<T> {
  Optional<Command> getCommand(T location);
}
