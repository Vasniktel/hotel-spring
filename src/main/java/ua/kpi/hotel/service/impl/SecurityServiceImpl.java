package ua.kpi.hotel.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ua.kpi.hotel.model.User;
import ua.kpi.hotel.repository.UserRepository;
import ua.kpi.hotel.service.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService {
  private final UserRepository userRepository;
  private final UserDetailsService detailsService;
  private final AuthenticationManager manager;

  public SecurityServiceImpl(
      UserRepository userRepository,
      @Qualifier("userDetailsServiceImpl") UserDetailsService detailsService,
      AuthenticationManager manager) {
    this.userRepository = userRepository;
    this.detailsService = detailsService;
    this.manager = manager;
  }

  @Override
  public User getLoggedInUser() {
    var userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    if (userDetails instanceof UserDetails) {
      var details = (UserDetails) userDetails;
      var login = details.getUsername();
      return userRepository.findByLogin(login);
    }

    return null;
  }
}
