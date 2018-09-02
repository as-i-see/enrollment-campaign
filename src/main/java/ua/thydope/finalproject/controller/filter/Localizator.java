package ua.thydope.finalproject.controller.filter;

import java.io.IOException;
import java.util.Locale;
import java.util.Optional;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.core.Config;

@WebFilter(filterName = "localizator")
public class Localizator implements Filter {

  private static Locale getLocale(String s) {
    switch (s) {
    case "en":
      return Locale.US;
    case "ru":
      return Locale.forLanguageTag("ru-RU");
    }
    return null;
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;

    String lang = Optional.ofNullable(request.getParameter("lcl")).orElse("en");
    Locale locale = Optional.ofNullable(getLocale(lang)).orElse(Locale.ENGLISH);
    Config.set(req.getSession(), Config.FMT_LOCALE, locale);
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {

  }
}
