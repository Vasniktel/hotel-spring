package ua.kpi.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.kpi.hotel.service.ReservationService;
import ua.kpi.hotel.service.SecurityService;

@Controller
public class PayController {
  private final SecurityService securityService;
  private final ReservationService reservationService;

  public PayController(SecurityService securityService, ReservationService reservationService) {
    this.securityService = securityService;
    this.reservationService = reservationService;
  }

  @GetMapping("/pay")
  public String getPayPage(Model model) {
    var user = securityService.getLoggedInUser();
    var reservations = reservationService.getForUser(user);
    model.addAttribute("reservationList", reservations);
    return "pay";
  }

  @PostMapping("/pay")
  public String payForReservation(@RequestParam int reservationId, Model model) {
    reservationService.payForReservation(reservationId);
    model.addAttribute("message", "Paid");
    return "message";
  }
}
