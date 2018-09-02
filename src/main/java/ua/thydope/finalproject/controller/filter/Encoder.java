package ua.thydope.finalproject.controller.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Optional;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName = "encoder", initParams = {
    @WebInitParam(name = "default", value = "UTF-8")
})
public class Encoder implements Filter {
  private String defaultEnc;

  @Override
  public void init(FilterConfig filterConfig) {
    defaultEnc = filterConfig.getInitParameter("locale-default");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    
      Optional.ofNullable(defaultEnc).filter((de) ->
          !de.equalsIgnoreCase(request.getCharacterEncoding())
      ).ifPresent((encodingToSet) -> {
        try {
          request.setCharacterEncoding(encodingToSet);
          response.setCharacterEncoding(encodingToSet);
        }
        catch (UnsupportedEncodingException e) {
          e.printStackTrace();
        }

      });
      chain.doFilter(request, response);
  }

  @Override
  public void destroy() {
    defaultEnc = null;
  }
}
