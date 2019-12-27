package ua.kpi.hotel.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.kpi.hotel.model.Room;
import ua.kpi.hotel.service.SecurityService;
import ua.kpi.hotel.service.TemplateService;

import java.time.LocalDate;

@Controller
public class TemplateController {
  private final SecurityService securityService;
  private final TemplateService templateService;

  public TemplateController(SecurityService securityService, TemplateService templateService) {
    this.securityService = securityService;
    this.templateService = templateService;
  }

  @GetMapping("/template")
  public String getTemplateCreationPage() {
    return "reservation_template";
  }

  @PostMapping("/template")
  public String createTemplate(
      @RequestParam int roomSize,
      @RequestParam Room.Type roomType,
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
    System.out.println("post");
    var user = securityService.getLoggedInUser();
    templateService.createTemplate(roomSize, roomType, user, startDate, endDate);
    return "reservation_template";
  }
}
