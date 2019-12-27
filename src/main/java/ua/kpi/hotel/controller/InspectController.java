package ua.kpi.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.kpi.hotel.service.ReservationService;

@Controller
public class InspectController {
  private final ReservationService reservationService;

  public InspectController(ReservationService reservationService) {
    this.reservationService = reservationService;
  }

  @GetMapping("/inspect")
  public String getInspectPage(Model model) {
    var reservations = reservationService.getAll();
    model.addAttribute("reservationList", reservations);
    return "inspect";
  }

  @PostMapping("/inspect")
  public String inspectReservation(@RequestParam int reservationId, Model model) {
    reservationService.delete(reservationId);
    model.addAttribute("message", "Deleted reservation");
    return "message";
  }
}
