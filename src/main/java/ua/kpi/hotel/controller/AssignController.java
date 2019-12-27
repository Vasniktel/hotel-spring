package ua.kpi.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.kpi.hotel.service.ReservationService;

@Controller
public class AssignController {
  private final ReservationService reservationService;

  public AssignController(ReservationService reservationService) {
    this.reservationService = reservationService;
  }

  @PostMapping("/assign")
  public String createReservation(@RequestParam int templateId, @RequestParam int roomId, Model model) {
    reservationService.createReservation(templateId, roomId);
    model.addAttribute("message", "Added reservation for room " + roomId);
    return "message";
  }
}
