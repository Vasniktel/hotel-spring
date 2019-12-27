package ua.kpi.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HotelController {
  @GetMapping({"/", "/login"})
  public String getLoginPage() {
    return "login";
  }
}
