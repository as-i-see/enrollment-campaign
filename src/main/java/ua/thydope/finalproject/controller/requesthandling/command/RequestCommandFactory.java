package ua.thydope.finalproject.controller.requesthandling.command;

public interface RequestCommandFactory<T> {
	RequestCommand getHandling(T location);
}
