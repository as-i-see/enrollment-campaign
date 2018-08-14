package ua.thydope.finalproject.controller.requesthandling.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {
	String perform(HttpServletRequest req);
}
