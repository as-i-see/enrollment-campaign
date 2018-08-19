package ua.thydope.finalproject.controller.frontcommand;

import javax.servlet.http.HttpServletRequest;

public interface Command {
	String perform(HttpServletRequest req);
}
