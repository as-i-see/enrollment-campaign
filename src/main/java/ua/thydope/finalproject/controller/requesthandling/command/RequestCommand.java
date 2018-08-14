package ua.thydope.finalproject.controller.requesthandling.command;

import javax.servlet.http.HttpServletRequest;

public interface RequestCommand {
	String perform(HttpServletRequest req);
}
