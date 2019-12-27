package ua.kpi.hotel;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RoleBasedDispatcher implements AuthenticationSuccessHandler {
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                      Authentication authentication) throws IOException, ServletException {
    var authorities = authentication.getAuthorities();

    for (var authority : authorities) {
      switch (authority.getAuthority()) {
        case "ADMIN":
          response.sendRedirect("/reserve");
          break;
        case "USER":
          response.sendRedirect("/template");
      }
    }
  }
}
