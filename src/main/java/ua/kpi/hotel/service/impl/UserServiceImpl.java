package ua.kpi.hotel.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.kpi.hotel.model.Role;
import ua.kpi.hotel.model.User;
import ua.kpi.hotel.repository.UserRepository;
import ua.kpi.hotel.service.UserService;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final PasswordEncoder encoder;

  public UserServiceImpl(UserRepository userRepository, PasswordEncoder encoder) {
    this.userRepository = userRepository;
    this.encoder = encoder;
  }

  @Override
  public void addUser(String login, String password, boolean isAdmin) {
    var user = new User();
    user.setLogin(login);
    user.setPassword(encoder.encode(password));
    user.setRole(isAdmin ? Role.ADMIN : Role.USER);

    userRepository.save(user);
  }

  @Override
  public User getUserFromAuthentication(Authentication authentication) {
    if (authentication == null) {
      return null;
    }

    var details = authentication.getDetails();

    if (details instanceof UserDetails) {
      var casted = (UserDetails) details;
      return userRepository.findByLogin(casted.getUsername());
    }

    return null;
  }
}
