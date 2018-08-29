package ua.thydope.finalproject.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.thydope.finalproject.controller.frontcommand.Command;
import ua.thydope.finalproject.controller.frontcommand.CommandFactory;

/**
 * Servlet implementation class WebController
 */
@WebServlet("/")
public class WebController extends HttpServlet {
  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   * response)
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
    String path = request.getRequestURI();
    path = path.replaceAll(".*enrollment/", "");
    if (path.matches(".*\\..*")) {
      FileInputStream fileInputStream = null;
      OutputStream outputStream = null;
      try {
        String filename = request.getServletContext().getRealPath("/") + path;
        File file = new File(filename);
        String mimetype = request.getServletContext().getMimeType(filename);
        if (mimetype == null) {
          mimetype = "application/octet-stream";
        }
        response.setContentType(mimetype);
        fileInputStream = new FileInputStream(file);
        outputStream = response.getOutputStream();
        int bytes;
        while ((bytes = fileInputStream.read()) != -1) {
          outputStream.write(bytes);
        }
      }
      catch (Exception e) {

      }
      finally {
        fileInputStream.close();
        outputStream.close();
      }


    }
    else {
      Command command = CommandFactory.findGetCommand(path);
      path = command.perform(request);
      request.getRequestDispatcher(path).forward(request, response);
    }
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   * response)
   */
  @Override
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
