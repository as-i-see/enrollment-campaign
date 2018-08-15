package ua.thydope.finalproject.controller.request.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {
	String perform(HttpServletRequest req);
}
