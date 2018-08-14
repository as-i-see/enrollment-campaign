package ua.thydope.finalproject.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.thydope.finalproject.controller.requesthandling.command.Command;
import ua.thydope.finalproject.controller.requesthandling.command.CommandFactory;
import ua.thydope.finalproject.controller.requesthandling.command.URICommandFactory;

/**
 * Servlet implementation class WebController
 */
@WebServlet("/")
public class WebController extends HttpServlet {

  private static CommandFactory<String> commandFactory;

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    commandFactory = new URICommandFactory();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
    String path = request.getRequestURI();
    path = path.replaceAll(".*/", "");
    Command command = commandFactory.getCommand(path).orElse(new Command() {

      @Override
      public String perform(HttpServletRequest req) {
        return "index.jsp";
      }

    });
    String page = command.perform(request);
    request.getRequestDispatcher(page).forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  @Override
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
