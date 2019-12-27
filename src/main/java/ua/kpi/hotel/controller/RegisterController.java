package ua.kpi.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.kpi.hotel.service.UserService;

@Controller
public class RegisterController {
  private final UserService userService;

  public RegisterController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/register")
  public String getRegisterPage() {
    return "register";
  }

  @PostMapping("/register")
  public String registerUser(
      @RequestParam String login,
      @RequestParam String password,
      @RequestParam(required = false) String isAdmin) {
    userService.addUser(login, password, isAdmin != null);
    return "register";
  }
}
