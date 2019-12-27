package ua.kpi.hotel.service;

import org.springframework.security.core.Authentication;
import ua.kpi.hotel.model.User;

public interface UserService {
  void addUser(String login, String password, boolean isAdmin);
  User getUserFromAuthentication(Authentication authentication);
}
