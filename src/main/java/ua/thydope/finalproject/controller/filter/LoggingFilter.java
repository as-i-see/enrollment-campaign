package ua.thydope.finalproject.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingFilter implements Filter {
  private static Logger log;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    log = LoggerFactory.getLogger("ua.thydope.finalproject.logging.file");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    log.debug("Request received for URL : {} and URI : {}",
        httpRequest.getRequestURL(), httpRequest.getRequestURI());
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {}

}
