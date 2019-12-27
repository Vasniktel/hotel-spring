package ua.kpi.hotel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.kpi.hotel.repository.UserRepository;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  private final UserRepository userRepository;

  public UserDetailsServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    var user = userRepository.findByLogin(login);
    if (user == null) throw new UsernameNotFoundException(login);

    var userLogin = user.getLogin();
    var userPassword = user.getPassword();
    var authorities = Collections.singleton(new SimpleGrantedAuthority(user.getRole().name()));
    return new org.springframework.security.core.userdetails.User(userLogin, userPassword, authorities);
  }
}
